
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :
// 	Simple but still not intuitive

// Your code here along with comments explaining your approach
class Solution {
     List<List<Integer>> resultList = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {


        helper(candidates, target, 0, 0, new ArrayList<>());

        return resultList;

    }

    private void helper(int[] candidates, int target, int index, int sum, List<Integer> list) {

        if (sum > target) return;

        if (sum == target) {

            resultList.add(new ArrayList(list));
        }

        for (int i = index; i < candidates.length; i++) {
            
            list.add(candidates[i]);
            helper(candidates, target, i , sum + candidates[i], list);
            list.remove(list.size() - 1);

        }
    }
}