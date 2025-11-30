public class BinarySearchTree {

    // NODE CLASS 
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    //  BINARY SEARCH TREE METHODS CLASS 
    static class BinarySearchTreeMethods {

        Node root = null;

        // Insert
        public Node insert(Node root, int data) {
            if (root == null) {
                return new Node(data);
            }
            if (data < root.data) {
                root.left = insert(root.left, data);
            } else {
                root.right = insert(root.right, data);
            }
            return root;
        }

        // Inorder
        public void inorder(Node root) {
            if (root == null) return;
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        // Preorder
        public void preorder(Node root) {
            if (root == null) return;
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        // Postorder
        public void postorder(Node root) {
            if (root == null) return;
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        // Search in BST
        public String search(Node root, int key) {
            if (root == null) return "Not found";
            if (root.data == key) return "found in root";
            if (key < root.data) return search(root.left, key);
            return search(root.right, key);
        }

        // Minimum value
        public int minValue(Node node) {
            while (node.left != null) {
                node = node.left;
            }
            return node.data;
        }

        // Maximum value
        public int findmax(Node root) {
            if (root == null) {
                System.out.println("Tree is empty");
                return -1;
            }
            while (root.right != null) {
                root = root.right;
            }
            return root.data;
        }

        // Delete entire tree
        public void deleteTree() {
            root = null;
        }

        // Mirror (reflect)
        public void reflect(Node root) {
            if (root == null) return;
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
            reflect(root.left);
            reflect(root.right);
        }

        // Delete node by value
        public Node deleteByValue(Node root, int value) {
            if (root == null) {
                return null;
            }

            if (value < root.data) {
                root.left = deleteByValue(root.left, value);
            } else if (value > root.data) {
                root.right = deleteByValue(root.right, value);
            } else {

                // Case 1: Leaf
                if (root.left == null && root.right == null) {
                    return null;
                }

                // Case 2: One child
                if (root.left == null) return root.right;
                if (root.right == null) return root.left;

                // Case 3: Two children
                int min = minValue(root.right);
                root.data = min;
                root.right = deleteByValue(root.right, min);
            }
            return root;
        }
    }

    //  MAIN 
    public static void main(String[] args) {

        BinarySearchTreeMethods tree = new BinarySearchTreeMethods();
        int[] values = {5, 3, 7, 2, 4, 6, 8};

        // Insert values
        for (int v : values) {
            tree.root = tree.insert(tree.root, v);
        }

        // Traversals
        System.out.print("Inorder: ");
        tree.inorder(tree.root);

        System.out.print("\nPreorder: ");
        tree.preorder(tree.root);

        System.out.print("\nPostorder: ");
        tree.postorder(tree.root);

        // Search
        System.out.println("\nSearching for 4: " + tree.search(tree.root, 4));
        System.out.println("Searching for 10: " + tree.search(tree.root, 10));

        // Min/Max
        System.out.println("Minimum value in the tree: " + tree.minValue(tree.root));
        System.out.println("Maximum value in the tree: " + tree.findmax(tree.root));

        // DELETE TESTS

        System.out.println("\n\nDeleting leaf node (2)");
        tree.root = tree.deleteByValue(tree.root, 2);
        System.out.print("Inorder after deleting 2: ");
        tree.inorder(tree.root);

        System.out.println("\n\nDeleting node with one child (3)");
        tree.root = tree.deleteByValue(tree.root, 3);
        System.out.print("Inorder after deleting 3: ");
        tree.inorder(tree.root);

        System.out.println("\n\nDeleting node with two children (5)");
        tree.root = tree.deleteByValue(tree.root, 5);
        System.out.print("Inorder after deleting 5: ");
        tree.inorder(tree.root);

        System.out.println();
    }
}
