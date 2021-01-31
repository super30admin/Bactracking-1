// Time Complexity : Exponential
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
	// Your code here along with comments explaining your approach
	/*
	 * This approach is by using recursive method but with a for loop.
	 * The + and - operations are performed on the current value chosen and the previously calculated plus and/or minus and respective +/- operations shall be performed
	 * For * a small calculated mess shall be created as previously calculated value - the previous tail value + the previous tail value * the current chosen value
	 */
	//Recursion with for loop
	List<String> result1;
    int targ1;
    public List<String> addOperatorsNormalRecursion(String num, int target) {
    	result1 = new ArrayList<>();
        targ1 = target;
        if(num == null || num.length() == 0) return result1;
        helperNormalRecursion(num, "", 0, 0, 0);
        return result1;
    }
    
    private void helperNormalRecursion(String num, String path, long calc, long tail, int index){
        //base
        if(index == num.length()){
            if(calc == targ){
            	result1.add(path);
            }
            return;
        }
        //logic
        for(int i = index; i < num.length(); i++){
            if(index != i && num.charAt(index) == '0') continue;
            long curr = Long.parseLong(num.substring(index, i+1));
            if(index == 0){
            	helperNormalRecursion(num, path + curr, curr, curr, i + 1);
            }else{
                //+
            	helperNormalRecursion(num, path + "+" + curr, calc + curr, curr, i + 1);
                //-
            	helperNormalRecursion(num, path + "-" + curr, calc - curr, -curr, i + 1);
                //*
            	helperNormalRecursion(num, path + "*" + curr, calc - tail + tail * curr, tail * curr, i + 1);
            }
        }
    }
    
    // Your code here along with comments explaining your approach
 	/*
 	 * This approach is by using backtracking method but with a for loop.
 	 * The + and - operations are performed on the current value chosen and the previously calculated plus and/or minus and respective +/- operations shall be performed
 	 * For * a small calculated mess shall be created as previously calculated value - the previous tail value + the previous tail value * the current chosen value
 	 * finally to back track each time after every operation is performed, the length of the substring taken will be set to the initial value
 	 */
    //Backtracking with for loop
    List<String> result;
    int targ;
    public List<String> addOperatorsBacktracking(String num, int target) {
        result = new ArrayList<>();
        targ = target;
        if(num == null || num.length() == 0) return result;
        helperBacktracking(num, target, new StringBuilder() , 0, 0, 0);
        return result;
    }
    
    private void helperBacktracking(String num, int target, StringBuilder sb, long calc, long tail, int index){
        //base
        if(index == num.length()){
            if(calc == targ){
                result.add(sb.toString());
            }
            return;
        }
        //logic
        for(int i = index; i < num.length(); i++){
            if(index != i && num.charAt(index) == '0') break;
            long curr = Long.parseLong(num.substring(index, i+1));
            int len = sb.toString().length();
            if(index == 0){
            	sb.append(curr);
            	helperBacktracking(num, target, sb, curr, curr, i + 1);
                sb.setLength(len);
            }else{
                //+
            	sb.append("+");
            	sb.append(curr);
            	helperBacktracking(num, target, sb, calc + curr, curr, i + 1);
                sb.setLength(len);
                //-
                sb.append("-");
                sb.append(curr);
                helperBacktracking(num, target, sb,  calc - curr, -curr, i + 1);
                sb.setLength(len);
                //*
                sb.append("*");
                sb.append(curr);
                helperBacktracking(num, target, sb, calc - tail + tail * curr, tail * curr, i + 1);
                sb.setLength(len);
            }
        }
    }
}
