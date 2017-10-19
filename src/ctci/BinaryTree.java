package ctci;


public class BinaryTree {
    /**
     * root node of binary tree
     */
    BinaryTreeNode root;

    /**
     * in order tree traversal traverses the left side of the tree then the current node
     * then the right side of the tree
     * @param node root node of the tree
     */
    public static void inOrderTreeTraversal(BinaryTreeNode node){
        if(node != null){
            inOrderTreeTraversal(node.leftChild);
            visitNode(node);
            inOrderTreeTraversal(node.rightChild);
        }
    }

    /**
     * pre order tree traversal visit the current node first then left side then right
     * @param node root node of the tree
     */
    public static void preOrderTraversal(BinaryTreeNode node){
        if(node != null){
            visitNode(node);
            preOrderTraversal(node.leftChild);
            preOrderTraversal(node.rightChild);
        }
    }

    /**
     * post order traversal visit left side pf the tree then the right then the current node
     * @param node root node of the tree
     */
    public static void postOrderTraversal(BinaryTreeNode node){
        if(node != null){
            postOrderTraversal(node.leftChild);
            postOrderTraversal(node.rightChild);
            visitNode(node);
        }
    }

    private static void visitNode(BinaryTreeNode node) {
        System.out.println(node.data);
    }

}

/**
 * Tree node for a binary tree
 * @param <T> Data type held by the node
 */
class BinaryTreeNode<T> {
    /**
     * Data held in node
     */
    T data;
    public BinaryTreeNode leftChild;
    public BinaryTreeNode rightChild;
}
