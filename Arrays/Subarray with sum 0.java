/*
Given an array of positive and negative numbers, find if there is a subarray (of size at-least one) with 0 sum.
*/

/*
Approach:
Use hashing. The idea is to iterate through the array and for every element arr[i], calculate sum of elements form 0 to i.
If we consider all prefix sums, we can
notice that there is a subarray with 0
sum when :
1) Either a prefix sum repeats or
2) Or prefix sum becomes 0.
*/

class GFG {
	public static void main (String[] args) {
		//code
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int b=0; b<t; b++){
		    int n = s.nextInt();
		    int [] a = new int[n];
		    for(int i=0; i<n; i++){
		        a[i] = s.nextInt();
		    }
		    HashMap<Integer, Integer> hm = new HashMap<>();
		    int sum=0;
		    boolean isFound = false;
		    for(int i=0; i<n; i++){
		        sum += a[i];
		        if(hm.containsKey(sum) || sum==0){
		            System.out.println("Yes");
		            isFound = true;
		            break;
		        }else{
		            hm.put(sum, i);
		        }
		    }
		    if(!isFound){
		        System.out.println("No");
		    }
		}
	}
}
