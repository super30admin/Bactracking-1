// Time Complexity : O(2^N) Exponential 
// Space Complexity : O(N) N is the length of the String.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.List;

class CombinationSum {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //edge cases
        if(candidates == null || candidates.length==0) return result;

        //logic 
        helper(candidates, new ArrayList<>(), target, 0, 0);
        return result;
    }

    private void helper(int[] candidates, ArrayList<Integer> temp, int target, int index, int sum){
        if(index>=candidates.length || sum>target){
            return;
        }

        if(sum==target){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index; i<candidates.length; i++) {
            //case 1: choosing candidates[i]
            temp.add(candidates[i]);
            helper(candidates, new ArrayList<>(temp), target, i, sum + candidates[i]);

            //case 2: not choosing candidates[i]
            temp.remove(temp.size()-1);
        }

    }

    public static void main(String... args){
        int[] candidates = {2,3,6,7};
        List<List<Integer>> result = new CombinationSum().combinationSum(candidates, 7);
        for(List<Integer> list: result){
            System.out.println("[");
            for(int i: list){
                System.out.print(i + ",");
            }
            System.out.print("]");
        }
    }
}
