//TC : O(exponential) SC : O(exponential)
class Solution {
    ArrayList <List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        helper(candidates,target,0,path);
        return result;
    }

    private void helper(int[] candidates, int target, int idx, ArrayList<Integer> path)
    {
        //base 
        if(target == 0)
        {
            ArrayList<Integer> temp = new ArrayList<>(path);
            result.add(temp);
            return;
        }
        if(target<0)
            return;
        //logic

        for(int i=idx;i<candidates.length;i++)
        {
            path.add(candidates[i]);
            helper(candidates,target-candidates[i],i,path);
            path.remove(path.size()-1);
        }
    }
}