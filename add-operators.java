
//tc is O(4^n) where n is the length of the string (because we are doing 4 recursive calls)
//SC is O(n) -> Not sure
import java.util.*;

class Solution {
    List<String> result;

    public List<String> addOperators(String num, int target) {

        if (num == null || num.length() == 0)
            return new ArrayList<>();

        result = new ArrayList<>();
        helper(num, target, 0, 0, 0, "");

        return result;

    }

    private void helper(String num, int target, int index, long calc, long tail, String path) {

        // base

        if (index == num.length()) {
            if (calc == target) {
                result.add(path);
            }
        }

        // logic

        for (int i = index; i < num.length(); i++) {
            if (index != i && num.charAt(index) == '0')
                continue;
            long curr = Long.parseLong(num.substring(index, i + 1)); // i+1 as it will only take upto i
            if (index == 0) {
                // Not in a position to insert any operator (since there is only one digit)

                helper(num, target, i + 1, curr, curr, path + curr);
            } else {
                // + case
                helper(num, target, i + 1, calc + curr, curr, path + "+" + curr);

                // -case
                helper(num, target, i + 1, calc - curr, -curr, path + "-" + curr);

                // *case
                helper(num, target, i + 1, calc - tail + tail * curr, tail * curr, path + "*" + curr);

            }
        }

    }
}