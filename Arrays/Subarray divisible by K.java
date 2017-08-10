/*
You are given an array of positive and/or negative integers and a value K. 
The task is to find the count of all sub-arrays whose sum is divisible by K.
*/

/*
Approach:
Let there be a subarray (i, j) whose sum is divisible by k
  sum(i,j) = sum(0,j) - sum(0,i-1)
Sum for any subarray can be written as q*k + rem where q 
is a quotient and rem is remainder
Thus,     
    sum(i,j) = (q1 * k + rem1) - (q2 * k + rem2)
    sum(i,j) = (q1 - q2)k + rem1-rem2
     
We see, for sum(i,j) i.e. for sum of any subarray to be
divisible by k, the RHS should also be divisible by k.
(q1 - q2)k is obviously divisible by k, for (rem1-rem2) to 
follow the same, rem1 = rem2 where
    rem1 = Sum of subarray (0,j) % k
    rem2 = Sum of subarray (0,i-1) % k 
So if any sub-array sum from index i’th to j’th is divisible by k then we can saya[0]+…a[i-1] (mod k) = a[0]+…+a[j] (mod k)

So we need to find such a pair of indices (i, j) that they satisfy the above condition. Here is the algorithm :

1. Make an auxiliary array of size k as Mod[k] . 
This array holds the count of each remainder we are getting after dividing cumulative sum till any index in arr[].
2. Now start calculating cumulative sum and simultaneously take it’s mod with K , whichever remainder we get increment count by 1 for remainder as index in Mod[] auxiliary array. 
Sub-array by each pair of positions with same value of ( cumSum % k) constitute a continuous range whose sum is divisible by K.
3. Now traverse Mod[] auxiliary array , for any Mod[i] > 1 we can choose any to pair of indices for sub-array by (Mod[i]*(Mod[i] – 1))/2 number of ways . 
Do the same for all remainders < k and sum up the result that will be the number all possible sub-arrays divisible by K.
*/

class GFG {
	public static void main (String[] args) {
		//code
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int b=0; b<t; b++){
		    int n = s.nextInt();
		    int k = s.nextInt();
		    int [] a = new int[n];
		    for(int i=0; i<n; i++){
		        a[i] = s.nextInt();
		    }
		    int [] temp = new int[k];
		    int sum=0;
		    for(int i=0; i<n; i++){
		        sum+=a[i];
			//taking double mod as the sum can be negative
		        temp[((sum%k)+k)%k]++;
		    }
		    int count = 0;
		    for(int i=0; i<k; i++){
		        if(temp[i]>1){
		            count += ((temp[i])*(temp[i]-1))/2;
		        }
		    }
	  	    //Adding the element divisible by k
		    count+=temp[0];
		    System.out.println(count);
		}
	}
}
