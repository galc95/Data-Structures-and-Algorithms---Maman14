class UnorderedUnique extends MergableHeap
{
 
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
    public UnorderedUnique()
    {
        heapList = new DualLinkedList();
    }


    public void Insert(int num)
    {
        DualLinkedList.DualNode head = heapList.NIL.next;
        if (num < head.key)             //if new value is smaller than the minimum, insert to front of list
        {
            heapList.HeadInsert(num);
        }
        else                            //else insert to tail of the list
        {
            heapList.TailInsert(num);
        }
    
    }

    public int ExtractMin()
    {
        int min = heapList.NIL.next.key;
        heapList.ListDelete(heapList.NIL.next);
        DualLinkedList.DualNode minNode = heapList.NIL.next;
        DualLinkedList.DualNode current = heapList.NIL.next;
        

        while (current != heapList.NIL)
        {
            if (current.key < minNode.key)
            {
                minNode = current;
            }
            current = current.next;
        }
        heapList.ListDelete(minNode);
        heapList.HeadInsert(minNode.key);
        System.out.println("The minimum node with value ("+Integer.toString(min) + ") has been extracted. The new minimum node has value of (" +Integer.toString(minNode.key) +").");
        return min;
    }

    public void Union(MergableHeap merge) //O(1)
    {
        DualLinkedList.DualNode current = merge.heapList.NIL.next;
        if (heapList.NIL.next.key < current.key)
        {
            heapList.AttachList(merge.heapList); //O(1)
        }
        else
        {
            merge.heapList.AttachList(heapList); //O(1)
            heapList = merge.heapList;           //O(1)
        }
        
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


}
