class Solution {
    // declaring a global result 
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length == 0){
            return result;
        }
        backtrack(candidates, target, 0, 0, new ArrayList<>());
        return result;
    }
    
    // backtrakck function
    private void backtrack(int[] candidates, int target, int index, int curSum, List<Integer> path){
        // base condition
        if(curSum > target){
            return;
        }
        // another base condition to add path to result 
        if(curSum == target){
            result.add(new ArrayList<>(path));   
        }
        // Iterating from index to candidates array, finding all the combinations
        for(int i=index; i<candidates.length; i++){
            path.add(candidates[i]);
            backtrack(candidates, target, i, curSum+candidates[i], path);
            path.remove(path.size()-1);
        }
    }
}