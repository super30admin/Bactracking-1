import java.util.ArrayList;
import java.util.List;

/**
 * @author Vishal Puri
 * // Time Complexity : O(2^n)
 * // Space Complexity : O(2^n)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

public class AddOperators {
    public List<String> addOperators(String num, int target) {
        ArrayList<String> res = new ArrayList<>();
        dfs(0, 0, 0, 0, num, target, "", res);
        return res;
    }

    void dfs(int ci, long val, long prev, long cur, String num, long target, String str, ArrayList<String> res) {
        if (ci == num.length()) {
            if (val == target && cur == 0) {
                res.add(str);
            }
            return;
        }

        int cd = num.charAt(ci) - '0';
        cur = 10 * cur;
        cur += cd;

        //no op
        if (cur > 0)
            dfs(ci + 1, val, prev, cur, num, target, str, res);

        // +
        if (str.equals("")) {
            dfs(ci + 1, val + cur, cur, 0, num, target, str + cur, res);
            return;
        }
        dfs(ci + 1, val + cur, cur, 0, num, target, str + "+" + cur, res);
        dfs(ci + 1, val - cur, -cur, 0, num, target, str + "-" + cur, res);

        // *
        dfs(ci + 1, val - prev + (prev * cur), prev * cur, 0, num, target, str + "*" + cur, res);
    }
}
