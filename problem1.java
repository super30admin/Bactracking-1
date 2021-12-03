// Combination Sum
// solved on leetcode
// Time Complexity : Exponential
// Space Complexity : O(n)


class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        dfs(candidates,target,result,new ArrayList(),0);
        return result;
    }
    
    private void dfs(int[] candidates,int target, List<List<Integer>> result,List<Integer> array,int index){
        if(target==0){
            result.add(new ArrayList(array));
            return ;
        }
        
        if(target<0 || index== candidates.length){
            return;
        }
        
        for(int i=index;i<candidates.length;i++){
            array.add(candidates[i]);
            dfs(candidates,target-candidates[i],result,array,i);
            array.remove(array.size()-1);
        }
    }
}