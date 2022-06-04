//Time Complexity :  O(N)
//Space Complexity : O(N)
//Approach : for loop based recursion with backtracking
//Did your code run on leetcode : yes

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        
        if(candidates == null || candidates.length == 0) return result;
        
        helper(candidates,target,0,0,new ArrayList<>());
        return result;
    }
    
    private void helper(int[] candidates, int target, int i , int pivot, List<Integer> path)
    {
        //base
        if(target == 0)
        {
         result.add(new ArrayList<>(path));//creating deep copy of path
          return;   
        }
            
            
        if(i == candidates.length || target < 0) return;
        
        //logic
        for(i = pivot ; i < candidates.length;i++)
        {
            //choose
            path.add(candidates[i]);
            helper(candidates, target - candidates[i], i,i, path);
            //backtracking
            path.remove(path.size()-1);
        
        }
          
        
    }
}
