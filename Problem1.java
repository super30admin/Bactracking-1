// time Complexity : O(2^n)  -- exponential
//

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> list = new ArrayList<>();
        Array.sort(candidates);
        backTrack();
        
    }
    public void backTrack(List<List<Integer>> list, int target, int remain,int start){
        if(remain<0) return;
        else if(remain == 0) list.add(new ArrayList());
        else{
            for(int i=start;i<nums.length;i++)
                tempList.add(candidates[i]);
                backtrack(list,target,reamin-candidates[i],i);
            
        }
    }
}
