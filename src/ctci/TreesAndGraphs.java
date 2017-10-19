package ctci;

import java.util.ArrayList;
import java.util.LinkedList;

public class TreesAndGraphs {

    /**
     * Check if there is a route between a start and an end node within a graph
     * @param g graph to check for a route within
     * @param start start node
     * @param end end node
     * @return true if there is a connection from the start node to the end node
     */
    public static boolean routeBetweenNodes(Graph g, GraphNode start, GraphNode end){
        if(start == end) return true;

        LinkedList<GraphNode> q = new LinkedList<>();

        for(GraphNode node: g.getNodes()){
            node.state = GraphNode.State.Unvisited;
        }

        start.state = GraphNode.State.Visited;
        q.add(start);
        GraphNode temp;
        while(!q.isEmpty()){
            temp = q.removeFirst();
            if(temp != null){
                for(GraphNode v : temp.getAdjacent()){
                    if(v.state == GraphNode.State.Unvisited){
                        if(v == end){
                            return true;
                        } else {
                            v.state = GraphNode.State.Visited;
                            q.add(v);
                        }
                    }
                }
            }
            temp.state = GraphNode.State.Visited;
        }
        return false;
    }

    /**
     * Create a minimal BST from an array
     * @param array array to build a tree
     * @return a completed BST;
     */
    public static BinaryTreeNode createMinimalBST(int[] array){
        return createMinimalBST(array, 0, array.length - 1);
    }

    /**
     * Create a minimal BST from an array using the middle element of the array as the root node
     * @param array array to build tree from
     * @param start start index of array
     * @param end end index of array
     * @return BST with the middle element being the root node
     */
    private static BinaryTreeNode createMinimalBST(int[] array, int start, int end) {
        if(end < start) return null;

        int mid = (start + end)/2;
        BinaryTreeNode n = new BinaryTreeNode(array[mid]);
        n.leftChild = createMinimalBST(array, start, mid - 1);
        n.rightChild = createMinimalBST(array, mid + 1, end);
        return n;
    }

    private static void createLevelLinkedList(BinaryTreeNode root, ArrayList<LinkedList<BinaryTreeNode>> lists, int level){
        if(root == null) return; // base case

        LinkedList<BinaryTreeNode> list = null;
        if(lists.size() == level){
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        createLevelLinkedList(root.leftChild, lists, level + 1);
        createLevelLinkedList(root.rightChild, lists, level+1);
    }

    /**
     * Given a binary search tree design an algorutgm wgicg creates a linked list of all the nodes at each depth
     * @param root root of the binary tree
     * @return List of lists with each node at a certain level
     */
    public static ArrayList<LinkedList<BinaryTreeNode>> createLevelLinkedList(BinaryTreeNode root){
        ArrayList<LinkedList<BinaryTreeNode>> lists = new ArrayList<LinkedList<BinaryTreeNode>>();
        createLevelLinkedList(root, lists, 0);
        return lists;
    }
}
