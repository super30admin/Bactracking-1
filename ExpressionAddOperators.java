// Time Complexity : O(4^n) --> where n is length of input array
// Space Complexity : O(n * 4^n)
// Did this code successfully run on Leetcode (282): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    List<String> result;
    int trgt;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        trgt = target;
        
        // edge case
        if (num == null || num.length() == 0) return result;
        helper(num, "", 0, 0, 0);
        return result;
    }
    
    private void helper(String num, String path, long calc, long tail, int index) {
        // base 
        if (index == num.length()) {
            if (calc == trgt) {
                result.add(path);
                return;
            }
        }
        // logic
        for (int i = index; i < num.length(); i++) {
            //preceding zero
            if (i !=  index && num.charAt(index) == '0') break;
            long curr = Long.parseLong(num.substring(index, i+1));
            if (index == 0) {
                helper(num, path + curr, curr, curr, i + 1);
            }
            else {
                // choose +
                helper(num, path + "+" + curr, calc + curr, curr, i + 1);
                // choose -
                helper(num, path + "-" + curr, calc - curr, -curr, i + 1);
                // choose *
                helper(num, path + "*" + curr, calc - tail + tail * curr, tail * curr, i + 1);
            }
        }
    }
}