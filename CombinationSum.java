//leetcode tested

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null){
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        findCombination(candidates, 0, target, new ArrayList<>(),result);

        return result;
    }

    public void findCombination(int[] candidates,int index,int target,List<Integer> current,List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if(candidates[i] <= target){
                current.add(candidates[i]);
                findCombination(candidates,i,target-candidates[i],current,result);
                current.remove(Integer.valueOf(candidates[i]));
            }
        }
    }
}
