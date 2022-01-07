// Time Complexity = Exponential. O(4^n)
// Space Complexity = stack space + new string in each recursing call
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Difficult to imagine and guess corner cases like 0 case


// Your code here along with comments explaining your approach
class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        if (num == null || num.length() == 0) return result;

        helper(num, target, 0, 0, 0, "");
        return result;
    }

    private void helper(String num, int target, int index, long calc, long prev, String path) {
        //base
        if(index == num.length()) {
            if(target == calc) {
                result.add(path);
            }
            return;
        }

        //logic
        // Starting at each index, find all the possible matches to the target using the operators +,-,* between the digits
        for (int i=index; i<num.length(); i++) {

            if(i != index && num.charAt(index) == '0') {     // for cases such as 05, we skip 0.
                continue;
            }

            long curr = Long.parseLong(num.substring(index, i+1));

            // For the first char in the string, we are not concerned with the operation
            if (index == 0) {
                helper(num, target, i+1, curr, curr, path+curr);
            }
            else {
                // + case
                helper(num, target, i+1, calc+curr, curr, path+"+"+curr);
                // - case
                helper(num, target, i+1, calc-curr, -curr, path+"-"+curr);
                // * case
                helper(num, target, i+1, calc-prev+(curr*prev), curr*prev, path+"*"+curr);
            }
        }
    }
}