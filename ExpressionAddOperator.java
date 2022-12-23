//TC : O(N*4^N) // we could maximum have N levels and 4^N ways to choose a +,-,* or nothing
//                  N is the nums in the string, 
//SC : O(N)
//RUN SUCCESSFULLY ON LEETCODE
//NO PROBLEMS

class Solution {
    List<String> ans;

    public List<String> addOperators(String num, int target) {
        ans = new ArrayList<>();
        helper(num, target, 0, 0, 0, "");
        return ans;
    }

    public void helper(String num, int target, int ind, long calc, long tail, String path) {
        // base case
        if (ind == num.length()) {
            if (target == calc) {
                ans.add(path);
            }
            return;
        }

        // logic
        for (int i = ind; i < num.length(); i++) {
            if (ind != i && num.charAt(ind) == '0') {
                continue;
            }
            long curr = Long.parseLong(num.substring(ind, i + 1));
            if (ind == 0) {
                helper(num, target, i + 1, curr, curr, path + curr);
            } else {
                // add +
                helper(num, target, i + 1, curr + calc, +curr, path + "+" + curr);
                // add -
                helper(num, target, i + 1, calc - curr, -curr, path + "-" + curr);
                // add *
                helper(num, target, i + 1, calc - tail + tail * curr, tail * curr, path + "*" + curr);
            }
        }
    }
}