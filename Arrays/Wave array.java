/*
Given an array of integers, sort the array into a wave like array and return it. 
In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....
*/

class GFG {
	public static void main (String[] args) {
		//code
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t>0){
		    int n = s.nextInt();
		    ArrayList<Integer> a = new ArrayList<>();
		    for(int i=0; i<n; i++){
		        a.add(s.nextInt());
		    }
		    Collections.sort(a);
	        for(int i=0; i<a.size()-1; i+=2){
	            int temp = a.get(i+1);
	            a.set(i+1, a.get(i));
	            a.set(i, temp);
	        }
	        for(int i=0; i<n; i++){
		        System.out.print(a.get(i) + " ");
		    }
		    t--;
		    System.out.println();
		}
		
	}
}
