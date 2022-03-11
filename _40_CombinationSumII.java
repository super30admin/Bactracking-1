
// Time Complexity : o(2^(n/min(candidate[i])))*n where n is length of string as at eevry step we have two choices to choose or not
// Space Complexity : o(n/min(candidate[i])) length of recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// start from index and leep track of sum so far if sum is greater than target then Backtrack
// to remove duplicates if two elements are same the return and index is not at starting index
class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        combinationSum(candidates, target, new ArrayList<>(), 0, 0);
        return res;
    }

    public void combinationSum(int[] candidates, int target,
                                              List<Integer> currPath, int currSum,
                              int currIndex) {

        if(currSum > target) return;

        if(currSum == target){
            res.add(new ArrayList<>(currPath));
            return;
        }

        for(int i = currIndex; i<candidates.length; i++){


            if(i != currIndex && candidates[i] == candidates[i-1] ) continue;


            currSum += candidates[i];
            currPath.add(candidates[i]);
            combinationSum(candidates, target, currPath, currSum, i+1);
            currSum -= candidates[i];
            currPath.remove(currPath.size()-1);


        }

    }
}
