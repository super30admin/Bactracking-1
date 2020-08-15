import java.util.*;
/********************************************Using Recursion*******************************************/
//Time Complexity : O(4^n)
//Space Complexity : O(n * 4^n) as a new string created at each point
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
public class Expression_Add_Operators {
	List<String> result;
	int targ;
	public List<String> addOperators(String num, int target) {
		result = new ArrayList<>();
		targ = target;
		//edge case
		if(num == null || num.length() == 0)
			return result;
		helper(num, "", 0, 0, 0);	//calling helper for null path, 0 as curr calculated value, 0 as tail and 0 index
		return result;
	}
	private void helper(String num, String path, long calc, long tail, int index){
		//base case
		if(index == num.length()){	// if index reaches the end
			if(calc == targ){
				result.add(path);
				return;
			}
		}
		//logic
		for(int i = index; i<num.length(); i++){
			if(num.charAt(index) == '0' && index!=i) //to check if preceding zero are there and it lies before another value (105)
				break;
			//placeholder for a edge case preceding zero
			long curr = Long.parseLong(num.substring(index, i+1));
			if(index == 0){
				helper(num, path + curr, curr, curr, i+1);	 //calling helper for index 0 when tail and calc both are curr
			}
			else{
				// add + operator
				helper(num, path + "+" + curr, calc + curr, curr, i+1);	 //calling helper for for + , tail will be the mess made that is curr that was added
				//add - operator
				helper(num, path + "-" + curr, calc - curr, -curr, i+1);	//calling helper for for + , tail will be the mess made that is -curr that was subtracted
				// add * operator
				////calling helper for for * , calculated is calculated by nullifying the prev action using tail and then using tail to operate on current, tail becomes the new action done i.e operating tail on current
				helper(num, path + "*" + curr, calc - tail + tail * curr, tail * curr, i+1);    // 1+2*3 = 7, not 9. therefore calc - tail + tail * curr (3-2 + 2 * 3)
			}
		}
	}
}


/********************************************Using Backtracking*******************************************/
//Time Complexity : O(4^n)
//Space Complexity :  O(n) ,one string used throughout
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
    List<String> result;
    int targ;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        targ = target;
        if(num == null || num.length() == 0)
            return result;
        backtrack(num, new StringBuilder(), 0, 0, 0);
        return result;
    }
    private void backtrack(String num, StringBuilder sb, long calc, long tail, int index){
        //base
        if(index == num.length())
        {
            if(targ==calc)
                result.add(sb.toString());
            return;  
        }
        //logic
        for(int i=index; i<num.length(); i++){
            //preceding zero case
            if(num.charAt(index) == '0' && index != i)
                break;
            long curr = Long.parseLong(num.substring(index, i+1));
            int len = sb.toString().length();
            if(index == 0){
                sb.append(curr);    //action
                backtrack(num, sb, curr, curr, i+1);    //recurse
                sb.setLength(len);  //backtrack
            }else{
                sb.append("+"); //action
                sb.append(curr);    //action
                backtrack(num, sb, calc + curr, curr, i+1); //recurse
                sb.setLength(len);//backtrack
                
                sb.append("-"); //action
                sb.append(curr);    //action
                backtrack(num, sb, calc - curr, -curr, i+1);    //recurse
                sb.setLength(len);//backtrack
                
                sb.append("*"); //action
                sb.append(curr);    //action
                backtrack(num, sb, calc - tail + tail * curr, tail * curr, i+1);    //recurse
                sb.setLength(len);//backtrack
            }
        }
    }
}