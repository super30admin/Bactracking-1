class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {

        helper(candidates,target,0,new ArrayList<>());
        return res;

    }

    private void helper(int[] candidates, int target , int i , ArrayList<Integer> temp)
    {
        if(target == 0)
        {
            res.add(new ArrayList<>(temp));
            return;
        }

        if(target<0 || i>=candidates.length) return;

        temp.add(candidates[i]);
        helper(candidates,target-candidates[i],i,temp);
        temp.remove(temp.size()-1);
        helper(candidates,target,i+1,temp);
    }
}
