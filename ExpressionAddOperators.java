
// Time complexity : O(3^n)
// Space complexity : O(n)
import java.util.*;

public class ExpressionAddOperators {
    public static void main(String[] args) {
        String num = "123";
        int target = 6;
        List<String> result = addOperators(num, target);
        System.out.println(result);
    }

    static List<String> result;

    private static List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, target, 0, 0, 0, "");
        return result;
    }

    private static void helper(String num, int target, int pivot, long calc, long tail, String path) {
        // base
        if (pivot == num.length()) {
            if (calc == target) {
                result.add(path);
            }
            return;
        }

        // logic
        for (int i = pivot; i < num.length(); i++) {
            long curr = Long.parseLong(num.substring(pivot, i + 1));

            // placeholder preceding "0"
            if (num.charAt(pivot) == '0' && i != pivot)
                continue;

            if (pivot == 0) {
                helper(num, target, i + 1, curr, curr, path + curr);
            } else {
                // 3 options - subnodes (+ , - , *)
                // +
                helper(num, target, i + 1, calc + curr, curr, path + "+" + curr);
                // -
                helper(num, target, i + 1, calc - curr, -curr, path + "-" + curr);
                // *
                helper(num, target, i + 1, calc - tail + tail * curr, tail * curr, path + "*" + curr);
            }
        }
    }
}
