/*
Given a stack, the task is to sort it such that the top of the stack has the greatest element. 
*/

class GfG{
	public Stack<Integer> sort(Stack<Integer> s)
	{
		//add code here
		Stack<Integer> temp = new Stack<>();
		while(s.size()>0){
		    int val = s.pop();
		    if(temp.empty()){
		        temp.push(val);
		    }else{
		        if(temp.peek()<=val){
		            temp.push(val);
		        }else{
		            while(temp.size()>0 && temp.peek()>val){
		                int val1 = temp.pop();
		                s.push(val1);
		            }
		            temp.add(val);
		        }
		    }
		}
		return temp;
	}
}
