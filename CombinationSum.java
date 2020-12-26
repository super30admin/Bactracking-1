/*
Time Complexity : Exponential
Space Complexity : O(n + target)
Idea : We choose an element only is it can take us close to target and if that choice leads us to the target we add
it in the array otherwise we backtrack. The one good quality of this thinking is it does not create new
array at each recursion call but uses a single array throughout saving on space complexity. The time 
complexity is dominated by the expansion of combination.
*/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        helper(candidates,target,ans,new ArrayList<Integer>(),0,0);
        return ans;
    }
    
    public void helper(int[] candidates, int target,List<List<Integer>> ans,List<Integer> comb,int curr,int start){
        if(curr == target){
            ans.add(new ArrayList(comb));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(candidates[i]+curr<= target){
              comb.add(candidates[i]);
              helper(candidates,target,ans,comb,curr+candidates[i],i);
              comb.remove(comb.size()-1);
            }
            
        }
    }
}