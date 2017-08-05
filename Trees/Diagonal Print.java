/*
Given a Binary Tree, print the diagnol traversal of the binary tree.
*/

class GfG
{
     public void diagonalPrint(TreeNode root)
      {
           //add your code here.
           hm = new HashMap<>();
           printDiagonal(root, 0);
           int [] ptr = new int[hm.size()];
           
           for(int j=0; j<hm.size(); j++){
           for(int i=0; i<hm.get(j).size(); i++){
                System.out.print(hm.get(j).get(i) + " ");
           }
           }
        //   System.out.println();
      }
      
      HashMap<Integer, ArrayList<Integer>> hm;
      
      public void printDiagonal(TreeNode root, int col){
          if(root == null){
              return;
          }
          if(hm.containsKey(col)){
              ArrayList<Integer> al = new ArrayList<>();
              al = hm.get(col);
              al.add(root.data);
              hm.put(col, al);
          }else{
              ArrayList<Integer> al = new ArrayList<>();
              al.add(root.data);
              hm.put(col, al);
          }
        //   hm.add(col, root.data);
          printDiagonal(root.left, col+1);
          printDiagonal(root.right, col);
      }
}
