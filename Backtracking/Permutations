*/
Given a collection of numbers, return all possible permutations.
*/

public class Solution {
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
	    return permutations(a);
	}
	
	public ArrayList<ArrayList<Integer>> permutations(ArrayList<Integer> a){
	    if(a.size()==0){
	        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	        ArrayList<Integer> temp = new ArrayList<>();
	        res.add(temp);
	       // result.add(temp);
	        return res;
	    }
	    
	    ArrayList<ArrayList<Integer>> temp = permutations(new ArrayList<Integer>(a.subList(1, a.size())));
	    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	    for(int i=0; i<temp.get(0).size()+1; i++){
	        for(int j=0; j<temp.size(); j++){
	            ArrayList<Integer> curr = new ArrayList<>();
	            for(int k=0; k<i; k++){
	                curr.add(temp.get(j).get(k));
	            }
	            curr.add(a.get(0));
	            for(int k=i; k<temp.get(0).size(); k++){
	                curr.add(temp.get(j).get(k));
	            }
	            res.add(curr);
	        }
	    }
	    return res;
	}
}
