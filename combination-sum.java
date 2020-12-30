// Time - O(NlgN + N)
// Space - O(N)

class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{ 
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
// Time - O(N+M)
// space - O(N+M)

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length == 0) {
            return result;
        }
        
        helper(candidates, 0, target, 0, new ArrayList<>());
        return result;        
    }
    
    private void helper(int[] candidates, int index, int target, int curSum, List<Integer> list) {
        
        if(index >= candidates.length || target < curSum) {
            return;
        }
        if(target == curSum) {
            result.add(list);
            return;
        }
        
        helper(candidates, index + 1, target, curSum, new ArrayList<>(list));
        list.add(candidates[index]);
        helper(candidates, index, target, curSum + candidates[index], new ArrayList<>(list));            
        
    }
}
