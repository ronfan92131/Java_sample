import java.util.ArrayList;
import java.util.List;

class LinkedList
{
    Node head;  // head of list

    /* Linked list Node*/
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }

    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    /* Inserts a new node after the given prev_node. */
    public void insertAfter(Node prev_node, int new_data)
    {
        /* 1. Check if the given Node is null */
        if (prev_node == null)
        {
            System.out.println("The given previous node cannot be null");
            return;
        }

        /* 2 & 3: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        /* 4. Make next of new Node as next of prev_node */
        new_node.next = prev_node.next;

        /* 5. make next of prev_node as new_node */
        prev_node.next = new_node;
    }

    /* Appends a new node at the end.  This method is
       defined inside LinkedList class shown above */
    public void append(int new_data)
    {
        /* 1. Allocate the Node &
           2. Put in the data
           3. Set next as null */
        Node new_node = new Node(new_data);

        /* 4. If the Linked List is empty, then make the
              new node as head */
        if (head == null)
        {
            head = new Node(new_data);
            return;
        }

        /* 4. This new node is going to be the last node, so
              make next of it as null */
        new_node.next = null;

        /* 5. Else traverse till the last node */
        Node last = head;
        while (last.next != null)
            last = last.next;

        /* 6. Change the next of last node */
        last.next = new_node;
        return;
    }

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static Node reverse(Node head) {
        // plan:
        // define three node to keep track, prev, curr, fwd
        // at start, curr = head, prev = null
        // if curr.next valid, fwd step forward; then curr point to prev;
        //        then prev step to curr; curr step to fwd
        // loop until curr.next is null, wire back to prev, move head to curr
        Node prev, curr, fwd;

        prev = null;
        curr = head;
        while (curr.next != null){
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        curr.next = prev;
        head = curr;
        return head;
    }

    /* This function prints contents of linked list starting from
        the given node */
    public static void printList(Node head)
    {
        Node tnode = head;
        while (tnode != null)
        {
            System.out.print(tnode.data+" ");
            tnode = tnode.next;
        }
    }

    /* Driver program to test above functions. Ideally this function
       should be in a separate user class.  It is kept here to keep
       code compact */
    public static void main(String[] args)
    {
        /* Start with the empty list */
        LinkedList llist = new LinkedList();
        // Insert 6.  So linked list becomes 6->NUllist
        llist.append(6);
        // Insert 7 at the beginning. So linked list becomes
        // 7->6->NUllist
        llist.push(7);
        // Insert 1 at the beginning. So linked list becomes
        // 1->7->6->NUllist
        llist.push(1);
        // Insert 4 at the end. So linked list becomes
        // 1->7->6->4->NUllist
        llist.append(4);
        // Insert 8, after 7. So linked list becomes
        // 1->7->8->6->4->NUllist
        llist.insertAfter(llist.head.next, 8);
        
        System.out.println("\nCreated Linked list is: ");
        printList(llist.head);

        System.out.println("\n Linked list reversal:  ");
        Node llist1 = reverse(llist.head);
        printList(llist1);
        
        // Can we create an ArrayList just like a linked list? 
        List<Integer> arrlist = new ArrayList<>();
        // add 6.  So arrlist.toString(): [6]
        arrlist.add(6);
        // add 7 at the beginning.  So arrlist.toString(): [7, 6]
        arrlist.add(0, 7);
        // add 1 at the beginning.  So arrlist.toString(): [1, 7, 6]
        arrlist.add(0, 1);
        // "append" 4 at the end  So arrlist.toString(): [1, 7, 6, 4]
        int size = arrlist.size();
        arrlist.add(size, 4);
        // insert 8 after 7   So arrlist.toString(): [1, 7, 8, 6, 4]
        int position = arrlist.indexOf(7);
        arrlist.add(position+1, 8);

        System.out.println("\nCreated Array list is: " );
        System.out.printf(arrlist.toString());

        // can we do array list reversal? what a joke :)
    }
    
}
