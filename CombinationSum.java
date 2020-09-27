// Time Complexity : O(n^n) 
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approachclass 
class Solution {
    List<List<Integer>> output;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
         output = new ArrayList();
        List<Integer> path = new ArrayList();
        
        backtracking(candidates,target,0,path);
        
        return output;
        
    }
    
    private void backtracking(int[] candidates, int target, int index, List<Integer>path){
        
        if(target<0){
            return;
        }else if(target==0){
            output.add(new ArrayList(path));
        }else if(index>=candidates.length){
            return;
        }
        
        for(int i=index;i<candidates.length;i++){
            
            path.add(candidates[i]);
            
            backtracking(candidates, target-candidates[i], i, path);
            
            path.remove(path.size()-1);

        }
    }
}