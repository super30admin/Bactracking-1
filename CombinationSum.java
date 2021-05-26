import java.util.*;

public class CombinationSum {

    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList();
        if(nums == null || nums.length == 0) return result;
        backtrack(nums, target, new ArrayList(), 0);
        return result;
    }

    private void backtrack(int[] candidates, int target, List<Integer> path, int index){
        //Base conditions
        //If we combination is zero - then it is valid combination. so exit
        if(target == 0) {
            result.add(new ArrayList(path));
            return;
        }

        //If we combination becomes less than 0 - then it is in valid combination. so the current execution.
        if(target < 0 || index == candidates.length) {
            return;
        }
        //Logic
        //Don't choose
        backtrack(candidates, target, path, index+1);
        path.add(candidates[index]);
        backtrack(candidates, target-candidates[index], path, index);
        path.remove(path.size()-1);
    }

    private void backtrackRecurseive(int[] candidates, int target, List<Integer> path, int index){
        //base

        if(target == 0){
            result.add(new ArrayList<>(path));
            return;

        }
        if(target < 0){
            return;
        }   

        for(int i=index; i<candidates.length;i++){
            //aciton
            path.add(candidates[i]);
            backtrackRecurseive(candidates, target - candidates[i], path, i);
            //backtrack
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {

        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> result = combinationSum.combinationSum(new int[]{1,2,4,5}, 6);
        System.out.println("The result is"+result.toString());
    }
}