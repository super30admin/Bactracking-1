class Solution {
    List<List<Integer>> output;
    int sum;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        output = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        sum = target;
        if (candidates == null || candidates.length == 0) return output;
        helper(candidates,0,currentPath,0);
        return output;
        
    }
    
    private void helper(int[] candidates, int currSum, List<Integer> currentPath,int index ){
        
        //Base Case
        
       if (currSum == sum){
            output.add(new ArrayList<>(currentPath));
           return;
        }
        
        if (currSum > sum || index == candidates.length) return;
        
        for (int x = index; x < candidates.length; x++){
            
            // action
            currentPath.add(candidates[x]);
            
            //recursion
            
            helper(candidates, currSum + candidates[x], currentPath, x);
            
            //backtrack
            
            currentPath.remove(currentPath.size() - 1);
            
        }

        //dont chose
        //helper(candidates,currSum, new ArrayList<>(currentPath),index+1);
        
        //chose
        //currentPath.add(candidates[index]);
        //helper(candidates,currSum + candidates[index], new ArrayList<>(currentPath),index);
        
       
    }
}