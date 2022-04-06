import java.util.ArrayList;
import java.util.List;

//Time Complexity: Exponential. O(n*3^n).
//Space Complexity: O(n) 
public class ExpressionAddOperators {	
	List<String> res;
    public List<String> addOperators(String num, int target) {
        res= new ArrayList<>();
        if(num==null || num.length()==0) return res;       
        helper(num, 0, 0, 0, new StringBuilder(),target);
        return res;
    }
    /** Approach: Using StringBuilder + Backtracking **/
    private void helper(String num, int index, long calc, long tail, StringBuilder path, int target) {//index==pivot
    	//base
    	if(index==num.length()) {
    		if(calc==target) {
    			res.add(path.toString());
    		}
    		return;
    	}    	
    	//logic
    	for(int i=index; i<num.length(); i++) {
    		if(num.charAt(index)=='0' && index!=i) continue; //Handle preceding zero
    		long curr=Long.parseLong(num.substring(index, i+1));
    		int len= path.length();
    		
    		if(index==0) {
    			path.append(curr); //action
    			helper(num, i+1, curr, curr, path, target); //recurse
    			path.setLength(len); //backtrack
    		}else {
    			//+
    			path.append("+");
    			path.append(curr);
    			helper(num, i+1, calc+curr, curr, path, target);
    			path.setLength(len); //backtrack
    			
    			//-
    			path.append("-");
    			path.append(curr);
    			helper(num, i+1, calc-curr, -curr, path, target);
    			path.setLength(len); //backtrack
    			
    			//*
    			path.append("*");
    			path.append(curr);
    			helper(num, i+1, calc-tail+tail*curr, tail*curr, path, target);
    			path.setLength(len); //backtrack
    		}
    	}
    }
    
	// Driver code to test above 
	public static void main (String[] args) {
		ExpressionAddOperators ob = new ExpressionAddOperators();
    	String num= "123"; //"105";
    	int target=6;
    	
		System.out.println("All possible expressions using given operators to make target: "+ob.addOperators(num, target));
	}
}
