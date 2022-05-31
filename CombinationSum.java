
//Time: O(2^N) | Space: O(N)

class Solution {
    private List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }
    private void helper(int[] candidates, int target, int pivot, List<Integer> currList) {


        if(target == 0) {
            result.add(new ArrayList<>(currList));
            return;
        }
        if(target < 0) return;
        //
        //for loop based recurision
        for(int i=pivot;i<candidates.length;i++) {
            currList.add(candidates[i]);
            helper(candidates, target - candidates[i],i,currList);
            currList.remove(currList.size()-1);
        }

    }
}

// Normal choose not choose scenario - with two options
// same complexities as above

class Solution {
    private List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        dp(candidates, target, 0, 0, new ArrayList<>());
        return result;
    }
    private void dp(int[] candidates, int target, int currIndex, int currSum, List<Integer> currList) {

        if(currIndex >= candidates.length || currSum > target) {
            return;
        }
        if(currSum == target) {
            result.add(new ArrayList<>(currList));
            return;
        }
        //

        dp(candidates, target, currIndex+1, currSum, currList);
        currList.add(candidates[currIndex]);
        dp(candidates, target, currIndex, currSum+candidates[currIndex],currList);
        currList.remove(currList.size()-1);
    }
}