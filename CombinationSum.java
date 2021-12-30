// Time complexity :O(N)
// Space complexity :O(1)
// leetcode : success

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates,target, 0 , new ArrayList<>() , result);
        
        return result;
      
    }
    
    private void helper(int[] candidates , int target , int index,List<Integer> list, List<List<Integer>> result){
        
         if(target == 0){
            
            result.add(new ArrayList<>(list));
            return;
        }
        
        if(target < 0 || index == candidates.length){
            return;
        }
         
          helper(candidates,target, index+1 , list , result);
          list.add(candidates[index]);
          helper(candidates,target - candidates[index], index , list , result);
          list.remove(list.size()-1);
           
    }
}