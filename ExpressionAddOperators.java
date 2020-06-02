package s30Coding;
import java.util.*;
//Time Complexity :-  O(n * 4^n)
//Space Complexity :- O(n * 4^n)
//LeetCode :- Yes

public class ExpressionAddOperators {
	List<String> result;
    int targ;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        targ = target;
        if(num == null || num.length() == 0) return result;
        helper(num, target, "", 0,0,0);
        return result;
    }
    
    private void helper(String num, int target, String path, long calc, long tail, int index){
        if(index == num.length()){
            if(calc == target){
                result.add(path);
                return;
            }
        }
        for(int i = index ; i < num.length(); i++){
            if(index != i && num.charAt(index) == '0') break;
            long curr = Long.parseLong(num.substring(index, i+1));
            if(index == 0){
                helper(num, target, path+curr, curr, curr, i+1);
            }
            else{
                helper(num, target, path + "+" + curr, calc + curr, curr, i+1);
                helper(num, target, path + "-" + curr, calc - curr, -curr, i+1);
                helper(num, target, path + "*" + curr, calc - tail + tail*curr, tail*curr, i+1);
            }
        }
    }
    
}
