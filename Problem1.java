class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       result = new ArrayList<>();
        // edge
        if(candidates == null || candidates.length == 0) return result;
        //helper(candidates, target, 0, new ArrayList<>(), 0);
        backtrack(candidates, target, 0, new ArrayList<>(), 0);
        return result;
    }
//     private void helper(int[] candidates, int target, int sum, List<Integer> temp, int i){
        
    
//     // base
//     if(sum > target || i >= candidates.length) return;
//     if(sum == target){
//         result.add(temp);
//         return;
//     }
    
//     // logic
    
//     // don't choose
//     helper(candidates, target, sum, new ArrayList<>(temp), i+1);
//     // choose
//     temp.add(candidates[i]);
//     helper(candidates, target, sum + candidates[i], new ArrayList<>(temp), i);
//     }    
    
    
    private void backtrack(int[] candidates, int target, int sum, List<Integer> temp, int index){
        // base
        if(sum == target){
            result.add(new ArrayList<>(temp));
            return;
        }
        if(sum > target) return;
        // logic
        for(int i = index; i < candidates.length; i++){
            // action
            temp.add(candidates[i]);
            //recurse
            backtrack(candidates, target, sum+candidates[i], temp, i);
            //backtrack
            temp.remove(temp.size() - 1);
        }
    }
}
