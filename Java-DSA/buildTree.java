import java.util.* ;
public class BuildTree {

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

        public static int sumAtLevel(Node root, int targetLevel) {
            if (root == null) return 0;

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            int level = 1;
            int sum = 0;

            while (!q.isEmpty()) {
                int levelSize = q.size();  // No. of nodes at current level

                for (int i = 0; i < levelSize; i++) {
                    Node current = q.remove();

                    if (level == targetLevel) {
                        sum += current.data;
                    }

                    if (current.left != null) q.add(current.left);
                    if (current.right != null) q.add(current.right);
                }

                level++;
            }

            return sum;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 3, -1, -1, 4, -1, -1, 5, -1, 7, 8, 9, -1, -1, -1, -1, -1};

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the level you want to sum: ");
        int level = sc.nextInt();

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        int result = tree.sumAtLevel(root, level);
        System.out.println("Sum at level " + level + " = " + result);
    }
}
