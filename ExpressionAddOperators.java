public class ExpressionAddOperators {

    // Approach 1 - Brute Force Approach
    // Time Complexity : n* 3^n (exponential)
    // Space Complexity : exponential
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    static class ExpressionAddOperatorsBruteForce {
        List<String> result;

        public List<String> addOperators(String num, int target) {
            result = new ArrayList<>();
            helper(num, 0, 0, 0, "", target);
            return result;
        }

        private void helper(String num, int pivot, long calc, long tail, String path, int target) {
            if (pivot == num.length()) {
                if (calc == target) {
                    result.add(path);
                }
                return;
            }

            for (int i = pivot; i < num.length(); i++) {
                if (i != pivot && num.charAt(pivot) == '0') {
                    continue;
                }
                long curr = Long.parseLong(num.substring(pivot, i + 1));

                if (pivot == 0) {
                    helper(num, i + 1, curr, curr, curr + path, target);
                } else {
                    helper(num, i + 1, calc + curr, curr, path + "+" + curr, target);
                    helper(num, i + 1, calc - curr, -curr, path + "-" + curr, target);
                    helper(num, i + 1, calc - tail + tail * curr, curr * tail, path + "*" + curr, target);
                }
            }
        }
    }

    // Approach 1 - BackTracking Approach
    // Time Complexity : n * 3^n (exponential)
    // Space Complexity : exponential
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No

    static class ExpressionAddOperatorsBackTracking {
        List<String> result;

        public List<String> addOperators(String num, int target) {
            result = new ArrayList<>();
            helper(num, 0, 0, 0, new StringBuilder(), target);
            return result;
        }

        private void helper(String num, int pivot, long calc, long tail, StringBuilder path, int target) {

            if (pivot == num.length()) {
                if (calc == target) {
                    result.add(path.toString());
                }
                return;
            }

            for (int i = pivot; i < num.length(); i++) {
                if (i != pivot && num.charAt(pivot) == '0') {
                    continue;
                }
                long curr = Long.parseLong(num.substring(pivot, i + 1));
                int le = path.length();
                if (pivot == 0) {
                    path.append(curr);
                    helper(num, i + 1, curr, curr, path, target);
                    path.setLength(le);
                } else {
                    path.append('+');
                    path.append(curr);
                    helper(num, i + 1, calc + curr, curr, path, target);
                    path.setLength(le);

                    path.append('-');
                    path.append(curr);
                    helper(num, i + 1, calc - curr, -curr, path, target);
                    path.setLength(le);

                    path.append('*');
                    path.append(curr);
                    helper(num, i + 1, calc - tail + tail * curr, curr * tail, path, target);
                    path.setLength(le);
                }
            }
        }
    }

}
