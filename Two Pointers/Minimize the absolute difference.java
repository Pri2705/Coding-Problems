/*
Given three sorted arrays A, B and Cof not necessarily same sizes.

Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c such that a, b, c belongs arrays A, B, C respectively.
i.e. minimize | max(a,b,c) - min(a,b,c) |.
*/

public class Solution {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int ans = Integer.MAX_VALUE;
        while(A.size()!=0 && B.size()!=0 && C.size()!=0){
            int a = A.get(A.size()-1);
            int b = B.get(B.size()-1);
            int c = C.get(C.size()-1);
            
            int temp = Math.max(Math.max(a,b),c) - Math.min(Math.min(a,b),c);
            if(temp<ans){
                ans = temp;
            }
            if(a>=b && a>=c){
                A.remove(A.size()-1);
            }else if(b>=a && b>=c){
                B.remove(B.size()-1);
            }else{
                C.remove(C.size()-1);
            }
        }
        return ans;
    }
}
