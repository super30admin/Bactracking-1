/**
 * Time: Exponential - O(2^n) where n is the target value
 * Space: O(n)
 */
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        dfs(candidates,target,0,new ArrayList<Integer>(),0);
        return res;
    }
    public void dfs(int[] candidates, int target, int sum, List<Integer> lst, int index){
        if(sum == target){
            res.add(new ArrayList<>(lst));
            return;
        }
        if(index >= candidates.length || sum > target) return;

        //choose
        lst.add(candidates[index]);
        dfs(candidates, target, sum+candidates[index], lst,index);
        lst.remove(lst.size()-1);

        //dont choose
        dfs(candidates, target, sum, lst, index+1);

    }
}