// Time Complexity : exponential
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class Solution {
    List<String> result = new ArrayList();
    public List<String> addOperators(String num, int target) {
        
        helper(num,"", target, 0, 0, 0);
        
        return result;        
    }
    
    public void helper(String num, String path, int target, long calc, long tail, int index) {
        
        if(index == num.length()) {
            if(calc == target)
                result.add(path);
            return;
        }
        
        //logic
        for(int i = index; i < num.length(); i++) {
            if(num.charAt(index) == '0' && index != i)
                continue;
            Long curr = Long.parseLong(num.substring(index, i + 1));
            if(index == 0){
                helper(num, path + curr, target, curr, curr, i + 1);
            }
            else {
                helper(num, path + "+" + curr, target, calc + curr, curr, i + 1);
                helper(num, path + "-" + curr,  target, calc - curr, -curr, i + 1);
                helper(num, path + "*" + curr,  target, calc - tail + tail * curr, tail * curr, i + 1);
            }
        }
        
    }
    
}