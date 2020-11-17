//Combination Sum

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return result;
        }
        Backtracking(candidates,target, 0, new ArrayList<>(), 0);
        return result;
    }
    
    private void Backtracking(int[] candidates, int target, int sum,List<Integer> temp, int index){
        if(sum == target){
            result.add(new ArrayList<>(temp));
        }
        if(sum > target){
            return;
        }
        for(int i = index; i < candidates.length; i++){
            temp.add(candidates[i]);
            Backtracking(candidates,target, sum+candidates[i],temp, i);
            temp.remove(temp.size() - 1);
        
        }
    
    }
}