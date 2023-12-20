/**
 * Backtracking
 * Call 1: No choose
 * Call 2: choose
 * We can make "path" global also.
 */
// Time Complexity : O(2^(m+n))
// Space Complexity : O(m+n)
class Solution {

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        this.result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int i, List<Integer> path) {

        //base
        if(target < 0 || i == candidates.length) return;

        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        //logic
        helper(candidates, target, i+1, path);

        //action
        path.add(candidates[i]);
        //recurse
        helper(candidates, target-candidates[i], i, path);
        //backtrack
        path.remove(path.size()-1);
    }
}

/**
 * Backtracking
 * Call 1: choose
 * Call 2: No choose
 */
// Time Complexity : O(2^(m+n))
// Space Complexity : O(m+n)
class Solution {

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        this.result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int i, List<Integer> path) {

        //base
        if(target < 0 || i == candidates.length) return;

        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        //logic
        //action
        path.add(candidates[i]);
        //recurse
        helper(candidates, target-candidates[i], i, path);
        //backtrack
        path.remove(path.size()-1);


        helper(candidates, target, i+1, path);
    }
}

/**
 * For Loop based backtracking
 * In this problem, we are not allowed to have permutations i.e [2,2,3] & [2,3,2] is not allowed.
 * If we are allowed, then our FOR LOOP WILL START FROM 0, INSTEAD OF PIVOT
 *
 * If we are not allowed duplicates in a single list i.e [2,2,3], then PASS i+1 INSTEAD OF i IN THE RECURSIVE CALL and for loop will start
 * from pivot. Time and space complexity will be the same.
 */
// Time Complexity : O(2^(m+n))
// Space Complexity : O(m+n)
class Solution {

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        this.result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int pivot, List<Integer> path) {

        //base
//        if(target < 0 || pivot == candidates.length) return;           THIS CONDITION NOT NEEDED AS FOR LOOP TAKES CARE OF THIS
        if(target < 0) return;
        if(target == 0) {
            result.add(new ArrayList<>(path));
        }

        //logic
        for(int i=pivot; i<candidates.length; i++) {
            //action
            path.add(candidates[i]);
            //recurse
            helper(candidates, target-candidates[i], i, path);
            //backtrack
            path.remove(path.size()-1);
        }
    }
}

/**
 * For loop based recursion. Instead of removing the element after recursive call, create a new local deep copy list of path and pass it in
 * recursion. Local list will handle the removal part because it will be vanised at every iteration, so the previous elements added to the
 * list inside the for loop at that recursion stage will not be present. This way, we can do the NO CHOOSE CASE WITHOUT BACKTRACKING
 */
// Time Complexity : O((m+n)*(2^(m+n)))
// Space Complexity : O(m+n)
class Solution {

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        this.result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int pivot, List<Integer> path) {

        //base
        if(target < 0 || pivot == candidates.length) return;

        if(target == 0) {
            result.add(new ArrayList<>(path));
        }

        //logic
        for(int i=pivot; i<candidates.length; i++) {
            //action
            List<Integer> li = new ArrayList<>(path);
            li.add(candidates[i]);
            //recurse
            helper(candidates, target-candidates[i], i, li);
            //backtrack
            // path.remove(path.size()-1);
        }
    }
}

/**
 * Passing new arraylist at every recursion
 * Call 1: No choose
 * Call 2: choose
 */

// Time Complexity : O((m+n)*(2^(m+n)))
// Space Complexity : O(m+n)
class Solution {

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        this.result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int i, List<Integer> path) {

        //base
        if(target < 0 || i == candidates.length) return;

        if(target == 0) {
            result.add(path);
            return;
        }

        //logic
        helper(candidates, target, i+1, new ArrayList<>(path));

        path.add(candidates[i]);
        helper(candidates, target-candidates[i], i, new ArrayList<>(path));
    }
}

/**
 * Passing new arraylist at every recursion
 * Call 1: choose
 * Call 2: No choose
 */
// Time Complexity : O((m+n)*(2^(m+n)))
// Space Complexity : O(m+n)
class Solution {

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        this.result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int i, List<Integer> path) {

        //base
        if(target < 0 || i == candidates.length) return;

        if(target == 0) {
            result.add(path);
            return;
        }

        //logic
        List<Integer> li = new ArrayList<>(path);
        li.add(candidates[i]);
        helper(candidates, target-candidates[i], i, li);

        helper(candidates, target, i+1, new ArrayList<>(path));
    }
}

