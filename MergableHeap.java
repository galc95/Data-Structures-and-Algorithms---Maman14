abstract class MergableHeap
{
    DualLinkedList heapList;

    public MergableHeap()
    {
        heapList = new DualLinkedList(); 
    }
    
    public void Insert(int num)
    {
        
    }

    public int ExtractMin()
    {   
        System.out.println("This function is overrided by every heap");
        return Integer.MAX_VALUE;
    }

    public int Minimum()
    {
        System.out.println("the minimum node has a value of ("+Integer.toString(heapList.NIL.next.key)+")");
        return heapList.NIL.next.key;
    }


    public void Union(MergableHeap heap)
    {
        
    }

    public void printHeap()
    {
        heapList.ListPrint();
    }
    



    
}