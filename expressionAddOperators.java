// Time Complexity : O(n*4^n) where n is the length of the string num
// Space Complexity : O(n) where n is the length of the string num
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Backtracking

class expressionAddOperators {
    
    List<String> ans = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        backtrack("", num, target, 0, 0, 0);
        return ans;
    }
    
    private void backtrack(String path, String num, int target, int index, long calc, long tail) {
        // base case
        if (index == num.length()) {
            if (calc == target) {
                ans.add(path);
                return;
            }
        }
        // logic
        for (int i = index; i < num.length(); i++) {
            if (num.charAt(index) == '0' && index != i) break;
            long curr = Long.parseLong(num.substring(index, i + 1));
            if (index == 0) {
                backtrack(path + curr, num, target, i + 1, curr, curr);
            } else {
                backtrack(path + "+" + curr, num, target, i + 1, calc + curr, curr);
                backtrack(path + "-" + curr, num, target, i + 1, calc - curr, -curr);
                backtrack(path + "*" + curr, num, target, i + 1, calc - tail + tail * curr, tail * curr);
            }
        }
    }
}