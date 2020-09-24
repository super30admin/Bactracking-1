// Time Complexity : O(n*n^n) (for loop+exploring nodes at each node)
// Space Complexity : O(m) (m is the max number of nodes that can be added in the list path without exceeding target)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null||candidates.length==0) return new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        List<List<Integer>> res= new ArrayList<>();
        backTrack(res,candidates,target,0,path);
        return res;
    }
    
    private void backTrack(List<List<Integer>> res, int[] candidates,int target,int index, List<Integer> path ){
            if(target==0){
            res.add(new ArrayList<>(path));
            return;
            }
            else if(target<0){
              return; 
            }
             else if(index>=candidates.length){
             return;
            
        }
        //recursive case
        
        for(int i=index;i<candidates.length;i++){
            path.add(candidates[i]);
            
            backTrack(res,candidates,target-candidates[i],i,path);
            path.remove(path.size()-1);
        }
    }
}