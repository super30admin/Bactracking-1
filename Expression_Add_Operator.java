// 282. Expression Add Operators - https://leetcode.com/problems/expression-add-operators/
// Time Complexity : O(2^N) exponential
// Space Complexity : O(N) recursive stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
    List<String> res;

    public List<String> addOperators(String num, int target) {
        res = new ArrayList<>();
        if (num == null || num.length() == 0) return res;
        helper(num, target, 0, 0, 0, "");
        return res;
    }

    private void helper(String num, int target, int index, long calc, long tail, String path) {
        //base
        if (index == num.length()) {
            if (calc == target)
                res.add(path);
        }

        //logic
        for (int i = index; i < num.length(); i++) {
            //preceding zero
            if (num.charAt(index) == '0' && i != index)
                break;
            Long curr = Long.parseLong(num.substring(index, i + 1));
            if (index == 0) {
                //+
                helper(num, target, i + 1, curr, curr, path + curr);
            } else {
                //+
                helper(num, target, i + 1, calc + curr, curr, path + "+" + curr);
                //-
                helper(num, target, i + 1, calc - curr, -curr, path + "-" + curr);
                //*
                helper(num, target, i + 1, calc - tail + tail * curr, tail * curr, path + "*" + curr);
            }
        }
    }
}