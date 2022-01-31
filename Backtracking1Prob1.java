// Time Complexity : O(2^n ) 
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : yes


// approach : Implemented backtracking using for-loop based recursion

class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    int n;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        if(candidates == null || candidates.length == 0 ) return null;
        n = candidates.length;
        
        helper(candidates,0,target,new ArrayList<>());
        return result;
    }
    
    private void helper(int[] candidates,int index,int target,List<Integer> path){
        //base
        
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        
        if(target < 0 || index == n)
            return;
        
        for(int i=index;i<n;i++){
            
            path.add(candidates[i]);
            helper(candidates,i,target-candidates[i],path);
            path.remove(path.size() -1);
        }
        
    }
}