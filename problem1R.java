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
        if(index == candidates.length || target < 0){
            return;
        }
        
        helper(candidates, target, index + 1, path);
        path.add(candidates[index]);
        helper(candidates, target - candidates[index], index, path);
        path.remove(path.size() - 1);
    }
}

//time complexity O(2^n) exponential because of recursive function 
//space complexity O(recurse(target/min(candidates))) we are choosing elements from array until we found the target 
// so will add into recursive stack, so if we just choose min element that will have worst of recursive stack. 