//Time Complexity: O(N log N)
//Space Complexity: O(N)
//Tried on leetcode:accepted after 4 attempts 
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        List<List<Integer>> res = new ArrayList<>();
        //If the candidates list itself is an empty list
        if(candidates==null || candidates.length==0)
        {
            //Return empty result lisyt
            return res;
        }
        //sort the given candidates array
        Arrays.sort(candidates);
        //An array to store the combinations
        List<Integer> combinations = new ArrayList<>();
        //A function to find the combinations with summations that is equal to target
        //pass the result,combinations,candidates,target and the start index as input to the recursive function
        toFindCombinationtoTarget(res,combinations,candidates,target,0);
        return res;
    }
    private void toFindCombinationtoTarget(List<List<Integer>> res, List<Integer> combinations, int[] candidates, int target, int startIndex)
    {
        //If the target is 0
        if(target==0)
        {
            //Add that combination to the res
            res.add(new ArrayList<>(combinations));
            return;
        }
        //Iterate over the length of candidates from the start index
        for(int i=startIndex; i<candidates.length; i++)
        {
            //if the candidate number is greater than the target value break from loop
            if(candidates[i]>target)
            {
                break;
            }
            //else add the candidate value to combinations list
            combinations.add(candidates[i]);
            //recursively call the tofindcombinatiototarget function for next value in combo until target achieved
            toFindCombinationtoTarget(res,combinations,candidates,target-candidates[i],i);//(backtracking)
            //remove the last combination from the list of combinations
            combinations.remove(combinations.size()-1);
        }
    }
}