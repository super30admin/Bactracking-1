class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //Result
        List<List<Integer>> result = new ArrayList<>();
        //States 
        List<Integer> state = new ArrayList<>();
        
        backtrack(result, candidates, target, state, 0, 0);
        
        return result;
    }
    private void backtrack(List<List<Integer>> result, int[] candidates, int target, List<Integer> state, int sum, int index)
    {
        //System.out.println(state+"\t");
        //IsWorthExploring
        if(sum > target)
            return;
        
        //IsGoal
        if(sum == target){
            result.add(new ArrayList<>(state));
            return;
        }
        
        //try other candidates
        for(int i=index; i<candidates.length; i++)
        {
            //exploring state space
            
            state.add(candidates[i]);
            backtrack(result, candidates, target, state, sum+candidates[i], i);
            state.remove(state.size()-1);
        }
    }
}