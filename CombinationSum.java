// Time Complexity: O(2^n) for both cases
// Space Complexity: O(n x 2^n) for recursion and O(n) for Backtracking

// Backtracking
// We update the same list we call backtracking each time and whenever we have to append the result,
// we create a copy of the list and add.
class Solution {
    List<List<Integer>> res;
    int targ;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        targ = target;
        if(candidates == null || candidates.length == 0) return res;
        backtrack(candidates, new ArrayList<>(), 0, 0);
        return res;
    }
    
    private void backtrack(int[] candidates, List<Integer> temp, int sum, int index) {
        //base
        if(sum >  targ) return;
        if(sum == targ) {
            res.add(new ArrayList<>(temp));
            return;
        }
        //logic
        for(int i=index;i<candidates.length;i++) {
            //action
            temp.add(candidates[i]);
            //recurse
            backtrack(candidates,temp,sum+candidates[i],i);
            //backtrack
            temp.remove(temp.size()-1);
        }
    }
}

// Recursion

// We create a new list each time we call recursion, once choosing the element and once not choosing
// the element.
class Solution {
    List<List<Integer>> res;
    int targ;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        targ = target;
        if(candidates == null || candidates.length == 0) return res;
        helper(candidates, new ArrayList<>(), 0, 0);
        return res;
    }
    
    private void helper(int[] candidates, List<Integer> temp, int sum, int index) {
        //base
        if(sum >  targ || index == candidates.length) return;
        if(sum == targ) {
            res.add(temp);
            return;
        }
        //logic
        // dont choose
        helper(candidates,new ArrayList<>(temp),sum, index+1);
        //choose
        temp.add(candidates[index]);
        helper(candidates,new ArrayList<>(temp),sum+candidates[index], index);
    }
}