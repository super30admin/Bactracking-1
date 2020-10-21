/*
 Time Complexity: O(N^T/M)
 Space complexity: O(T/M)
*/


class Solution {
    
    List<List<Integer>> output;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        output = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0,new ArrayList<Integer>(),target,candidates,0);
        return output;        
    }
    
    private void helper(int currSum, ArrayList<Integer> out, int target, int[] candidates, int index){
        
        if(currSum > target)
            return;
        if(currSum == target)
        {
            output.add(new ArrayList<Integer>(out));
            return;
        }
    
        for(int i= index;i<candidates.length;i++)
        {
            int val = candidates[i];
            out.add(val);
            helper(currSum+val,out,target,candidates,i);
            out.remove(out.size()-1);
        }
        
    }
        
        
}