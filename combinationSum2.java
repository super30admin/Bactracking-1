//same recursive solution but say if you want to use choose case before not choose case 
// we should first transter it to new list because if we directly add to path then it'll also be added to not choose case also
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) {
            return result;
        }
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }
    private void helper(int[] candidates, int target, int index, List<Integer> path) {
        //base
        if(target == 0) {
            result.add(path);
            return;
        }
        if(index == candidates.length || target < 0) {
            return;
        }
        //logic
        //1 case choose
        List<Integer> list = new ArrayList<>(path);
        list.add(candidates[index]);
        helper(candidates, target - candidates[index], index, list);
        //0 case not choose
        helper(candidates, target, index + 1, new ArrayList<>(path));
        
    }
}