/*
Given two positive numbers x and y, check if y is a power of x or not
Expected complexity: loglogy
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int b=0; b<t; b++){
		    int x = s.nextInt();
		    long y = s.nextLong();
		    if(x==1 && y==1){
		        System.out.println(1);
		    }else if(x==1){
		        System.out.println(0);
		    }else if(y==1){
		        System.out.println(1);
		    }
		    int i=1;
		    while(x!=1 && y!=1){
		        if(Math.pow(x,i)==y){
		            System.out.println(1);
		            break;
		        }else if(Math.pow(x,i)>y){
		            int res = checkPower(x, y, i/2+1, i);
		            System.out.println(res);
		            break;
		        }else{
		            i = i*2;
		        }
		    }
		}
	}
	
	public static int checkPower(int x, long y, int start, int end){
	    if(start>end){
	        return 0;
	    }
	    int mid = (start+end)/2;
	    if(Math.pow(x, mid)==y){
	        return 1;
	    }
	    if(Math.pow(x, mid)>y){
	        return checkPower(x,y,start,mid-1);
	    }else{
	        return checkPower(x, y, mid+1, end);
	    }
	}
}
