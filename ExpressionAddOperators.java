// Time complexity: l * 4^n
// Space complexity: O(l)

// Approach: Use for loop dfs to get all substrings and add
// operators in each substring. For multiplication case, remove the last added/subtracted value
// and multiply that by current number

import java.util.ArrayList;
import java.util.List;

class ExpressionAddOperators {
    List<String> res;

    public List<String> addOperators(String num, int target) {
        this.res = new ArrayList();
        StringBuilder path = new StringBuilder();
        dfs(num, 0, 0, path, 0, target);
        return res;
    }

    private void dfs(String num, int pivot, long previous, StringBuilder path, long calculated, int target) {
        // base
        if (pivot == num.length() && calculated == target) {
            res.add(path.toString());
        }

        for (int i = pivot; i < num.length(); i++) {
            if (num.charAt(pivot) == '0' && i != pivot) {
                continue;
            }

            long currentNum = Long.parseLong(num.substring(pivot, i + 1));
            // +1 for the operation
            int prevLength = path.length();

            if (pivot == 0) {
                path.append(currentNum);
                dfs(num, i + 1, currentNum, path, currentNum, target);
                path.setLength(prevLength);
                continue;
            }

            // multiplication
            path.append("*");
            path.append(currentNum);
            // prev will be tail * current
            dfs(num, i + 1, previous * currentNum, path, calculated - previous + (previous * currentNum), target);
            path.setLength(prevLength);

            // addition
            path.append("+");
            path.append(currentNum);
            dfs(num, i + 1, currentNum, path, calculated + currentNum, target);
            path.setLength(prevLength);

            // subtraction
            path.append("-");
            path.append(currentNum);
            dfs(num, i + 1, -currentNum, path, calculated - currentNum, target);
            path.setLength(prevLength);
        }
    }
}