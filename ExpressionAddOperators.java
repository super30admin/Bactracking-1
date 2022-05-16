// Time Complexity : O(n) num length
// Space Complexity : O(n) for the recursion stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes
// Your code here along with comments explaining your approach: 

public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        if (num == null || num.length() == 0)
            return res;
        helper(res, "", num, target, 0, 0, 0);
        return res;
    }

    public void helper(List<String> res, String path, String num, int target, int pos, long eval, long multed) {
        if (pos == num.length()) {
            if (target == eval)
                res.add(path);
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0')
                break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                helper(res, path + cur, num, target, i + 1, cur, cur);
            } else {
                helper(res, path + "+" + cur, num, target, i + 1, eval + cur, cur);

                helper(res, path + "-" + cur, num, target, i + 1, eval - cur, -cur);

                helper(res, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur);
            }
        }
    }
}
