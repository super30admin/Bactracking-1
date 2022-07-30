//Time Complexity: O(2^n)
//Space Complexity: O(n); Recursion Stack Space
//Code run successfully on LeetCode.

public class Problem1_4 {

    List<List<Integer>> result;
    List<Integer> path;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        if(candidates  == null || candidates.length == 0)
            return new ArrayList<>();
        
        result = new ArrayList<>();
        path = new ArrayList<>();
        helper(candidates ,0 , target, path);
        return result;
    }
    
    private void helper(int[] candidates, int index, int target, List<Integer> path){
        
        if(target < 0)
            return;
        
        if(target == 0)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = index; i < candidates.length; i++){
            
            path.add(candidates[i]);
            helper(candidates, i, target - candidates[i], path);
            path.remove(path.size() - 1);
        }
    }
}
