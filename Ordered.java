class Ordered extends MergableHeap
{
    //DualLinkedList heapList;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void Insert(int num)
    {   
        //insert node to the value
        //case 1: num is the minimum value - loop condition not met, current.prev = NIL, insert after NIL(head)
        //case 2: num is not minimum or max - loop will terminate when node with identical or larger value reached. 
        //        num will be inserted before that value only if it is different than the terminating node.
        //case 3: num is the max value - loop will terminate when current = NIL. insert after last node (tail)
        
        if(num < heapList.NIL.next.key)
        {
            heapList.HeadInsert(num);
        }
        else if (num > heapList.NIL.prev.key)
        {
            heapList.TailInsert(num);
        }
        else
        {    
            DualLinkedList.DualNode current = heapList.NIL.next.next;

            while (current.key < num && current.next != heapList.NIL) // O(n)
            {
                current = current.next;
            }   
            if (current.key != num)
            {
                heapList.InsertAfter(num, current.prev);                  
            }
            else
            {
                System.out.println("Node with value (" + Integer.toString(num) + ") already exists. Node was not inserted");
            }
        }
    }

    public int ExtractMin()
    {
        int min = heapList.NIL.next.key;
        heapList.ListDelete(heapList.NIL.next);
        return min;        
    }


    public void Union(MergableHeap merge)
    {   
        //check if one lists values are smaller than another list
        if (heapList.NIL.prev.key < merge.heapList.NIL.next.key)
        {
            heapList.AttachList(merge.heapList);
            return;
        }
        else if (merge.heapList.NIL.prev.key < heapList.NIL.next.key)
        {
            merge.heapList.AttachList(heapList);
            heapList = merge.heapList;
            return;
        }

        //define iterators and a new list.
        DualLinkedList newList = new DualLinkedList();
        DualLinkedList.DualNode c1 = heapList.NIL.next;
        DualLinkedList.DualNode c2 = merge.heapList.NIL.next;


        while (c1 != heapList.NIL && c2 != merge.heapList.NIL)  //iterate over nodes in both lists from head to tail, stop once the end of either list is reached - O(n) in worst case
        {
            if (c1.key < c2.key)                                //append the lowest value to the tail of the list and iterate to the next node
            {                                                   //list will stay ordered as input list
               newList.TailInsert(c1.key);
               c1 = c1.next;
            }
            else if (c1.key > c2.key)
            {
                newList.TailInsert(c2.key);
                c2 = c2.next;
            }
            else if (c1.key == c2.key)
            {
                newList.TailInsert(c1.key);                     //insert node with shared value to the end of the list
                int dup = c1.key;                               //remove all nodes with the same value from both lists
                while (dup == c1.key)
                {
                    c1 = c1.next;
                }
                while (dup == c2.key)
                {
                    c2 = c2.next;
                }

            }

        }   
                                                                //remaining list will be larger than the max value of newList (tail node)
        if (c1 == heapList.NIL)                                 //O(1) either c1 or c2 will be NIL (to their respective list) at this step. The other list will have at least 1 node.
        {                                                       //Append the remaining list to the new list
            merge.heapList.NIL.next = c2;
            c2.prev = merge.heapList.NIL;                       //shorten list to start from c2
            newList.AttachList(merge.heapList);                 //attach shortened list to the end of the newList
        }
        else                                                    //O(1)
        {                                                       //shorten this list to start from c1
            heapList.NIL.next = c1;
            c1.prev = heapList.NIL;                                     
            newList.AttachList(heapList);                       //append shortened list to the new list        
        }

        heapList = newList;
    }
    

}