// Time Complexity : O(target/min(candidates)^#candidates), exponential branched by #candidates at max
// Space Complexity : O(target/min(candidates)), plus the recursion stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no, I guess this is the bruteforce approach

// Your code here along with comments explaining your approach
// recursively try selecting candidates, target becomes target-candidates[i]
// to avoid duplicate patterns we only chose value >= past selection
// when target==0 save curPath

class Solution {
    List<List<Integer>> result;
    int[] candidates;
    
    private void tryCombination(int target, int idx, List<Integer> curPath){
        if(target==0){
            result.add(curPath);
        }
        
        for(int i=idx; i<candidates.length; i++){
            if(candidates[i]<=target){
                ArrayList<Integer> path = new ArrayList<Integer>(curPath);
                path.add(candidates[i]);
                tryCombination(target-candidates[i], i, path);                
            }
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<List<Integer>>();
        this.candidates = candidates;
        
        int previouslyChosenCandidateIdx = 0; 
        List<Integer> curPath = new ArrayList<Integer>();
        
        tryCombination(target, previouslyChosenCandidateIdx, curPath);
        
        return result;
    }
}