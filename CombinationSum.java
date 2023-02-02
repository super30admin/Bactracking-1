public class CombinationSum {

    // Approach 1 - Using 0-1 recursion
    // Time Complexity : O(2^(m*n)) - m is the number of candidates and n is the target
    // Space Complexity :O(2^(m*n))
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No

    static class CombinationSum01Recursion {
        List<List<Integer>> result;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            result = new ArrayList<>();
            if (candidates == null) {
                return result;
            }
            helper(candidates, 0, target, new ArrayList<>());
            return result;
        }

        private void helper(int[] candidates, int idx, int amount, List<Integer> path) {

            if (amount == 0) {
                result.add(path);
                return;
            }
            if (amount < 0 || idx == candidates.length) {
                return;
            }
            helper(candidates, idx + 1, amount, new ArrayList(path));
            path.add(candidates[idx]);
            helper(candidates, idx, amount - candidates[idx], new ArrayList(path));
        }
    }

    // Approach 2 - Backtracking
    // Time Complexity : O(2^(m*n)) - m is the number of candidates and n is the target
    // Space Complexity :O(2^(m*n))
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    static class CombinationSumBacktracking {
        List<List<Integer>> result;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            result = new ArrayList<>();
            if (candidates == null) {
                return result;
            }
            helper(candidates, 0, target, new ArrayList<>());
            return result;
        }

        private void helper(int[] candidates, int idx, int amount, List<Integer> path) {
            if (amount == 0) {
                result.add(new ArrayList<>(path));
                return;
            }

            if (amount < 0 || idx == candidates.length) {
                return;
            }
            helper(candidates, idx + 1, amount, path);
            path.add(candidates[idx]);
            helper(candidates, idx, amount - candidates[idx], path);
            path.remove(path.size() - 1);
        }
    }

    // Approach 3 - Using for-loop based recursion with backtracking
    // Time Complexity : O(2^(m*n)) - m is the number of candidates and n is the target
    // Space Complexity :O(2^(m*n))
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    static class CombinationSumBacktrackingForLoop {
        List<List<Integer>> result;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            result = new ArrayList<>();
            if (candidates == null) {
                return result;
            }
            helper(candidates, 0, target, new ArrayList<>());
            return result;
        }

        private void helper(int[] candidates, int pivot, int amount, List<Integer> path) {
            if (amount == 0) {
                result.add(new ArrayList<>(path));
                return;
            }
            if (amount < 0) {
                return;
            }
            for (int i = pivot; i < candidates.length; i++) {
                path.add(candidates[i]);
                helper(candidates, i, amount - candidates[i], path);
                path.remove(path.size() - 1);

            }
        }
    }


    // Approach 4 - for-loop based recursion without backtracking
    // Time Complexity : O(2^(m*n)) - m is the number of candidates and n is the target
    // Space Complexity :O(2^(m*n))
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No

    static class CombinationSumForLoop {
        List<List<Integer>> result;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            result = new ArrayList<>();

            if (candidates == null)
                return result;

            helper(candidates, 0, target, new ArrayList<>());
            return result;
        }

        private void helper(int[] candidates, int pivot, int amount, List<Integer> path) {
            if (amount == 0) {
                result.add(new ArrayList<>(path));
                return;
            }
            if (amount < 0) {
                return;
            }
            for (int i = pivot; i < candidates.length; i++) {
                List<Integer> temp = new ArrayList<>(path);
                temp.add(candidates[i]);
                helper(candidates, i, amount - candidates[i], temp);

            }
        }
    }
}