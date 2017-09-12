package ctci;

public class KthToLast {
    public int kth;

    public KthToLast(Node head, int k) {
        findKthToLast(head, k);
    }

    private int findKthToLast(Node node, int k) {
        if(node.next == null) return 1;

        int index = findKthToLast(node.next, k) + 1;
        if(index == k){
            this.kth = node.data;
        }
        return index;
    }
}
