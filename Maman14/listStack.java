class listStack
{   
    //Implement Stack using Linked List
    SingleLinkedList myList;

    public listStack()
    {
        myList = new SingleLinkedList();
    }
    
    public void Push(MergableHeap heap)
    {
        myList.Insert(heap);

    }

    public MergableHeap Peek()
    {
        //System.out.print(myList.head.key);
        return myList.head.key;
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
            //System.out.print(temp);
            return temp;
        }
        
    }

}