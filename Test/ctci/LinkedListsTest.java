package ctci;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LinkedListsTest {
    @Test
    void deleteMiddleNode() {
    }

    @Test
    void partitionNode() {
    }

    @Test
    void addListRecursive() {
    }

    @Test
    void intersection() {
        Node node1 = PracticeHelper.buildLinkedList(new int[]{1,2,3,4,5,6,7,8});
        Node node2 = new Node(5);
        Node node3 = new Node(7);
        node2.next = node3;
        node3.next = PracticeHelper.getKthNode(node1, 4);

        assertTrue(LinkedLists.intersection(node2, node1).data == 5);

    }

    @Test
    void isPalindrome() {
        Node node = PracticeHelper.buildLinkedList(new int[]{0,1,2,1,0});
        assertTrue(LinkedLists.isPalindrome(node));
    }

    @Test
    void sumList() {
        Node node1 = PracticeHelper.buildLinkedList(new int[]{7,1,6});
        Node node2 = PracticeHelper.buildLinkedList(new int[]{5,9,2});
        Node results = LinkedLists.sumList(node1, node2);
        int[] arr = PracticeHelper.nodeToArray(results);
        assertTrue(Arrays.equals(arr, new int[]{2,1,9}));
    }

    @Test
    void kthToLast() {
        Node head = PracticeHelper.buildLinkedList(new int[]{2,4,4,3,2});
        int kth = LinkedLists.kthToLast(head,3);

        assertTrue(kth == 4);
    }

    @Test
    void removeDuplicates() {
        Node head = PracticeHelper.buildLinkedList(new int[]{2,4,4,3,2});
        Node newHead = LinkedLists.removeDuplicates(head);
        int[] arr = PracticeHelper.nodeToArray(newHead);
        assertTrue(Arrays.equals(arr, new int[]{2,4,3}));
    }

    @Test
    void removeDuplicatesNoBuffer() {
        Node head = PracticeHelper.buildLinkedList(new int[]{2,4,4,3,2});
        Node newHead = LinkedLists.removeDuplicatesNoBuffer(head);
        int[] arr = PracticeHelper.nodeToArray(newHead);
        assertTrue(Arrays.equals(arr, new int[]{2,4,3}));
    }

    @Test
    void deleteNode() {
        Node head = PracticeHelper.buildLinkedList(new int[]{2,4,6,3});
        Node newHead = LinkedLists.deleteNode(head, 4);
        int[] arr = PracticeHelper.nodeToArray(newHead);
        assertTrue(Arrays.equals(arr, new int[]{2,6,3}));
    }

}