/*
Given a N X N  matrix Matrix[N][N] of positive integers.  There are only three possible moves from a cell Matrix[r][c].

1. Matrix[r+1][c]

2. Matrix[r+1][c-1]

3. Matrix[r+1][c+1]

Starting from any column in row 0, return the largest sum of any of the paths up to row N-1.
*/

class GFG {
	public static void main (String[] args) {
		//code
		Scanner s = new Scanner(System.in);
	    int t = s.nextInt();
	    for(int b=0; b<t; b++){
	        int n = s.nextInt();
	        int [][] a = new int[n][n];
	        int [][] dp = new int[n][n];
	        for(int i=0; i<n; i++){
	            for(int j=0; j<n; j++){
	                a[i][j] = s.nextInt();
	                dp[i][j] = -1;
	            }
	        }
	        int res = findLargestPath(a, n, dp);
	        System.out.println(res);
	    }
	}
	
	public static int findLargestPath(int [][] a, int n, int [][] dp){
	    int res = Integer.MIN_VALUE;
	    for(int i=0; i<n; i++){
	        int curr = findLargestPathUtil(a, n, dp, 0, i);
	        res = Math.max(res, curr);
	    }
	    return res;
	}
	
	public static int findLargestPathUtil(int [][] a, int n, int [][] dp, int i, int j){
	    if(i<0 || j<0 || i==n || j==n){
	        return 0;
	    }
	    if(dp[i][j] != -1){
	        return dp[i][j];
	    }
	    dp[i][j] = a[i][j] + Math.max(Math.max(findLargestPathUtil(a, n, dp, i+1, j), findLargestPathUtil(a, n, dp, i+1, j-1)), findLargestPathUtil(a, n, dp, i+1, j+1));
	    return dp[i][j];
	}
}
