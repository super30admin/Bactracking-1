import java.util.*;

class Solution {
    // TC : O(2^(m+n) // SC : O(m+n)
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if (candidates.length == 0 || candidates == null)
            return result;

        helper(candidates, 0, target, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int pivot, int amount, List<Integer> path) {
        // base case
        if (amount == 0) {
            result.add(path);
            return;
        }
        if (amount < 0 || pivot == candidates.length) {
            return;
        }

        // logic
        for (int i = pivot; i < candidates.length; i++) {
            path.add(candidates[i]);
            helper(candidates, i, amount - candidates[i], new ArrayList<>(path));
            path.remove(path.size() - 1);
        }

    }

    // TC: O(3^n) SC: O(n)
    public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<String>();
        if (num == null || num.length() == 0)
            return rst;
        helper(rst, "", num, target, 0, 0, 0);
        return rst;
    }

    public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long multed) {
        if (pos == num.length()) {
            if (target == eval)
                rst.add(path);
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0')
                break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                helper(rst, path + cur, num, target, i + 1, cur, cur);
            } else {
                helper(rst, path + "+" + cur, num, target, i + 1, eval + cur, cur);

                helper(rst, path + "-" + cur, num, target, i + 1, eval - cur, -cur);

                helper(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur);
            }
        }
    }
}