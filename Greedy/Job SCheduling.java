/*
Given a set of n jobs where each job i has a deadline and profit associated to it. 
Each job takes 1 unit of time to complete and only one job can be scheduled at a time. 
We earn the profit if and only if the job is completed by its deadline. 
The task is to find the maximum profit and the number of jobs done.
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
		    int n = s.nextInt();
		    Job[] jobs = new Job[n];
		    for(int i=0; i<n; i++){
		        int j = s.nextInt();
		        int d = s.nextInt();
		        int p = s.nextInt();
		        Job newJob = new Job(j, d, p);
		        jobs[i] = newJob;
		    }
		    Arrays.sort(jobs);
		    
		    boolean slots[] = new boolean[n];
		    for(int i=0; i<n; i++){
		        slots[i] = false;
		    }
		    int order[] = new int[n];
		    int count = 0;
		    int maxProfit = 0;
		    for(int i=0; i<n; i++){
		        Job currJob = jobs[i];
		        int j=Math.min(n, currJob.deadline) - 1;
		        while(j>=0){
		            if(slots[j] == false){
		                slots[j] = true;
		                order[j] = currJob.jobId;
		                count++;
		                maxProfit += currJob.profit;
		                break;
		            }else{
		                j--;
		            }
		        }
		    }
		    System.out.println(count + " " + maxProfit);
		}
		
	}
}

class Job implements Comparable<Job>{
    int jobId;
    int deadline;
    int profit;
    
    Job(int j, int d, int p){
        jobId = j;
        deadline = d;
        profit = p;
    }
    
    @Override
    public int compareTo(Job j){
        if(this.profit>j.profit){
            return -1;
        }else{
            return 1;
        }
    }
}
