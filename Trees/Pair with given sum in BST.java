/*
Given a Balanced Binary Search Tree and a target sum, write a function that returns true if there is a pair with sum equals to target sum, 
otherwise return false. Expected time complexity is O(n) and only O(Logn) extra space can be used.
Any modification to Binary Search Tree is not allowed. Note that height of a Balanced BST is always O(Logn).
*/

/*
Approach:
We traverse BST in Normal Inorder and Reverse Inorder simultaneously. 
In reverse inorder, we start from the rightmost node which is the maximum value node. 
In normal inorder, we start from the left most node which is minimum value node.
We add sum of current nodes in both traversals and compare this sum with given target sum. 
If the sum is same as target sum, we return true. 
If the sum is more than target sum, we move to next node in reverse inorder traversal, otherwise we move to next node in normal inorder traversal.
If any of the traversals is finished without finding a pair, we return false. 
*/

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int t2Sum(TreeNode A, int B) {
        boolean done1 = false;
        boolean done2 = false;
        int val1=0;
        int val2=0;
        TreeNode temp1 = A;
        TreeNode temp2 = A;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        while(true){
            while(done1==false){
                if(temp1!=null){
                    stack1.push(temp1);
                    temp1 = temp1.left;
                }else{
                    temp1 = stack1.pop();
                    val1 = temp1.val;
                    temp1 = temp1.right;
                    done1 = true;
                }
            }
            while(done2 == false){
                if(temp2!=null){
                    stack2.push(temp2);
                    temp2 = temp2.right;
                }else{
                    temp2 = stack2.pop();
                    val2 = temp2.val;
                    temp2 = temp2.left;
                    done2 = true;
                }
            }
            
            if(val1!=val2 && val1+val2 == B){
                return 1;
            }
            
            if(val1+val2 > B){
                done2 = false;
            }else{
                done1 = false;
            }
            
            if(val1 >= val2){
                return 0;
            }
        }
    }
}
