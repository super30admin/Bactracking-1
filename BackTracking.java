import java.util.ArrayList;
import java.util.List;

public class BackTracking {
    public static void main(String[] args) {

        int[] arr = { 2, 3, 6, 7 };
        int target = 7;
        BackTracking obj = new BackTracking();
        List<List<Integer>> obj1 = obj.combinationSum(arr, target);
        System.out.println(obj1);

    }

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int pivot, List<Integer> path) {

        // base

        if (target < 0)
            return;
        if (target == 0) {
            result.add(new ArrayList<>(path));
            System.out.println(path);
            return;
        }

        // Backtracking
        // logic
        // not choose
        //helper(candidates, target, i + 1, path);
        // action

        // recurse
        // choose
        for ( int i = pivot ; i < candidates.length ; i ++){
            path.add(candidates[i]);
            helper(candidates, target - candidates[i], i , path);
    
    
            // backTrack
            path.remove(path.size()-1);

    }

}
}