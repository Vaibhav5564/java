import java.util.* ;
public class BuildTree2 {
    
    static class Node {
        int data;
        Node left;
        Node right;
    
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }    
    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        public static void preOrder(Node root) {
            if (root == null) {
                System.out.print(-1 + " ");
                return;
            }    
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void inOrder(Node root) {
            if (root == null) {
                System.out.print(-1 + " ");
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        } 

        public static void postOrder(Node root) {
            if (root == null) {
                System.out.print(-1 + " ");
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        public static void levelOrder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            
            while (!q.isEmpty()) {
                Node newNode = q.remove();
                
                if (newNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(newNode.data + " ");
                    
                    if (newNode.left != null) {
                        q.add(newNode.left);
                    }
                    if (newNode.right != null) {
                        q.add(newNode.right);
                    }
                }
            }
        }
        public static int count(Node root){
            if(root == null){
                return 0;
            }
            int left = count(root.left);
            int right = count(root.right);
            return left + right + 1 ;
        }
        public static int sum(Node root){
            if(root == null){
                return 0;
            }
            int leftSum = sum(root.left);
            int rightSum = sum(root.right);
            return leftSum + rightSum + root.data ;
        }
        public static int height(Node root) {
            if(root == null){
                return 0;
            }
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            return Math.max(leftHeight , rightHeight) + 1;
        }
        public static int diameter(Node root){
            if(root==null){
                return 0;
            }
            int Diameter1 = diameter(root.left);
            int Diameter2 = diameter(root.right);
            int Diameter3 = (height(root.left) + height(root.right)+1);
            
            return Math.max(Diameter1,Math.max(Diameter2,Diameter3));
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 3, -1, -1, 4, -1, -1, 5, -1, 7, 8, 9, -1, -1, -1, -1, -1};
       
        BinaryTree tree = new BinaryTree();
        Node root = tree.BuildTree2(nodes);
        tree.levelOrder(root);
        System.out.println(root);
        System.out.println();
        System.out.println("Total No. of roots = "+tree.count(root));
        System.out.println();
        System.out.println("Sum of Nodes = "+tree.sum(root));
        System.out.println();
        System.out.println("Height of Tree = "+tree.height(root));
        System.out.println();
        System.out.println("Diameter of Tree = "+tree.diameter(root));
    }
}
