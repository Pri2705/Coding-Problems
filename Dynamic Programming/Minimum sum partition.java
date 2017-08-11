/*
Given an array, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.
*/

class GFG {
	public static void main (String[] args) {
		//code
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int b=0; b<t; b++){
		    int n = s.nextInt();
		    int a [] = new int[n];
		    for(int i=0; i<n; i++){
		        a[i] = s.nextInt();
		    }
		    int sum = 0;
		    for(int i=0; i<n; i++){
		        sum += a[i];
		    }
		    boolean [][] dp = new boolean[sum+1][n+1];
		    for(int i=0; i<=n; i++){
		        dp[0][i] = true;
		    }
		    for(int i=1; i<=n; i++){
		        dp[i][0] = false;
		    }
		    for(int i=1; i<=sum; i++){
		        for(int j=1; j<=n; j++){
		            dp[i][j] = dp[i][j-1];
		            if(a[j-1] <= i)
		                dp[i][j] = dp[i][j] || dp[i-a[j-1]][j-1];
		        }
		    }
		    int diff = Integer.MAX_VALUE;
		  //  for(int i=0; i<=sum; i++){
		  //      for(int j=0; j<=n; j++){
		  //          System.out.print(dp[i][j] + " ");
		  //      }
		  //      System.out.println();
		  //  }
		    int j=0;
		    for(j=sum/2; j>=0; j--){
		        if(dp[j][n]){
		            diff = sum - 2*j;
		            break;
		        }
		    }
		    System.out.println(diff);
		}
	}
}
