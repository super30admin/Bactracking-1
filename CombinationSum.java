// Time Complexity : O(2^m*n)
// Space Complexity : O(2^m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class CombinationSum
{
    // recursive backtracking
    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        helper(candidates, 0, target, new ArrayList());
        return result;
    }

    public void helper(int[] candidates, int idx, int target, List<Integer> path)
    {
        // base
        if(idx >= candidates.length || target < 0)
            return;
        if(target == 0)
        {
            result.add(new ArrayList(path));
            return;
        }

        //Not choose
        helper(candidates, idx +1, target, path);
        //Choose
        // action
        path.add(candidates[idx]);
        helper(candidates, idx, target - candidates[idx], path);

        // backtrack
        path.remove(path.size()-1);
    }

    // For loop based recurision

    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList());
        return result;
    }

    void helper(int[] candidates, int pivot, int target, List<Integer> path)
    {
        if(target < 0 || pivot >= candidates.length)
            return;
        if(target == 0)
            result.add(new ArrayList(path));

        for(int i = pivot; i < candidates.length; i++)
        {
            if( (target - candidates[i]) < 0)
                break;
            path.add(candidates[i]);
            helper(candidates, i, target - candidates[i], path);
            path.remove(path.size()-1);
        }
    }

}
