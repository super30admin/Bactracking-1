/* Time Complexity : O(2^target) 
   Space Complexity : recursive stack space=O(h) where h is height of the recursive tree  
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
*/
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res= new ArrayList<>();
        helper(candidates, target, 0,0, new ArrayList<>());
        return res;
    }
    private void helper(int[] ar, int target, int sum,int index,List<Integer> targetArr){
        //base
        if(ar.length==index || sum>target)
        {
            return;
        }
        if(sum==target){
            res.add(new ArrayList<>(targetArr));
            return;
        }
        //logic
        helper(ar,target,sum,index+1,targetArr);
        targetArr.add(ar[index]);
        helper(ar,target,sum+ar[index],index,targetArr);
        targetArr.remove(targetArr.size()-1);
    }
}