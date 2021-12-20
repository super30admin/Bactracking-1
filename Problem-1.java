// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    List< List<Integer>> result;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        
        dfs(candidates,target,0,new ArrayList<>());
        
        return result;
    }
    
    private void dfs(int[] candidates, int target, int index,List<Integer> currPath) {
        if(target<0) {
            return;
        }
        
        if(index == candidates.length) {
            return;
        }
        
        if(target == 0) {
            result.add(new ArrayList(currPath));
        }
        
        for(int i=index;i<candidates.length;i++) {
            currPath.add(candidates[i]);
            dfs(candidates,target-candidates[i],i,currPath);
            currPath.remove(currPath.size()-1);
        }
    }
}