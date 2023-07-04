import java.util.ArrayList;
import java.util.List;

public class CombinationSum01RecursiveBacktracking {

        // 01 RECURSION - BACKTRACKING SOLUTION

        List<List<Integer>> result;
        public List<List<Integer>> combinationSum(int[] candidates, int target) {

            result = new ArrayList<>();

            recursion(candidates, 0, target, new ArrayList<>());

            return result;

        }

        private void recursion(int[] candidates, int i, int target, List<Integer> path) {

            // base
            if(target == 0) {

                //create a new reference or deep copy of old referenced path while adding to result
                result.add(new ArrayList<>(path));
                return;
            }

            if(target < 0 || i == candidates.length) return;

            // no choose
            recursion(candidates, i+1, target, path);

            // choose
            //action
            path.add(candidates[i]);

            // recurse
            recursion(candidates, i, target - candidates[i], path);

            // backtrack
            // remove the element added by last (n-2) recursive call before closing the current (n-1)recursive function and returning path to the previous (n) recursive call as it is before it is called
            // at the end path becomes empty, as how it was during the first recursive call as backtracking takes us back there
            path.remove(path.size() - 1);


        }

}

/*

Time Complexity = O(2^m+n)

m = given target
n = number of elements in candidate

Space Complexity =

 */