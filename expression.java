
// Time Complexity :exponential
// Space Complexity :O(n^2)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


class Solution {
    List<String> result;

    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, target, 0, 0, 0, "");
        return result;
    }

    private void helper(String num, int target, int idx, long calc, long tail, String path) {
        // base case//if we are at last index and found target, add in result and return
        if (idx == num.length()) {
            if (calc == target) {
                result.add(path);
            }
            return;
        }
        // logic//doing for loop recursion
        for (int i = idx; i < num.length(); i++) {
            // mking substring from idx to i to make digits
            long curr = Long.parseLong(num.substring(idx, i + 1));
            // if our digit created is not 0 but has preceding zero we dont make expresiion
            if (num.charAt(idx) == '0' && idx != i)
                continue;
            // at first index, we cannot make expression
            if (idx == 0) {
                helper(num, target, i + 1, curr, curr, path + curr);
            }
            // here we are taking cases of +,- and * for multiplication, because of BODMAS,
            // we need to maintain a tail
            // so that we can do calculation as precedence rule
            else {
                // +case
                helper(num, target, i + 1, calc + curr, curr, path + "+" + curr);
                // -case
                helper(num, target, i + 1, calc - curr, -curr, path + "-" + curr);
                // *case
                helper(num, target, i + 1, calc - tail + curr * tail, curr * tail, path + "*" + curr);
            }
        }
    }
}