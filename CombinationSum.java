

// TC : O(2^target/min(candidate))
// SC : O(candidate)


package S30_Codes.Bactracking_1;
import java.util.ArrayList;
import java.util.List;


class CombinationSum {
    List<List<Integer>> result;
    List<Integer> curPath = new ArrayList();
    int target, curSum;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList();
        curPath = new ArrayList();

        findCombination(candidates, 0, target);
        return result;
    }

    private void findCombination(int[] candidates, int idx, int target){
        if(target == 0){
            result.add(new ArrayList(curPath));
            return;
        }

        if(idx == candidates.length || target < 0)
            return;

        // Not Select
        findCombination(candidates, idx+1, target);

        // select
        int originalSize = curPath.size();

        while(target > 0){
            target -= candidates[idx];
            curPath.add(candidates[idx]);
            findCombination(candidates, idx+1, target);
        }

        while(curPath.size() != originalSize){
            curPath.remove(curPath.size()-1);
        }
    }
}