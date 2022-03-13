// Time Complexity:        O(2^(target/minimumNumber))
// Space Complexity:       O(n)
// where n is length of given array
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;
        SolutionCombinationSum obj = new SolutionCombinationSum();
        List<List<Integer>> list = obj.combinationSum(candidates, target);
        System.out.println(list);
    }
}

class SolutionCombinationSum {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        combinationSum(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void combinationSum(int[] candidates, int target, int index, List<Integer> path) {
        // BASE
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        if(index == candidates.length || target < 0) {
            return;
        }

        // not choose
        combinationSum(candidates, target, index+1, path);

        int size = path.size();

        while(target > 0) {
            target -= candidates[index];                        // updating target
            path.add(candidates[index]);                        // adding values to "path"
            combinationSum(candidates, target, index+1, path);  // recursive call
        }

        // BACTRACKING
        while(path.size() != size) {
            path.remove(path.size()-1);
        }

    }
}




//// ****************************** Another Approach ******************************
//// Time Complexity: O(2^(target/minimumNumber))
//// space Complexity: O(target/minimumNumber)
//
//class SolutionCombinationSum {
//    List<List<Integer>> result;
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        result = new ArrayList<>();
//        combinationSum(candidates, target, 0, new ArrayList<>());
//        return result;
//    }
//
//    private void combinationSum(int[] candidates, int target, int index, List<Integer> path) {
//        // BASE
//        if(index == candidates.length || target < 0) {
//            return;
//        }
//
//        if(target == 0) {
//            result.add(new ArrayList<>(path));
//            return;
//        }
//
//        // ACTION
//        path.add(candidates[index]);
//
//        // RECURSION
//        combinationSum(candidates, target-candidates[index], index, path);
//
//        // BACTRACK
//        path.remove(path.size()-1);
//
//        // not choose
//        combinationSum(candidates, target, index+1, path);
//    }
//}








//// ****************************** Another Approach ******************************
//// Time Complexity: O(2^(target/minimumNumber))
//// space Complexity: O(target/minimumNumber)
//
//class SolutionCombinationSum {
//    List<List<Integer>> result;
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        result = new ArrayList<>();
//        combinationSum(candidates, target, 0, new ArrayList<>());
//        return result;
//    }
//
//    private void combinationSum(int[] candidates, int target, int index, List<Integer> path) {
//        // BASE
//        if(target == 0) {
//            result.add(new ArrayList<>(path));
//            return;
//        }
//
//        if(index == candidates.length || target < 0) {
//            return;
//        }
//
//        for(int i = index; i<candidates.length; i++) {
//
//            // ACTION
//            path.add(candidates[i]);
//
//            // RECURSION
//            combinationSum(candidates, target-candidates[i], i, path);
//
//            // BACTRACKING and NOT CHOOSE
//            path.remove(path.size()-1);
//        }
//
//    }
//}