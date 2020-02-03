/*
	Time Complexity : O(2^n)
	Space Complexity : 


*/

class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        if(candidates == null || candidates.length == 0){
            return result;
        }
        
        helper(candidates, target, 0, new ArrayList<Integer>(), 0);
        return result;
    }
    
    private void helper(int[] candidates, int target, int sumSoFar, List<Integer> temp, int index){
    
        if(index == candidates.length || sumSoFar > target){
            return;
        }
        if(sumSoFar == target){
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=index; i<candidates.length; i++){
            temp.add(candidates[i]);
            helper(candidates, target, sumSoFar + candidates[i],temp, i);
            temp.remove(temp.size()-1);
        }
    }
}