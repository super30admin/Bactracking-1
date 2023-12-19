import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    //for loop based recursion
    List<List<Integer>> result2;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result2 = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }
    private void helper2(int[] candidates, int target, int pivot, List<Integer> path){
        //base
        if(target < 0 || pivot == candidates.length){
            return;
        }
        if(target == 0){
            result2.add(new ArrayList<>(path));
        }
        //logic
        for(int i = pivot; i < candidates.length; i++){ // if we want permutation then i = 0
            //action
            path.add(candidates[i]);
            //recurse
            helper(candidates, target - candidates[i], i, path);
            path.remove(path.size() - 1);

        }
    }

//    Creating Deep copy and no backtracking
List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>());
        return result;

    }
    private void helper(int[] candidates, int i, int target, List<Integer> path){
        //base
        if(target < 0 || i == candidates.length){
            return;
        }
        if(target == 0){
            result.add(path);
            return;
        }

        //logic
        //dont choose
        helper(candidates, i+1, target, new ArrayList<>(path));

        //choose
        path.add(candidates[i]);
        helper(candidates, i, target-candidates[i], new ArrayList<>(path));
    }

//    Backtrack and create deep copy when target found
    List<List<Integer>> result1;
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        result = new ArrayList<>();
        helper1(candidates, 0, target, new ArrayList<>());
        return result;

    }
    private void helper1(int[] candidates, int i, int target, List<Integer> path){
        //base
        if(target < 0 || i == candidates.length){
            return;
        }
        if(target == 0){
            result1.add( new ArrayList<>(path));
            return;
        }

        //logic
        //dont choose
        helper1(candidates, i+1, target, path);

        //choose
        //action
        path.add(candidates[i]);
        //recurse
        helper1(candidates, i, target-candidates[i], path);
        //backtrack
        path.remove(path.size()-1);


    }
}
