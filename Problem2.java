// Time Complexity : O(n*4^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        
        result = new ArrayList<>();
        helper(num, 0, 0, 0, new StringBuilder(), target);
        return result;
        
    }
    
    // long for calc as multiplication may go out of bounds
    // idx - pivot
    private void helper(String num, int idx, long calc, long tail, StringBuilder path, int target) {
        
        // base
        // pivot has reached to the end
        if(idx == num.length()) {
            if(calc == target) {
                result.add(path.toString());
            }
            return;
        }
        
        
        // logic
        // create numbers
        for(int i = idx; i < num.length(); i ++) {
            // preceeding zero
            // a digit cannot be skipped, therefore we don't consider cases with preceeding 0's
            if(num.charAt(idx) == '0' && i != idx) {
                 continue;   
            }
            
            long curr = Long.parseLong(num.substring(idx, i+1)); // 2 23 234
            int initialLength = path.length();
            if(idx == 0) {
                // action
                path.append(curr);
                // recurse
                helper(num, i + 1, curr, curr, path, target);
                // backtrack
                // dont delete last 2 chars as there could be a number with multiple digits
                path.setLength(initialLength);
            } else {
                // +
                path.append('+').append(curr);
                helper(num, i + 1, calc + curr, curr, path, target);
                path.setLength(initialLength);
                // - 
                path.append('-').append(curr);
                helper(num, i + 1, calc - curr, -curr, path, target);
                path.setLength(initialLength);
                // *
                path.append('*').append(curr);
                helper(num, i + 1, calc - tail + tail * curr, tail * curr, path, target);
                path.setLength(initialLength);
            }
        }
    }
}