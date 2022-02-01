// Time Complexity : O(3^target)
// Space Complexity :
// Did this code successfully run on Leetcode : Yes

import java.util.*;

public class ExpressionAddOperators {
    List<String> result;

    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, target, new StringBuilder(), 0, 0, 0);
        return result;
    }

    private void helper(String num, int target, StringBuilder sb, int index, long calc, long tail) {
        //  base
        if (index == num.length()) {
            if (calc == target) {
                result.add(sb.toString());
                return;
            }
        }

        //  logic
        for (int i = index; i < num.length(); ++i) {
            //  handle zeros
            if (i != index && num.charAt(index) == '0')
                continue;

            Long cur = Long.parseLong(num.substring(index, i+1));
            int len = sb.length();
            if (index == 0) {
                sb.append(cur);
                helper(num, target, sb, i + 1, cur, cur);
                sb.setLength(len);
            }
            else {
                //  +
                sb.append("+");
                sb.append(cur);
                helper(num, target, sb, i + 1, calc + cur, cur);
                sb.setLength(len);

                //  -
                sb.append("-");
                sb.append(cur);
                helper(num, target, sb, i + 1, calc - cur, -cur);
                sb.setLength(len);

                //  *
                sb.append("*");
                sb.append(cur);
                helper(num, target, sb, i + 1, (calc - tail) + (tail * cur), tail * cur);
                sb.setLength(len);
            }
        }
    }
}
