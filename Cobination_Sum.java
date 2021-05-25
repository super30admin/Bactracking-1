class Solution {
    //Time O(2^(n*target))
    //Space O(H)
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0)
        {
            return result;
        }
        helper(candidates, target, new ArrayList<>(), 0);
        return result;
    }
    private void helper(int[] candidates, int target, List<Integer> path, int index)
    {
        //base
        if(target < 0)
        {
            return;
        }
        if(target == 0)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i=index ; i<candidates.length ; i++)
        {
            path.add(candidates[i]);
            helper(candidates , target-candidates[i], path, i);
            path.remove(path.size()-1);
        }
    }
}