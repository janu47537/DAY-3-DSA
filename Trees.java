class Node {
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    BinaryTree() {
        this.root = null;
    }

    // Inorder Traversal: Left → Root → Right
    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    // Preorder Traversal: Root → Left → Right
    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // Postorder Traversal: Left → Right → Root
    public void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }
    public int countOfNode(Node node){
        if(node==null){
            return 0;
        }
        return 1+countOfNode(node.left)+countOfNode(node.right);
    }
    public int findheightOfTree(Node node){
        if(node==null){
            return 0;
        }
        return 1+Math.max(findheightOfTree(node.left),findheightOfTree(node.right));
    }
    public int sumOfNodes(Node node) {
    if (node == null) {
        return 0;
    }
    return node.data + sumOfNodes(node.left) + sumOfNodes(node.right);
}
public int countOfLeafNodes(Node node) {
    if (node == null) {
        return 0;
    }

    // If the node is a leaf (no left and no right child)
    if (node.left == null && node.right == null) {
        return 1;
    }

    // Recur for left and right subtree
    return countOfLeafNodes(node.left) + countOfLeafNodes(node.right);
}
public int sumOfLeafNodes(Node node) {
    if (node == null) {
        return 0;
    }

    // If node is a leaf
    if (node.left == null && node.right == null) {
        return node.data;
    }

    // Recur for left and right subtrees
    return sumOfLeafNodes(node.left) + sumOfLeafNodes(node.right);
}
public void deleteTree() {
    root = null;
    
}





}

public class Trees {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.print("Inorder: ");
        tree.inOrder(tree.root);

        System.out.print("\nPreorder: ");
        tree.preOrder(tree.root);

        System.out.print("\nPostorder: ");
        tree.postOrder(tree.root);
        System.out.println("Total number of nodes: " + tree.countOfNode(tree.root));
        System.out.println("Height of the tree: " + tree.findheightOfTree(tree.root));
        System.out.println("Sum of all Nodes: " + tree.sumOfNodes(tree.root));
        System.out.println("Count of LeafNodes:" + tree.countOfLeafNodes(tree.root));
        System.out.println("Sum of leaf nodes: " + tree.sumOfLeafNodes(tree.root));
        System.out.println("Binary Tree Deleted Successfully!");
       

        


    }
}
