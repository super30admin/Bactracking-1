//https://leetcode.com/problems/combination-sum/
/*
Time: Time: O(N^(T/M + 1)) where N = candidates, T=target, M=min among the candidates
Space: O(T/M)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList();
        // Arrays.sort(nums);
        backtrack(result, new ArrayList(), nums, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int remaining, int index) {
        if (remaining < 0)
            return;

        else if (remaining == 0)
            result.add(new ArrayList<>(tempList));

        else {
            for (int i = index; i < nums.length; i++) {
                tempList.add(nums[i]);
                backtrack(result, tempList, nums, remaining - nums[i], i); // not i + 1 because we can reuse same
                                                                           // elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }

}
