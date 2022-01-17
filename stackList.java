class StackList
{   
    //Implement Stack using Linked List
    SingleLinkedList myList;
    

    public StackList()
    {
        myList = new SingleLinkedList();
    }
    
    public void Push(MergableHeap heap)
    {
        myList.Insert(heap);
    }

    public void Peek()
    {
        System.out.print(myList.head.key);
    }
    
    public MergableHeap Pop()
    {
        if(myList.head == null) 
        {
            System.out.print("Stack Empty - Underflow error");
            return null;
        }
        else
        {
            MergableHeap temp = myList.head.key;
            myList.head = myList.head.next;
            return temp;
        }
        
    }

}