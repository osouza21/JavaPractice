package ctci;

import java.util.HashSet;

public class LinkedLists {

    /**
     * Given a head node of a linked list remove the node with data d from the list
     * @param head head node of the linked list
     * @param d data of the node to remove
     * @return the head node of the list with the node remove
     */
    public static Node deleteNode(Node head, int d){
        Node n = head;

        if(n.data == d){
            return head.next;
        }

        while(n.next !=  null){
            if(n.next.data == d){
                n.next = n.next.next;
                return n;
            }
            n = n.next;
        }
        return head;
    }

    /**
     * Remove duplicate nodes from an unsorted linked list
     * @param head the head node of the linked list
     * @return The head of the linked list with duplicates removed
     */
    public static Node removeDuplicatesNoBuffer(Node head){
        Node current = head;
        while(current.next != null){
            Node runner = current;
            while(runner.next != null) {
                if (current.data == runner.next.data) {
                    runner.next = runner.next.next;
                }else{
                    runner = runner.next;
                }
            }
            current = current.next;
        }
        return head;
    }

    /**
     * Remove duplicate nodes from an unsorted linked list
     * @param head the head node of the linked list
     * @return The head of the linked list with duplicates removed
     */
    public static Node removeDuplicates(Node head){
        HashSet<Integer> set = new HashSet<Integer>();
        Node n = head;
        Node previous = null;
        while(n != null){
            if(set.contains(n.data)){
                previous.next = n.next;
            } else {
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }
        return head;
    }

    /**
     * implement an algorithm to find the kth to the last element of a singly linked list.
     * @param head head node of linked list
     * @param k index of last element to return
     * @return data of the kth to last element
     */
    public static int kthToLast(Node head, int k){
        KthToLast kthToLast = new KthToLast(head, k);
        return kthToLast.kth;
    }

    /**
     * Implement an algorithm to delete a node in the middle of a singly linked list. given only access to  that node
     * @param n node to remove
     * @return true if succesful
     */
    public static boolean deleteMiddleNode(Node n){
        if(n == null || n.next == null) return false;

        Node next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }

    /**
     * Partition a linked list around a given int.
     * @param node linked list head node
     * @param k int to partition around
     * @return new partiniton list head node
     */
    public static Node partitionNode(Node node, int k){
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;

        while(node != null){
            Node next = node.next;
            node.next = null;
            if(node.data < k){
                if(beforeStart == null){
                    beforeStart = node;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
            } else {
                if(afterStart == null){
                    afterStart = node;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = node;
                    afterEnd = node;
                }
            }
        }

        if(afterStart == null){
            return beforeStart;
        }

        beforeEnd.next = afterStart;
        return beforeStart;
    }

    /**
     * Yo have two numbers represeneted by a linked list, where each node contains and single digit. the digits are
     * are stored in reverse order .add these two numbers and return a linked list with the sum in reverse
     * @param node1 first number
     * @param node2 second number
     * @return linked list with the sum of the two numbers
     */
    public static Node sumList(Node node1, Node node2){
        int remainder = 0;
        Node newNode;
        int n1 = node1.data;
        int n2 = node2.data;

        newNode = new Node(n1 + n2 + remainder);
        remainder = 0;
        if(newNode.data >= 10){
            newNode.data = newNode.data - 10;
            remainder = 1;
        }
        Node n = newNode;
        while(node1.next != null || node2.next != null){
            n1 = 0;
            n2 = 0;
            if(node1.next != null){
              n1 = node1.next.data;
              node1 = node1.next;
            }
            if(node2.next != null){
                n2 = node2.next.data;
                node2 = node2.next;
            }

            n.next = new Node(n1 + n2 + remainder);
            remainder = 0;
            if(n.next.data >= 10){
                n.next.data = n.next.data - 10;
                remainder = 1;
            }
            n = n.next;
        }
        return newNode;
    }

    /**
     * Book answer
     * You have two numbers represeneted by a linked list, where each node contains and single digit. the digits are
     * are stored in reverse order .add these two numbers and return a linked list with the sum in reverse
     * @param l1 first number
     * @param l2 second number
     * @return linked list with the sum of the two numbers
     */
    public static Node addListRecursive(Node l1, Node l2, int carry){
        if(l1 == null && l2 == null && carry == 0) return null;

        Node result = new Node(0);
        int value = carry;
        if(l1 != null){
            value += l1.data;
        }
        if(l2 != null){
            value += l2.data;
        }

        result.data = value % 10;

        if(l1 != null || l2 != null){
            Node more = addListRecursive(l1 == null ? null : l1.next,
                                         l2 == null ? null : l2.next,
                                         value >= 10 ? 1 : 0);
            result.next = more;
        }
        return result;
    }
}
