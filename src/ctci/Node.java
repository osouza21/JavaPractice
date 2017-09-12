package ctci;

public class Node {
    Node next = null;
    int data;

    /**
     * Node constructor
     * @param d data to store in the node
     */
    public Node(int d){
        data = d;
    }

    /**
     * Append a new node with data d to the end of linked list
     * @param d data to append to the end of the linked list
     */
    public void appendToTail(int d){
        Node end = new Node(d);
        Node n = this;
        while(n.next != null){
            n = n.next;
        }
        n.next = end;
    }
}
