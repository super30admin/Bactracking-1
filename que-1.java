//TC:
//SC: 
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        getResult(result, new ArrayList<Integer>(), candidates, target, 0);
        
        return result;
    }
    private void getResult(List<List<Integer>> result, List<Integer> currArray, int candidates[], int target, int startIndex){
    	if(target > 0){
    		for(int i = startIndex; i < candidates.length && target >= candidates[i]; i++){
    			currArray.add(candidates[i]);
    			getResult(result, currArray, candidates, target - candidates[i], i);
    			currArray.remove(currArray.size() - 1);
    		}//for
    	}//if
    	else if(target == 0 ){
    		result.add(new ArrayList<Integer>(currArray));
    	}//else if
    }

}