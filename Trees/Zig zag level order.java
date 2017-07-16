*/
Given a binary tree, return the zigzag level order traversal of its nodes’ values. (ie, from left to right, then right to left for the next level and alternate between).
*/

public class Solution {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode a) {
	    Queue<TreeNode> q = new LinkedList<TreeNode>();
	    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	    boolean leftToRight = true;
	    q.offer(a);
	    q.offer(null);
	    ArrayList<Integer> curr = new ArrayList<>();
	    while(!q.isEmpty()){
	        TreeNode temp = q.poll();
	        if(temp != null){
	            curr.add(temp.val);
	            if(temp.left!=null)
	                q.add(temp.left);
	            if(temp.right!=null)
	                q.add(temp.right);
	        }else{
	            if(leftToRight){
	                res.add(curr);
	                curr = new ArrayList<>();
	            }else{
	                ArrayList<Integer> opp = new ArrayList<>();
	                for(int i=curr.size()-1; i>=0; i--){
	                    opp.add(curr.get(i));
	                }
	                res.add(opp);
	                curr = new ArrayList<>();
	            }
	            if(!q.isEmpty()){
	                q.offer(null);
	                leftToRight = !leftToRight;
	            }
	        }
	    }
	    return res;
	}
}
