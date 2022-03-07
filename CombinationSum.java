import java.util.ArrayList;
import java.util.List;

/*
Time Complexity:
Space Complexity:
Run on leetcode: Yes

Approach:
1.
 */
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrackingTree(candidates, target, result, list, 0, 0);
        return result;
    }

    public static void backtrackingTree(int[] candidates,
                                 int target,
                                 List<List<Integer>> result,
                                 List<Integer> list,
                                 int index,
                                 int sum ){
        if(sum>target){
            return;
        }

        if(sum == target){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = index; i<candidates.length; i++){
            list.add(candidates[i]);
            backtrackingTree(candidates, target, result,list, i, sum+candidates[i]);
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args){
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println("Combinational Sum: "+combinationSum(candidates, target));
    }
}
