import java.util.ArrayList;
import java.util.List;
//Time Complexity: O(2^n)
// Space Complexity: O(1)
public class CombinationSum {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null) return result;
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    public void helper(int[] candidates, int target, int index,List<Integer> path){
        // base
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target <0  ) return;
        // Logic
        for(int i = index; i < candidates.length; i++){
            path.add(candidates[i]);
            helper(candidates, target - candidates[i], i, path);
            path.remove(path.size() - 1);
        }
    }
}
