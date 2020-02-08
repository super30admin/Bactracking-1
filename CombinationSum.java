import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) return result;
        backtrack(candidates, target, 0, new ArrayList<>(), 0);
        return result;
    }
    
    private void backtrack(int[] candidates, int target, int sum, List<Integer> temp, int index){
        if(sum == target){
            result.add(new ArrayList<>(temp));
            return;
        }
        if(sum > target) return;
        for(int i = index; i < candidates.length; i++){
            temp.add(candidates[i]);
            backtrack(candidates, target, sum + candidates[i], temp, i);
            temp.remove(temp.size() - 1);
        }
    }
}
