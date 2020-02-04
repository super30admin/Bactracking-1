class Solution {
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> resultantList = new ArrayList<>();
        //base case
        if(candidates == null){
            return resultantList;
        }
        //new ArrayList<>() -> temporary created list
        //target -> given target
        //0 -> starting location for the backtracking
        backtractFunction(resultantList, new ArrayList<>(), candidates, target, 0);
        return resultantList;
    }
    
    public void backtrackFunction(List<List<Integer>> resultantList, List<Integer> tempResult, int[] candidates, int currSum, int start){
        
        if(currSum == 0){
            //add tempList to resultantlist 
            resultantList.add(new ArrayList(tempResult));
            return;
        }
        int length = candidates.length;
        //i will change, so we start from the given start index
        for(int i=start; i<length; i++){
            //since i < currentsum -> call backtrack function again for same/next element
            if(candidates[i] <= currSum){
                tempResult.add(candidates[i]);
                backtrackFunction(resultantList, tempResult, candidates, currSum - candidates[i], i);
                // to avaoid taking same element again and again
                //remove after execution and before proceeding to next element
                //backtrack
                tempResult.remove(tempResult.size()-1);
            }
        }
    }
    
}