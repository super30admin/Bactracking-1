// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    List<List<Integer>> result;
    int targ;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        targ = target;
        result = new ArrayList<>();
        if(candidates==null||candidates.length==0){
            return result;
        }
        backtrack(candidates,0,new ArrayList<>(),0);
        return result;
    }
    
    private void backtrack(int[] candidates, int sum, List<Integer> temp, int index){
        if(sum==targ){
            result.add(new ArrayList<>(temp));
            return;
        }
        
        if(sum>targ)return;
        
        for(int i=index;i<candidates.length;i++){
            temp.add(candidates[i]);
            backtrack(candidates,sum+candidates[i],temp,i);
            temp.remove(temp.size()- 1);
        }
    }
    
}