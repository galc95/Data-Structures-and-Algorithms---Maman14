public class SingleLinkedList
{

    SingleNode head;
    SingleNode tail;
    
    public void PrintText()
    {
        System.out.print("woof");
    }
    

    public SingleNode Search(MergableHeap item)
    {
        SingleNode x = head;
        while((x != tail) & (x.key != item)) 
        {
            x = x.next;
        }
        return x;
    }

    public void Insert(MergableHeap item)
    {
        SingleNode x = new SingleNode(item);
        if (head != null)
        {
            x.next = head;
        }
        head = x; 
    }

    public void InsertLast(MergableHeap item)
    {
        SingleNode x = new SingleNode(item);
        if (head == null)
            {
                head = x;
                tail = x;
                x.next = null;
            }
        else
        {
            tail.next = x;
            tail = x;
            x.next = null;
        }
        
    }


    public void Delete(MergableHeap item)
    {
        if (head != null)
        {
            SingleNode currentNode = head;
            SingleNode previousNode = null;
            
            if (head.key == item)
            {

            }
            while (currentNode.key != item)
            {
                if (currentNode.next != null)
                {
                    previousNode = currentNode;
                    currentNode = currentNode.next;
                }
                else
                {
                    System.out.print("Reached end of list, value not found");
                }
            }
            previousNode.next = currentNode.next;
            //update tail if deleted node was the last node
            if (previousNode.next == null)
            {
                tail = previousNode;
            }
        }
    }

    public static class SingleNode
    { 
        MergableHeap key;
        SingleNode next;

        SingleNode(MergableHeap data)
        {
            key = data;
            next = null;
        }
    }
}
