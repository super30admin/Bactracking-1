//TC : O(N^(target/minimal value in candidates))
//                  N is the number of candidates
//SC : O(target/minimal value in candidates)
//RUN SUCCESSFULLYON LEETCODE
//NO PROBLEMS

//Went through all the combinations of the solution and added to the list when 
// when ever there is a possible ans and broke the recurrsion when there is a 
// index out of range or target less than 0;

class Solution {
    List<List<Integer>> ans;
    List<Integer> list;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        list = new ArrayList<>();
        helper(candidates, target, 0);
        return ans;
    }

    public void helper(int[] arr, int target, int ind) {
        // base case
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        } else if (target < 0 || ind == arr.length) {
            return;
        }

        // logic
        helper(arr, target, ind + 1);
        list.add(arr[ind]);
        helper(arr, target - arr[ind], ind);
        list.remove(list.size() - 1);
    }
}