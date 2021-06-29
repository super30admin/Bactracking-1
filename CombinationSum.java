import java.util.ArrayList;
import java.util.List;


/*
TC : O(N^(T/M)) where T is the target and M is the minimum number in the candidates and N is length of candidates array
SC : O(T/M) as that is the maximum depth of the tree, therefore recursion stack would consume maximum that much depth.
LeetCode : yes
Problem : no
 */


public class CombinationSum {

    public List<List<Integer>> result = new ArrayList();
    public int[] nums;
    public int targetSum;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        nums = candidates;
        targetSum = target;
        List<Integer> list = new ArrayList();
        helper_using_backtracking(targetSum, 0, list);
        return result;

    }


    public void helper_using_backtracking(int remainingSum, int start, List<Integer> list) {


        if (remainingSum < 0)
            return;
        else if (remainingSum == 0)
            result.add(new ArrayList<Integer>(list));
        else {
            for (int i = start; i < nums.length; i++) {
                list.add(nums[i]);
                helper_using_backtracking(remainingSum - nums[i], i, list);
                list.remove(list.size() - 1);
            }

        }

    }

    public void helper_using_recursion(int remainingSum, int start, List<Integer> list) {


        if (remainingSum < 0)
            return;
        else if (remainingSum == 0)
            result.add(new ArrayList<Integer>(list));
        else {
            for (int i = start; i < nums.length; i++) {
                List<Integer> deepCopy = new ArrayList(list);
                deepCopy.add(nums[i]);
                helper_using_recursion(remainingSum - nums[i], i, deepCopy);

            }

        }

    }
}
