import java.util.*;
class Test{
       static int idx=-1;
       static class node{
              int data;
              node left;
              node right;
       node(int data){
              this.data=data;
              this.left=null;
              this.right=null;
       }
       }
      static class buildTree{
              public static node createTree(int arr[]){
                  idx++;
                  if(arr[idx]==-1)
                     return null;
        
                  node newNode = new node(arr[idx]);
                  newNode.left=createTree(arr);
                  newNode.right=createTree(arr);
                
                  return newNode;
       }
       public static int height(node root){
        if(root==null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight,rightHeight)+1;
       }
       public static int diameter(node root) {
            if (root == null) return 0;

            int leftDiam = diameter(root.left);
            int rightDiam = diameter(root.right);

            int selfDiam = height(root.left) + height(root.right) + 1;

            return Math.max(selfDiam, Math.max(leftDiam, rightDiam));
        }
      }
       public static void main(String[] args){
          int[] arr = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
          buildTree caller = new buildTree();
          node root = caller.createTree(arr);
          int treeDiameter = caller.diameter(root);
          System.out.println(treeDiameter);
       }
}
