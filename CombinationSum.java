import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    // Backtracking with for loop
    // TC: It will be exponential
    // SC: O(target / minimum number in the candidates array)
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length==0) return result;

        helper(candidates,target, 0, new ArrayList<>());

        return result;
    }

    private void helper(int[] candidates, int target, int index, ArrayList<Integer> path) {
        //base - found the combination
        // Since we're using backtracking and removing the last added element from path
        // get the snapshot of the current state of the path variable
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        if(target < 0) return;

        for(int i=index; i < candidates.length; i++) {
            //action
            path.add(candidates[i]);
            //recurse
            helper(candidates, target - candidates[i], i, path);

            //backtrack
            path.remove(path.size() - 1);
        }
    }
}
