import java.util.ArrayList;
import java.util.List;
//Time and Space complexity unsure : need help here
public class CombinationSum {
    List<Integer> current;
    List<List<Integer>> combinations;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        current = new ArrayList<>();
        combinations =  new ArrayList<>();
        backtrack(candidates, 0, 0, target);

        return combinations;
    }
    private void backtrack(int[] candidates, int idx, int sum, int target){
        //base

        if(sum == target){
            combinations.add(new ArrayList<>(current));
            return;
        }
        if(sum > target){
            return;
        }

        //logic

        for(int i = idx; i < candidates.length; i++){
            current.add(candidates[i]);
            backtrack(candidates, i, sum+ candidates[i], target);
            //backtrack
            current.remove(current.size() - 1);
        }
    }
}
