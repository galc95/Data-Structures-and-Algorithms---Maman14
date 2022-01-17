class Unordered extends MergableHeap
{
    //DualLinkedList heapList = new DualLinkedList();
    
    public void Insert(int num)                     //O(n)      
    {                                               //must check if num exists (iterate over entire list - worst case n)
        if (heapList.NIL.next.key > num)//O/(1)     //skip check if head (min value) is larger than num, if true insert it to the begining of the list.
        {
            heapList.HeadInsert(num);   //O(1)      //minimum node will always be the head      
        }

        else if (!heapList.Exists(num)) //O(n)      //iterate over list to see if it exists
        {
            heapList.TailInsert(num);     //O(1)      //if not insert to tail
        }
        
        else                                        
        {
            System.out.println("Node with value (" + Integer.toString(num) + ") already exists. Node was not inserted");
        }
    
    }

    public int ExtractMin()                                         //same as UnorderedUnique list O(n)
    {
        int min = heapList.NIL.next.key;                            //save initial head node minimum value
        heapList.ListDelete(heapList.NIL.next);                     //remove head node from the list
        
        DualLinkedList.DualNode minNode = heapList.NIL.next;        //node that holds min value
        DualLinkedList.DualNode current = heapList.NIL.next;        //iterator

        while (current != heapList.NIL)                             //iterate over list
        {
            if (current.key < minNode.key)                          //check if key is smaller than previous keys
            {
                minNode = current;                                  //update minNode if its key is smaller than all previous keys
            }
            current = current.next;                                 //iterate to next node
        }
        heapList.ListDelete(minNode);                               //remove the minNode from the list
        Insert(minNode.key);                                        //Insert new node with the new minimum value

        System.out.println("The minimum node with value ("+Integer.toString(min) + ") has been extracted.");
        System.out.println("The new minimum key is ("+Integer.toString(minNode.key) +")");
        return min;                                                             
    }


    public void Union(MergableHeap merge)                        //O(n1) * O(n2) = O(n^2)
    { 
        DualLinkedList.DualNode current = merge.heapList.NIL.next;

        while (current != merge.heapList.NIL)                        //O(n)
        {
            Insert(current.key);                                     //O(n)
            current = current.next;                                  
        }
    }

 
}