package ctci;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LinkedListsTest {
    @Test
    void sumList() {
        Node node1 = buildLinkedList(new int[]{7,1,6});
        Node node2 = buildLinkedList(new int[]{5,9,2});
        Node results = LinkedLists.sumList(node1, node2);
        int[] arr = PracticeHelper.nodeToArray(results);
        assertTrue(Arrays.equals(arr, new int[]{2,1,9}));
    }

    @Test
    void kthToLast() {
        Node head = buildLinkedList(new int[]{2,4,4,3,2});
        int kth = LinkedLists.kthToLast(head,3);

        assertTrue(kth == 4);
    }

    @Test
    void removeDuplicates() {
        Node head = buildLinkedList(new int[]{2,4,4,3,2});
        Node newHead = LinkedLists.removeDuplicates(head);
        int[] arr = PracticeHelper.nodeToArray(newHead);
        assertTrue(Arrays.equals(arr, new int[]{2,4,3}));
    }

    @Test
    void removeDuplicatesNoBuffer() {
        Node head = buildLinkedList(new int[]{2,4,4,3,2});
        Node newHead = LinkedLists.removeDuplicatesNoBuffer(head);
        int[] arr = PracticeHelper.nodeToArray(newHead);
        assertTrue(Arrays.equals(arr, new int[]{2,4,3}));
    }

    @Test
    void deleteNode() {
        Node head = buildLinkedList(new int[]{2,4,6,3});
        Node newHead = LinkedLists.deleteNode(head, 4);
        int[] arr = PracticeHelper.nodeToArray(newHead);
        assertTrue(Arrays.equals(arr, new int[]{2,6,3}));
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