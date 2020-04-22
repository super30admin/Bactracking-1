import java.util.ArrayList;
import java.util.List;
// Time Complexity : O(2^n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    List<List<Integer>> output = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null || candidates.length==0) return output;
        recurr(candidates, target,0,new ArrayList<>(),0);
        return output;
    }
    private void recurr(int[] candidates, int target, int sum, List<Integer> temp,int index)
    {
        //base condition
        if(index==candidates.length) return;
        if(sum==target)
        {
            output.add(new ArrayList<>(temp));
            return;
        }
        if(sum>target) return;
        
        //recurse
        recurr(candidates, target,sum,temp,index+1);
        temp.add(candidates[index]);
        recurr(candidates, target,sum+candidates[index],temp,index);
        //backtracking
        temp.remove(temp.size()-1);
        
    }
}