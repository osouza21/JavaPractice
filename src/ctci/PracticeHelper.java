package ctci;

public class PracticeHelper {

    /**
     * Sort the given string by char value
     * @param s String to sort
     * @return sorted string
     */
    public static String sort(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    /**
     * get the length of a linked list from the head node
     * @param head the head node of the linked list
     * @return int length of the linked list
     */
    public static int linkedListLength(Node head){
        int length = 1;
        Node n = head;
        while(n.next != null){
            length++;
            n = n.next;
        }
        return length;
    }

    /**
     * given a head node return an array of integers in the linkedlist
     * @param head the head node of a linked list
     * @return an array of integers within the linked list
     */
    public static int[] nodeToArray(Node head) {
        int length = linkedListLength(head);
        int[] arr = new int[length];
        Node n = head;
        for(int i = 0; i < length; i++){
            arr[i] = n.data;
            n = n.next;
        }
        return arr;
    }

    /**
     * Get the kth node from a list.
     * @param node head of linked list
     * @param k index of node to get
     * @return node at the kth spot of null
     */
    public static Node getKthNode(Node node, int k) {
        Node current = node;
        while(k > 0 && current != null){
            current = current.next;
            k--;
        }
        return current;
    }

    /**
     * Build a linked list from a integer array and return the head node
     * @param data the array to build a linked list from
     * @return the head node or null if data is empty
     */
    public static Node buildLinkedList(int[] data){
        if(data.length < 1) return null;

        Node head = new Node(data[0]);

        for(int i = 1; i < data.length; i++){
            head.appendToTail(data[i]);
        }

        return head;
    }
}
