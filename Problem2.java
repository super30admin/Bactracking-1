import java.util.ArrayList;
import java.util.List;

// ## Problem2
// Expression Add Operators(https://leetcode.com/problems/expression-add-operators/)

// time: O(n * 3^n)
// space: O(n * 3^n)
class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, 0,0,0,"", target);
        return result;
    }
    
    private void helper(String num, int pivot, long calc, long tail, String path, int target) {
        //base 
        if (pivot == num.length()) {
            if (calc == target) {
                result.add(path);
            }
            return;
        }
        
        // logic
        
        for (int i = pivot; i< num.length(); i++) {
            if (num.charAt(pivot) == '0' && i != pivot) continue;
            long curr = Long.parseLong(num.substring(pivot, i+1)); // 2 23 234
            if (pivot == 0) {
                helper(num, i+1, curr, curr, path+curr, target);
            } else {
                // +
                helper(num, i+1, curr+calc, +curr, path + "+" + curr, target);
                // -
                helper(num, i+1, calc-curr, -curr, path+ "-" + curr, target);
                // *
                helper(num, i+1, calc-tail + tail * curr, tail*curr, path+ "*" + curr, target);
            }
        }
    }
}