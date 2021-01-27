// Time Complexity : O(N power T/M)  T/M is height of the N-ary tree.T is target and M is min value.
// Space Complexity : O(T/M)
// Did this code successfully run on Leetcode : Yes

// backtrack for loop solution
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0)
            return result;
        backtrack(candidates, 0, new ArrayList<Integer>(), target);
        return result;
    }
    private void backtrack(int[] candidates, int index, List<Integer> path, int target){
        //base
        if(target < 0){
            return;
        }
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i = index; i < candidates.length; i++){
            path.add(candidates[i]);
            backtrack(candidates, i, path, target-candidates[i]);
            path.remove(path.size() - 1);
        }
    }
}

/*
// backtrack 1-0 solution
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0)
            return result;
        backtrack(candidates, 0, new ArrayList<Integer>(), target);
        return result;
    }
    private void backtrack(int[] candidates, int index, List<Integer> path, int target){
        //base
        if(index == candidates.length || target < 0){
            return;
        }
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        //dont choose
        backtrack(candidates, index+1, path, target);
        //choose
        path.add(candidates[index]);
        backtrack(candidates, index, path, target-candidates[index]);
        path.remove(path.size() - 1);
    }
}
*/

/*
// recursive for loop solution
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0)
            return result;
        backtrack(candidates, 0, new ArrayList<Integer>(), target);
        return result;
    }
    private void backtrack(int[] candidates, int index, List<Integer> path, int target){
        //base
        if(target < 0){
            return;
        }
        if(target == 0){
            result.add(path);
            return;
        }
        //logic
        for(int i = index; i < candidates.length; i++){
            List<Integer> temp = new ArrayList<>(path);
            temp.add(candidates[i]);
            backtrack(candidates, i,temp , target-candidates[i]);
        }
    }
}
*/

/*
// recursive 1-0 solution
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0)
            return result;
        helper(candidates, 0, new ArrayList<Integer>(), target);
        return result;
    }
    private void helper(int[] candidates, int index, List<Integer> path, int target){
        //base
        if(index == candidates.length || target < 0){
            return;
        }
        if(target == 0){
            result.add(path);
            return;
        }
        //logic
        //choose
        List<Integer> temp = new ArrayList<>(path);
        temp.add(candidates[index]);
        helper(candidates, index, temp, target-candidates[index]);
        //dont choose
        helper(candidates, index+1, new ArrayList<>(path), target);
    }
}
*/