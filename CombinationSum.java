// Time Complexity : O(exp)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
For loop based recursion and backtracking
*/
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result= new ArrayList<>();
        if(candidates.length==0 || candidates== null) return result;
        helper(candidates, target,result, new ArrayList<>(),0,0);
        return result;
    }

    private void helper(int[] candidates, int target,  List<List<Integer>> result, ArrayList<Integer> values,int csum,int start){
        if(csum>target) return;
        if(csum==target){
            result.add(new ArrayList<>(values));
            return;
        }

        for(int i=start;i<candidates.length;i++){
            values.add(candidates[i]);
            helper(candidates,target,result,values, csum+candidates[i],i);
            values.remove(values.size()-1);
        }
    }
}
