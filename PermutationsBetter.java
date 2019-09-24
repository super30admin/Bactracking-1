class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        backtrack(result, nums, 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, int[] nums, int k) {
        if(k == nums.length - 1) {
            List<Integer> solution = new LinkedList<>();
            for(int n : nums) {
                solution.add(n);
            }
            result.add(solution);
            return;
        }
        
        backtrack(result, nums, k + 1);
        for(int i = k + 1; i < nums.length; i++) {
            swap(nums, k, i);
            backtrack(result, nums, k + 1);
            swap(nums, k, i);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
