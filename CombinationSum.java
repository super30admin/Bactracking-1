// TIME: O(N^(T/M)) where T is target and M is min of the values given
// SPACE: O(T/M)
// SUCCESS on LeetCode

public class CombinationSum {
    List<List<Integer>> answer;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        answer = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>());
        return answer;
    }
    
    private void helper(int[] nums, int index, int target, List<Integer> list) {
        if (target < 0) return;
        
        if (index == nums.length) return;
        
        if (target == 0) {
            answer.add(new ArrayList<>(list));
            return;
        }
        
        list.add(nums[index]);
        helper(nums, index, target - nums[index], list);
        list.remove(list.size() - 1);
        
        helper(nums, index + 1, target, list);
    }
}
