class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> state = new ArrayList<>();
        backtrack(candidates, 0, target, 0, state, result);
        return result;
    }
 
    private void backtrack(int[] candidates, int start, int target, int sum,
                        List<Integer> state, List<List<Integer>> result){
     
        if(sum>target){
            return;
        }

        if(sum==target){
            result.add(new ArrayList<>(state));
        }

        for(int i=start; i<candidates.length; i++){
            state.add(candidates[i]);
            backtrack(candidates, i, target, sum+candidates[i], state, result);
            state.remove(state.size()-1);
        }
    }
}
