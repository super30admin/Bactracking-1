
/*
Time Complexity : O N*(4 ^N)
Space Complextiy : O(N)
*/
import java.util.*;

class Solution {
    List<String> result;

    public List<String> addOperators(String num, int target) {

        result = new ArrayList<>();

        if (num == null || num.length() == 0)
            return result;

        helper(num, 0, 0, 0, "", target);

        return result;
    }

    // logic
    public void helper(String num, int index, long calc, long tail, String path, int target) {
        //
        if (index == num.length()) {

            if (calc == target) {

                result.add(path);

            }

            return;
        }

        // taking pivot
        for (int i = index; i < num.length(); i++) {
            // checking if it has preceding zero

            if (num.charAt(index) == '0' && index != i)
                continue;
            // taking substring and converting into long

            long curr = Long.parseLong(num.substring(index, i + 1));

            if (index == 0) {

                helper(num, i + 1, curr, curr, path + curr, target);

            } else {

                // + operator

                helper(num, i + 1, calc + curr, +curr, path + "+" + curr, target);
                // - operator
                helper(num, i + 1, calc - curr, -curr, path + "-" + curr, target);

                // * operator
                helper(num, i + 1, calc - tail + tail * curr, tail * curr, path + "*" + curr, target);

            }
        }
    }
}