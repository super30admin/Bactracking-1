//Time Complexity: O(2^n)
//Space Complexity: O(2^n); since an ArrayList is created at every call.
//Code run successfully on LeetCode.

public class Problem1_3 {

    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        if(candidates  == null || candidates.length == 0)
            return new ArrayList<>();
        
        result = new ArrayList<>();
        
        helper(candidates ,0 , target, new ArrayList<>());
        return result;
    }
    
    private void helper(int[] candidates, int index, int target, List<Integer> path){
        
        if(target < 0)
            return;
        
        if(target == 0)
        {
            result.add(path);
            return;
        }
        
        for(int i = index; i < candidates.length; i++){
            
            List<Integer> newList = new ArrayList<>(path);
            newList.add(candidates[i]);
            helper(candidates, i, target - candidates[i], newList);
        }
    }
}
