import java.util.ArrayList;
import java.util.List;
/*
Combination Sum
approach: dfs with backtracking
time: O(2^n*m)
space: O(2^n*m)
 */
public class Problem1 {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        dfs(candidates, target, new ArrayList<>(), 0);
        return result;
    }


    private void dfs1(int[] candidates, int amount, List<Integer> path, int index) {
        //base
        if(index==candidates.length || amount<0) return;
        if(amount==0) {
            result.add(new ArrayList(path));
            return;
        }


        //logic
        //case 0
        dfs(candidates, amount, path, index+1);

        //case 1
        path.add(candidates[index]);
        dfs(candidates, amount-candidates[index], path, index);
        path.remove(path.size()-1);
    }

    private void dfs(int[] candidates, int amount, List<Integer> path, int pivot) {
        if(pivot==candidates.length || amount<0) return;
        if(amount==0) {
            result.add(new ArrayList(path));
            return;
        }

        for(int i=pivot;i<candidates.length;i++) {
            path.add(candidates[i]);
            dfs(candidates, amount-candidates[i], path, i);
            path.remove(path.size()-1);
        }
    }
}
