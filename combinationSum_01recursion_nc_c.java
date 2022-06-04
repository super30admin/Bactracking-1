//Time Complexity :  O(N^2)
//Space Complexity : O(N^2)
//Approach : 01 recursion . new copy path in each recursive call.
//Did your code run on leetcode : yes

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        
        if(candidates == null || candidates.length == 0) return result;
        
        helper(candidates,target,0,new ArrayList<>());
        return result;
    }
    
    private void helper(int[] candidates, int target, int i , List<Integer> path)
    {
        //base
        if(target == 0)
        {
         result.add(path);
          return;   
        }
            
            
        if(i == candidates.length || target < 0) return;
        
        //logic
        //notChoose 
         helper(candidates, target, i + 1, new   ArrayList<>(path)); //creating new copy of path for every recursive call
          path.add(candidates[i]);
        //choose
        helper(candidates, target - candidates[i], i, new   ArrayList<>(path)); //creating new copy of path for every recursive call
        
    }
}
