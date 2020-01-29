// Time Complexity : O(n4^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> resultantList = new ArrayList<>();
        //base case
        if(candidates == null){
            return resultantList;
        }
        backtrack(resultantList, new ArrayList<>(), candidates, target, 0);	// recursively call the backtrack function
        return resultantList;
    }

    public void backtrack(List<List<Integer>> resultantList, List<Integer> tempResult, int[] candidates, int currSum, int start){

        if(currSum == 0){
            //add tempList to result list 
            resultantList.add(new ArrayList(tempResult));
            return;
        }

        for(int i=start; i<candidates.length; i++){
            
            if(candidates[i] <= currSum){
                tempResult.add(candidates[i]);
                backtrack(resultantList, tempResult, candidates, currSum - candidates[i], i); // with start index fixed, continue to find all the possible combinations 
                tempResult.remove(tempResult.size()-1);	// once the result is found, remove the recently added element to get the proper list
            }
        }
    }

}