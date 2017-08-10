/*
Given an array of 0's and 1's your task is to complete the function maxLen which returns size of the largest sub array with equal number of 0's and 1's .
*/

/*
Approach:
Consider 0 as -1.
Now the problem reduces to largest subarray with sum 0.
*/

class GfG
{
    /*You are required to complete this method*/ 
    int maxLen(int[] arr) 
    {
         // Your code here
         int n =arr.length;
        //  int [] sums = new int [n];
         int sum = 0;
         int maxLen = 0;
         HashMap<Integer, Integer> hm = new HashMap<>();
         for(int i=0; i<n; i++){
             if(arr[i]==0){
                 sum--;
             }else{
                 sum++;
             }
             if(sum==0){
                 if(i+1>maxLen){
                     maxLen = i+1;
                 }
                 continue;
             }
             if(hm.containsKey(sum)){
                 int t = hm.get(sum);
                 if(i-t > maxLen){
                     maxLen = i-t;
                 }
             }else{
                 hm.put(sum, i);
             }
         }
         return maxLen;
    }
}
