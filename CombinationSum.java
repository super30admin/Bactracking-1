// O(n^(t/m +1)) time: n candidates and max depth of tree is (t/m), where t is target and m is min value of candidates
    // so max number of nodes is N ^ (t/m + 1)
// O(t/m) space, for recursive stack, where we keep adding smallest element to the combination

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        LinkedList<Integer> comb = new LinkedList<Integer>();
        this.backtrack(target, comb, 0, candidates, results);
        return results;
    }
    
    public void backtrack(int remain, LinkedList<Integer> comb, int start, int[] candidates, List<List<Integer>> results){
        if (remain == 0){ // reached target sum
            results.add(new ArrayList<Integer>(comb));
            return;
        }
        else if (remain < 0) return; // exceeded scope, stop exploration
        
        for (int i = start; i < candidates.length; i++){
            comb.add(candidates[i]); // add to combination
            this.backtrack(remain - candidates[i], comb, i, candidates, results);
            // backtrack
            comb.removeLast();
        }
    }
}
