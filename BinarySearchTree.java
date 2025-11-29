class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}
class BinarySearchTreeMethods{
    Node root=null;
    public Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        if(root.data>data){
            root.left=insert(root.left,data);
        }
        else{
            root.right=insert(root.right,data);
        }
        return root;

    }
     // Inorder Traversal (Left, Root, Right)
    public void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Preorder Traversal (Root, Left, Right)
    public void preorder(Node root){
        if(root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Postorder Traversal (Left, Right, Root)
    public void postorder(Node root){
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
    // Search in BST
public String search(Node root, int key) {
    if (root == null) {
        return "Not found" ;  // Not found
    }
    if (root.data == key) {
        return "found in root";   // Found
    }
    if (key < root.data) {
        return search(root.left, key);   // Search in left subtree
    } else {
        return search(root.right, key);  // Search in right subtree
    }
    
}
// Find minimum value in BST
public int findMin(Node root) {
    if (root == null) {
        System.out.println("Tree is empty");
        return -1;
    }

    while (root.left != null) {
        root = root.left;
    }

    return root.data;  // Left-most node
}
//Find maximum value in BST
public int findmax(Node root){
    if(root==null){
        System.out.println("Tree is empty");
        return -1;
    }
    while(root.right!=null){
        root=root.right;
    }
    return root.data;
}
public void deletebyValue(Node root,int key){
    if(root==null)
    {
        return;
    }
    root =null;
  }
  public void reflect(Node root){
    if(root==null) return;
    Node temp=root.left;
    root.left=root.right;
    root.right=temp;
    reflect(root.left);
    reflect(root.right);

  }


}


public class BinarySearchTree {
    public static void main(String[]args){
    
    BinarySearchTreeMethods tree=new BinarySearchTreeMethods();
    int[] values = {5, 3, 7, 2, 4, 6, 8};

        for (int v : values) {
            tree.root = tree.insert(tree.root, v);
        }

        System.out.print("Inorder: ");
        tree.inorder(tree.root);

        System.out.print("\nPreorder: ");
        tree.preorder(tree.root);

        System.out.print("\nPostorder: ");
        tree.postorder(tree.root);
        System.out.println("\nSearching for 4: " + tree.search(tree.root, 4));
        System.out.println("Searching for 10: " + tree.search(tree.root, 10));
        System.out.println("Minimum value in the tree: " + tree.findMin(tree.root));
        System.out.println("Maximum value in the tree: " + tree.findmax(tree.root));


    }
}