// Time Complexity : O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>());
        return result;
    }
    
    private void dfs(int[] candidates, int target, int pivot, List<Integer> path){
        //base
        if(target==0){
            //result.add(new ArrayList<>(path));
            result.add(path);
            return;
        }
        if(target<0 || pivot==candidates.length){
            return;
        }
        
        //logic
        for(int i=pivot;i<candidates.length;i++){
            List<Integer> temp = new ArrayList<>(path);
            temp.add(candidates[i]);
            //path.add(candidates[i]);
            dfs(candidates, target-candidates[i], i, temp);
            //path.remove(path.size()-1);
        }
    }
}