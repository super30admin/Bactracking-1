import java.util.ArrayList;
import java.util.List;

class Solution {

    List<String> result;

    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        if (num == null || num.length() == 0)
            return result;
        helper(num, target, 0, 0, 0, "");
        // result.add(path);
        return result;

    }

    private void helper(String num, int target, int pivot, long cal, long tail, String path) {

        // base
        if (pivot == num.length()) {
            if (cal == target) {
                result.add(path);
            }
            return;
        }

        // logic
        for (int i = pivot; i < num.length(); i++) {
            if (num.charAt(pivot) == '0' && i != pivot)
                continue;
            long curr = Long.parseLong(num.substring(pivot, i + 1));
            if (pivot == 0) {
                helper(num, target, i + 1, curr, curr, path + curr);
            } else {

                // +
                helper(num, target, i + 1, cal + curr, curr, path + '+' + curr);
                // -
                helper(num, target, i + 1, cal - curr, -curr, path + '-' + curr);
                // *
                helper(num, target, i + 1, cal - tail + tail * curr, curr, path + '*' + curr);
            }
        }

    }
}