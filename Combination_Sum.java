Time Complexity: (2^n)
Space Complexity: (2^n)

//Backtracking solution

class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        if(candidates == null || candidates.length ==0)
            return result;
        
        backtrack(candidates, 0, target, 0, new ArrayList<>());
        
        return result;  
    }
    
    private void backtrack(int[] candidates, int index, int target, int sum, List<Integer> temp)
    {
        if(sum > target) 
            return;
        
        if(sum == target){
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=index; i<candidates.length; i++)
        {
            temp.add(candidates[i]);
            
            backtrack(candidates, i, target, sum+candidates[i], new ArrayList<>(temp));
            
            temp.remove(temp.size()-1);
            
        }

        
    }
}

Time Complexity: n*(2^n)
Space Complexity: n*(2^n)

//Recursive Solution
class Solution {
 
    List<List<Integer>> result = new ArrayList<>();
 
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
     
        if(candidates == null || candidates.length ==0)
            return result;
     
        helper(candidates, 0, target, 0, new ArrayList<>());
     
        return result;  
    }
 
    private void helper(int[] candidates, int index, int target, int sum, List<Integer> temp)
    {
        if(sum > target || index >= candidates.length) 
            return;
     
        if(sum == target){
            result.add(temp);
            return;
        }
   
         //if not chosen
        helper(candidates, index+1, target, sum, new ArrayList<>(temp));
        temp.add(candidates[index]);
     
        //if chosen
        helper(candidates, index, target, sum + candidates[index], new ArrayList<>(temp));

     
    }
}
