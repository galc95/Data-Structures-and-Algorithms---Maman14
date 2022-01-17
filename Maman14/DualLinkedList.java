public class DualLinkedList
{
//add comment
/////////////////////////////////////////////////////////////////// List Variables //////////////////////////////////////////////////////////////

    DualNode NIL;
    //head = NIL.next
    //tail = NIL.prev

///////////////////////////////////////////////////////////////// Constructor methods //////////////////////////////////////////////////////////
    DualLinkedList()
    {
        //constructor for new linked-list creation
        NIL = new DualNode();
        NIL.next = NIL;
        NIL.prev = NIL;
        NIL.key = Integer.MIN_VALUE;

    }
/////////////////////////////////////////////////////////////////// insert methods /////////////////////////////////////////////////////////////

    public void HeadInsert(int num)
    {
        DualNode newNode = new DualNode(num); //create new dualNode object

        //insert node at the beginning of the list   
        newNode.next = NIL.next; //set new node's next pointer to the previous head node
        NIL.next.prev = newNode; //set previous head node's prev pointer to the new node
        NIL.next = newNode;      //set head pointer to the new node
        newNode.prev = NIL;      //set inserted node's prev pointer to NIL


        System.out.println("New Node inserted at the BEGINNING of the list with value (" + Integer.toString(num) +")");

    }
    public void TailInsert(int num)
    {
        DualNode newNode = new DualNode(num); //create new dualNode object

        //insert new node
        newNode.prev = NIL.prev; //change new node's prev pointer to the previous last node
        NIL.prev.next = newNode; //change last node's next pointer to the inserted node
        NIL.prev = newNode;      //set tail pointer to the inserted node
        newNode.next = NIL;      //set inserted node's next pointer to NIL

        System.out.println("New Node inserted at the END of the list with value ("+ Integer.toString(num)+")");

    }


    public void InsertAfter(int num, DualNode node)
    {
        DualNode newNode = new DualNode(num);

        newNode.prev = node;
        newNode.next = node.next;
        node.next.prev = newNode;
        node.next = newNode;

        System.out.println("Node with value (" + Integer.toString(num) + ") inserted after node with value [" + Integer.toString(node.key) + "]");
    }

    public void AttachList(DualLinkedList tailList)
    {
        tailList.NIL.next.prev = NIL.prev;
        tailList.NIL.prev.next = NIL;
        NIL.prev.next = tailList.NIL.next;
        NIL.prev = tailList.NIL.prev;
        
    }

///////////////////////////////////////////////////////////// Search and Delete methods ///////////////////////////////////////////////////////

    public DualNode ListSearch(int num)
    {

        DualNode currentNode = NIL.next;
        while (currentNode != NIL && currentNode.key != num)
        {
            currentNode = currentNode.next;
        }
        if (currentNode == NIL)
        {
            System.out.println("Node with value ("+num+") not found");
            return null;
        }
        return currentNode;
        
    }
    public boolean Exists(int num)
    {
        DualNode currentNode = NIL.next;
        while (currentNode != NIL && currentNode.key != num)
        {
            currentNode = currentNode.next;
        }
        if (currentNode == NIL)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public void ListDelete(DualNode delNode)
    {
        if (delNode != NIL)
        {
            delNode.next.prev = delNode.prev;
            delNode.prev.next = delNode.next;
            System.out.println("Node with value (" + Integer.toString(delNode.key) + ") has been deleted");
        }
        else
        {
            
        }
      
    }


////////////////////////////////////////////////////////////////////// State methods ////////////////////////////////////////////////////////////

    public void ListPrint()
    {
        DualNode current = NIL.next;
        System.out.print("MIN ->");
        while (current != NIL) //stop when last node has been reached
        {
            //print current node
            System.out.print(" ["+Integer.toString(current.key)+"]");

            //iterate to next node
            current = current.next;
        }
        System.out.print("\n"); 
    }


    public boolean isEmpty()
    {
        if (NIL.next == NIL)
        {
            return true;
        }
        else
        {
            return false;
        }
    }



/////////////////////////////////////////////////////////////////// Node Class Definition //////////////////////////////////////////////////////
    public static class DualNode
    {
        int key;
        DualNode prev;
        DualNode next;

        DualNode(int num)
        {
            key = num;
        }
        DualNode()
        {
            key = Integer.MAX_VALUE;

        }

    }
}