import java.util.ArrayList;
import java.util.List;
//T.C :exponential
//S.C : not sure
// Passed all Test cases on Leetcode : Yes
// Any issues faced while executing the code : No
public class Problem1 {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        recurse(candidates, target, 0, new ArrayList<>());
        return res;
    }
    private void recurse(int[] candidates, int target, int ind, List<Integer> path){


        // base case || stopping condition
        if(ind == candidates.length || target < 0) {
            return;
        }
        // answ base case
        if(target == 0){
            res.add(path);
            return;
        }

        // do not pick case
        recurse(candidates, target, ind+1, new ArrayList<>(path));
        path.add(candidates[ind]);
        //pick case
        recurse(candidates, target- candidates[ind],ind, new ArrayList<>(path));

    }
}
