package Bactracking-1;

public class problem2 {
// Time Complexity : exponential
// Space Complexity : O(m) m is depth of string means number of opening brrackets
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        if(num == null || num.length() == 0) return result;
        
        helper(num, target, 0,"", 0, 0);
        
        return result;
    }
    public void helper(String num, int target,int index, String path, long calc, long tail){
        //base
        if(index == num.length()){
            if(calc == target){
                result.add(path);
            }
            return;
        }
        //logic
        for(int i = index; i < num.length(); i++){
            if(index != i && num.charAt(index) == '0') continue;
            long curr = Long.parseLong(num.substring(index, i+1));
            if(index == 0){
                helper(num, target, i + 1, path + curr, curr, curr);
            }else{
                helper(num, target, i + 1, path + '+' + curr, calc + curr, +curr);
                helper(num, target, i + 1, path + '-' + curr, calc - curr, -curr);
                helper(num, target, i + 1, path + '*' + curr, calc - tail + tail * curr, tail * curr);
                
            }
        }
    }
}
