package Backtracking1;

public class operatorsAndExpressions {
    // Time Complexity : O(n*4^n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : Nope

public class Solution {
public List<String> addOperators(String num, int target) {
    List<String> result = new ArrayList<String>();
    if(num == null || num.length() == 0) return rst;
    helper(result, "", num, target, 0, 0, 0);
    return result;
}
public void helper(List<String> result, String path, String num, int target, int pos, long eval, long tail){
    if(pos == num.length()){
        if(target == eval)
        	result.add(path);
        return;
    }
    for(int i = pos; i < num.length(); i++){
        if(i != pos && num.charAt(pos) == '0') break;
        long cur = Long.parseLong(num.substring(pos, i + 1));
        if(pos == 0){
            helper(result, path + cur, num, target, i + 1, cur, cur);
        }
        else{
            helper(result, path + "+" + cur, num, target, i + 1, eval + cur , cur);

            helper(result, path + "-" + cur, num, target, i + 1, eval -cur, -cur);

            helper(result, path + "*" + cur, num, target, i + 1, eval - tail + tail * cur, tail * cur );
        }
    }
}
}

}
