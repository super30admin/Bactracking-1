//Bruteforce
// Time Complexity : O(n 3^n), n is making substring at every node
// Space Complexity : exponential
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
/*
 * Bruteforce approach,  keep track of the calculated value and tail value at every new calculation. 
 * If the calc value matches target we add the path to the result
*/
class Solution {
    List<String> result;

    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        if (num == null || num.length() == 0)
            return result;
        helper(num, 0, 0, 0, "", target);

        return result;
    }

    private void helper(String num, int pivot, long calc, long tail, String path, int target) {
        // base
        if (pivot == num.length()) {
            if (calc == target)
                result.add(path);
            return;
        }

        // logic
        for (int i = pivot; i < num.length(); i++) {
            if (i != pivot && num.charAt(pivot) == '0') {
                continue;
            }
            long curr = Long.parseLong(num.substring(pivot, i + 1));
            if (pivot == 0) {
                helper(num, i + 1, curr, curr, path + curr, target);
            } else {
                // +
                helper(num, i + 1, calc + curr, +curr, path + "+" + curr, target);

                // -
                helper(num, i + 1, calc - curr, -curr, path + "-" + curr, target);

                // *
                helper(num, i + 1, (calc - tail) + (tail * curr), tail * curr, path + "*" + curr, target);
            }
        }
    }
}

// Backtrack

// Time Complexity : O(n 3^n), n is making substring at every node
// Space Complexity : exponential
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three
// sentences only
/*
 * Backtrack pproach, keep track of the calculated value and tail value at every
 * new calculation.
 * If the calc value matches target we add the path to the result
 */
class Solution {
    List<String> result;

    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        if (num == null || num.length() == 0)
            return result;
        helper(num, 0, 0, 0, new StringBuilder(), target);

        return result;
    }

    private void helper(String num, int pivot, long calc, long tail, StringBuilder path, int target) {
        // base
        if (pivot == num.length()) {
            if (calc == target)
                result.add(path.toString());
            return;
        }

        // logic
        for (int i = pivot; i < num.length(); i++) {
            if (i != pivot && num.charAt(pivot) == '0') {
                continue;
            }
            long curr = Long.parseLong(num.substring(pivot, i + 1));
            int le = path.length();
            if (pivot == 0) {
                // action
                path.append(curr);
                // recurse
                helper(num, i + 1, curr, curr, path, target);
                // backtrack
                path.setLength(le);

            } else {
                // +
                // action
                path.append("+");
                path.append(curr);
                // recurse
                helper(num, i + 1, calc + curr, +curr, path, target);
                // backtrack
                path.setLength(le);

                // -
                // action
                path.append("-");
                path.append(curr);
                // recurse
                helper(num, i + 1, calc - curr, -curr, path, target);
                // backtrack
                path.setLength(le);

                // *
                // action
                path.append("*");
                path.append(curr);
                // recurse
                helper(num, i + 1, (calc - tail) + (tail * curr), tail * curr, path, target);
                // backtrack
                path.setLength(le);

            }
        }
    }
}