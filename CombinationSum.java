import java.util.ArrayList;
import java.util.List;

//TC will be O(2n), where n is number of integers in candidates array.
//SC will be O(2n), where n is number of integers in candidates array.

class CombinationSum {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0 ){
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        recurse(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void recurse(int[] candidates,int target, int index, List<Integer> path){
        //base case
        if(index== candidates.length || target < 0 ){
            return;
        }
        if(target == 0){
            result.add(path);
            return;
        }
        //main logic
        // Case not choose or 0 case
        recurse(candidates, target, index + 1, new ArrayList<>(path));
        path.add(candidates[index]);
        //Case choose or 1 case
        recurse(candidates, target- candidates[index], index, new ArrayList<>(path));
    }

    public static void main(String[] args){
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        CombinationSum obj = new CombinationSum();
        List<List<Integer>> combinations = obj.combinationSum(candidates, target);
        System.out.println(combinations);

    }

}