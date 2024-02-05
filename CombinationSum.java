// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Method used : Backtracking

class Solution {

    List<List<Integer>> result = new ArrayList();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        helper(candidates, target, 0, 0, new ArrayList());
        return result;
    }

    private void helper(int[] candidates, int target, int sum, int index, List<Integer> temp)
    {
        if(index == candidates.length || sum > target) return;

        if(sum == target)
        {
            result.add(new ArrayList(temp));
            return;
        }

        // don't pick
        helper(candidates, target, sum, index + 1, temp);

        // If I pick these are the following steps

        // action
        temp.add(candidates[index]);

        // recurse
        helper(candidates, target, sum + candidates[index], index, temp);

        // backtrack
        temp.remove(temp.size() - 1);

    }
}