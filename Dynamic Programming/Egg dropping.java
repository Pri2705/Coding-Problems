/*
Suppose that we wish to know which stories in a 36-story building are safe to drop eggs from, and which will cause the eggs to break on landing. We make a few assumptions:

…..An egg that survives a fall can be used again.
…..A broken egg must be discarded.
…..The effect of a fall is the same for all eggs.
…..If an egg breaks when dropped, then it would break if dropped from a higher floor.
…..If an egg survives a fall then it would survive a shorter fall.
…..It is not ruled out that the first-floor windows break eggs, nor is it ruled out that the 36th-floor do not cause an egg to break.
In this problem you have to find minimum trials to solve for n eggs and k floors.
*/

class GFG {
	public static void main (String[] args) {
		//code
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int b=0; b<t; b++){
		    int numEggs = s.nextInt();
		    int numFloors = s.nextInt();
		    int[][] dp = new int[numEggs+1][numFloors+1];
		    for(int i=1; i<=numEggs; i++){
		        for(int j=1; j<= numFloors; j++){
		            if(i==1){
		                dp[i][j] = j;
		            }else if(i>=j){
		                dp[i][j] = dp[i-1][j];
		            }else{
		                int min = Integer.MAX_VALUE;
		                for(int k=1; k<=j; k++){
		                    int val = 1 + Math.max(dp[i-1][k-1], dp[i][j-k]);
		                    
		                    if(val<min){
		                        min=val;
		                    }
		                }
		                dp[i][j] = min;
		            }
		        }
		    }
		    System.out.println(dp[numEggs][numFloors]);
		}
	}
}
