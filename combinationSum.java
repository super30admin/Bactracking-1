
/*
Time Complexity :   O(n (T/M)/1)  here n is number of candidates, t is target and m is minimum number from the candidates.
Space Complexity :  O(T/M)  t is target and m is minimum number from the candidates.

*/
import java.util.*;

class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        helper(candidates, target, 0, new ArrayList());

        return result;
    }

    public void helper(int[] candidates, int target, int index, List<Integer> list) {

        // base case
        if (target < 0) {

            return;
        }
        // logic
        if (target == 0) {
            result.add(new ArrayList<>(list));
        }
        // doing recursive call with taking pivot.
        for (int i = index; i < candidates.length; i++) {

            // adding in the list.

            list.add(candidates[i]);
            helper(candidates, target - candidates[i], i, list);

            // backtracking
            list.remove(list.size() - 1);
        }

    }
}