class Solution {

    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(0, target, new LinkedList<>(), candidates);
        return result;   
    }

    private void helper(int idx, int target, List<Integer> path, int[] candidates){

        if(target == 0){
            result.add(path);
            return;
        }

        if(idx == candidates.length || target < 0) return;

        // not considering idx
        helper(idx+1, target, new LinkedList<>(path), candidates);
        // considering idx
        path.add(candidates[idx]);
        helper(idx, target-candidates[idx], new LinkedList<>(path), candidates);
    }
}
