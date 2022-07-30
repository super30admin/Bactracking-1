//Time Complexity: O(2^n)
//Space Complexity: O(2^n); at each call a new ArrayList is created.
//Code run successfully on LeetCode.

public class Problem1_1 {

    List<List<Integer>> result;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        if(candidates == null|| candidates.length == 0)
            return new ArrayList<>();
        
        result = new ArrayList<>();
        
        helper(candidates, 0 , target, new ArrayList<>());
        return result;
        
    }
    
    private void helper(int[] candidates, int index, int target, List<Integer> path){
        
        if(target == 0){
            result.add(path);
            return;
        }
        
        if(index == candidates.length || target < 0)
            return;
        
        //do not choose
        helper(candidates, index +1, target, path);
        
        //choose
        List<Integer> newList = new ArrayList<>(path);
        newList.add(candidates[index]);
        helper(candidates, index, target - candidates[index], newList);
        
    }
}
