import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperator {
    // TC: O(4 ^ N) where N is length of num
    // SC: O(N) where N is length of num
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        backtrack(res, num, target, 0, new StringBuilder(), 0, 0);
        return res;
    }

    private void backtrack(List<String> res, String num, int target, int start, StringBuilder currPath, long currVal, long prevVal) {
        if (start == num.length()) {
            if (target == currVal) {
                res.add(new StringBuilder(currPath).toString());
            }
            return;
        }
        for (int i = start; i < num.length(); i++) {
            if (num.charAt(start) == '0' && start != i) continue;
            long curr = Long.parseLong(num.substring(start, i + 1));
            int len = currPath.length();
            if (start == 0) {
                currPath.append(curr);
                backtrack(res, num, target, i + 1, currPath, curr, curr);
                currPath.setLength(len);
            } else {
                currPath.append("+");
                currPath.append(curr);
                backtrack(res, num, target, i + 1, currPath, currVal + curr, curr);
                currPath.setLength(len);

                currPath.append("-");
                currPath.append(curr);
                backtrack(res, num, target, i + 1, currPath, currVal - curr, -curr);
                currPath.setLength(len);

                currPath.append("*");
                currPath.append(curr);
                backtrack(res, num, target, i + 1, currPath, currVal - prevVal + prevVal * curr, prevVal * curr);
                currPath.setLength(len);

                // If division is also needed, uncomment this
                // if (curr != 0) {
                //     currPath.append("/");
                //     currPath.append(curr);
                //     backtrack(res, num, target, i + 1, currPath, currVal - prevVal + prevVal / curr, prevVal / curr);
                //     currPath.setLength(len);
                // }
            }
        }
    }
}
