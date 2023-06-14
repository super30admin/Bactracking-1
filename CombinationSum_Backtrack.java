//Similar to coin change
//TC: 2^(n*m) --> n = length of candidates , m = target
//SC: O(n)
class Solution {
     List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        helper(candidates, 0, target, path);
        return result;
    }

    public void helper(int[] candidates,int i, int amount, List<Integer> path){
        //base
        if(amount == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(amount < 0 || i == candidates.length) return;

        //logic
        //choose :
        //action
        path.add(candidates[i]);
        //recurse
        helper(candidates, i, amount - candidates[i], path);
        //backtrack
        path.remove(path.size() - 1);

        //not choose
        helper(candidates, i+1, amount, path);

    }
}
