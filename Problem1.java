//time exponential
//space o(n) n is the no of candidates
class Solution {
    List<List<Integer>> res;
    int tar;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        tar = target;
        if(candidates == null || candidates.length == 0)
            return res;
        backtrack(candidates, 0, 0, new ArrayList<>());
        return res;
    }
    
    private void backtrack(int[] candidates, int index, int sum, List<Integer> list) {
        //base case
        if(sum == tar) {
            res.add(new ArrayList<>(list));
            return;
        }
        if(sum > tar)
            return;
        //logic
        for(int i=index;i<candidates.length;i++) {
            list.add(candidates[i]);
            backtrack(candidates, i, sum + candidates[i], list);
            list.remove(list.size()-1);
        }
    }
}