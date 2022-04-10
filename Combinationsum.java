// Time Complexity : O(target / min(elements)) + O(length of input array)
// Space Complexity : O(target / min(elements)) + O(length of input array)
// Did this code successfully run on Leetcode : yes

class Solution {

    //code 4 : for loop recursion and backtracking

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        result = new ArrayList();
        helper(candidates, 0, new ArrayList(), target);
        return result;
    }

    private void helper(int[] candidates, int index, List<Integer> path, int target)
    {
        //base cases
        if(target < 0)
            return;

        if(target == 0)
        {
            result.add(new ArrayList(path));
            return;
        }

        //logic

        for(int i=index; i<candidates.length; i++)
        {
            //action
            path.add(candidates[i]);
            //recurse
            helper(candidates, i, path, target - candidates[i]);
            //backtrack
            path.remove(path.size() - 1);
        }
    }
}
