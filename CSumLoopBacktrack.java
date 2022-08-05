//Time Complexity: O(2^n), 2 recursive calls for every index till n
//Space Complexity: O(n), Recursion Stack Space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class CSumLoopBacktrack {
    List<List<Integer>> result ;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        int index = 0;
        helper(candidates, target, index, new ArrayList<>());
        return result;
    }

    public void helper(int[] candidates, int target, int index, List<Integer> path){

// For Loop, Backtracking approach
        if(target < 0)  return;
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i=index; i<candidates.length; i++) {
            path.add(candidates[i]);
            helper(candidates, target-candidates[i], i, path);
            path.remove(path.size()-1);
        }

    }
}