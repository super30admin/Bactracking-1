// Time Complexity : O(n*n^n) (for loop+exploring nodes at each node)
// Space Complexity : O(n) where n is maximum height of tree is the target/least number(number of times least number is used)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

/*
approach1 
three things to rememeber for backtracking return type void ... add to path, recursively do the path and then remove from path(pooping out from stack).. for loop from the current postion to the end

so here we use backtracking since we have to get all possible combinationSum
we return as soon as we have crossed the target or write pathsofar when we reach target
or if we still didnt reach target then we do helper for the rest of the array and look for target-candidate[j]
remeber to remove it from path as well

*/

class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        // TC O()
        // SC O()
        // maximum height of tree is the target/least number(number of times least
        // number is used)

        helper(candidates, target, 0, new ArrayList<>());
        return res;

    }

    // here we have no return type becuase this will stop the processing of the
    // remaining nodes if the correct answer has been found out.
    private void helper(int[] candidates, int target, int idx, List<Integer> pathSoFar) {

        if (target < 0)
            return;
        else if (target == 0) {
            res.add(new ArrayList<>(pathSoFar));
            return;
        }

        for (int j = idx; j < candidates.length; j++) {

            // add the current element to the path
            pathSoFar.add(candidates[j]);

            // process this iteration and call the helper on the next elements
            helper(candidates, target - candidates[j], j, pathSoFar);

            // remove that element from the path
            pathSoFar.remove(pathSoFar.size() - 1);
        }

    }
}

/////////////////////////////////////////////// approach 2 dp
public class Solution {

    public List<List<Integer>> combinationSum(int[] cands, int t) {

        Arrays.sort(cands); // sort candidates to try them in asc order

        List<List<List<Integer>>> dp = new ArrayList<>();

        for (int i = 1; i <= t; i++) { // run through all targets from 1 to t

            List<List<Integer>> newList = new ArrayList(); // combs for curr i

            // run through all candidates <= i

            for (int j = 0; j < cands.length && cands[j] <= i; j++) {

                // special case when curr target is equal to curr candidate

                if (i == cands[j])
                    newList.add(Arrays.asList(cands[j]));

                // if current candidate is less than the target use prev results

                else
                    for (List<Integer> l : dp.get(i - cands[j] - 1)) {

                        if (cands[j] <= l.get(0)) {

                            List cl = new ArrayList<>();

                            cl.add(cands[j]);
                            cl.addAll(l);

                            newList.add(cl);

                        }

                    }

            }

            dp.add(newList);

        }

        return dp.get(t - 1);

    }

}