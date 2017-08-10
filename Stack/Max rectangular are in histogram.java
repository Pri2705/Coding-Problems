/*
Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number of contiguous bars.
For simplicity, assume that all bars have same width and the width is 1 unit.
*/

/*
Approach:
1) Create an empty stack.

2) Start from first bar, and do following for every bar ‘hist[i]’ where ‘i’ varies from 0 to n-1.
……a) If stack is empty or hist[i] is higher than the bar at top of stack, then push ‘i’ to stack.
……b) If this bar is smaller than the top of stack, then keep removing the top of stack while top of the stack is greater. 
     Let the removed bar be hist[tp]. Calculate area of rectangle with hist[tp] as smallest bar. 
     For hist[tp], the ‘left index’ is previous (previous to tp) item in stack and ‘right index’ is ‘i’ (current index).
3) If the stack is not empty, then one by one remove all bars from stack and do step 2.b for every removed bar.
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
		    Stack<Integer> st = new Stack<>();
		    int i=0;
		    int maxArea = Integer.MIN_VALUE;
		    int currArea = 0;
		    while(i<n){
		        if(st.isEmpty() || a[st.peek()] <= a[i]){
		            st.push(i++);
		        }else{
		            int top = st.pop();
		            currArea = a[top]*(st.isEmpty()?i:i-st.peek()-1);
		            if(currArea > maxArea){
		                maxArea = currArea;
		            }
		        }
		    }
		    while(!st.empty()){
		        int top = st.pop();
		        currArea = a[top]*(st.isEmpty()?i:i-st.peek()-1);
		        if(currArea > maxArea){
		            maxArea = currArea;
		        }
		    }
		    System.out.println(maxArea);
		}
		
	}
}
