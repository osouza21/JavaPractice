package ctci;

public class TailAndSize {
    public Node tail;
    public int size;

    /**
     * Constructor for data structur to hold tail node and size of a linked list
     * @param tail tail node
     * @param size size of a linked
     */
    public TailAndSize(Node tail, int size){
        this.tail = tail;
        this.size = size;
    }

    /**
     * Get the tail node of a linked list and the size of the linked list nad return a TailAndSize object
     * @param node head node of list
     * @return TailAndSize object containing the tail node and the size of the linked list
     */
    public static TailAndSize getTailAndSize(Node node) {
        if(node == null) return null;

        int size = 1;
        Node current = node;
        while(current.next != null){
            size++;
            current = current.next;
        }
        return new TailAndSize(current, size);
    }
}
