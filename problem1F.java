import java.util.ArrayList;
import java.util.List;

class combinationSum1{
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;

        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int index, List<Integer> path){
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0){
            return;
        }
        
        for(int i = index; i < candidates.length; i++){
            path.add(candidates[i]);
            helper(candidates, target - candidates[i], i, path);
            path.remove(path.size() - 1);
        }
        
    }
}

//time complexity O(2^n)
//space complexity O(recurse(target/min(candidates)))