/*
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
*/

public class Solution {
	public int trailingZeroes(int a) {
	    if(a==0){
	        return 0;
	    }
	    int no_of_zeros = 0;
	    for(int i=5; i<=a; i *= 5){
	        no_of_zeros += a/i;
	    }
	    return no_of_zeros;
	}
}
