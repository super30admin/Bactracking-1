// Time Complexity : 
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> l1=new ArrayList<>();
        if(candidates==null|| candidates.length==0){
            return l1;
        }
        
        
        Arrays.sort(candidates);
        List<Integer> combination=new ArrayList<>();
        toFindCombination(l1,candidates,target,combination,0);
        return l1;
    }
    
    
    
    private void toFindCombination(List<List<Integer>> l1, int[] candidates, int target, List<Integer> combination, int startIndex ){
        
        if(target==0){
            l1.add(new ArrayList<>(combination));
            return;
        }
        
        for(int i=startIndex;i<candidates.length;i++){
            if(candidates[i]>target){
                break;
            }
            
            combination.add(candidates[i]);
            toFindCombination(l1,candidates,target-candidates[i],combination,i);
            combination.remove(combination.size()-1);
        }
    }
    
}