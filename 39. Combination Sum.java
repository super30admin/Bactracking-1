class Solution {// n is no. of elements m is min element in list and t i target
    // time of O(n)^t/m and space of t/m 
    List<List<Integer>> output;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        output = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0,new ArrayList<Integer>(),target,candidates,0);
        return output;
    }
    private void helper(int currSum , ArrayList<Integer> out , int target , int[] candidates , int index)
    {
        //base case
        if(currSum> target)
            return;
        if(currSum == target)
        {
            output.add(new ArrayList<Integer>(out));
            return ;
        }
        
         for(int i = index ; i < candidates.length ; i++)
         {
             int val = candidates[i];
             //Make a choice
             out.add(val);
             //follow the path
             helper(currSum+val,out,target,candidates,i);
             //undo the choice
             out.remove(out.size()-1);
         }
    }
}