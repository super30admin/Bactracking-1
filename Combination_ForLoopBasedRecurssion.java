//using for loop recurssion
//take a pivot [2(pivot),3,6,7] and check all posibilities(for loop on 3,6,7) for it. Add the path in result wherever amount becomes zero
//once this path is explored, change pivot to next number
//TC: 2^mn/2 = 2^(mn-1)
//SC: 2^mn

class Solution {
     List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        //null
        if(candidates == null || candidates.length == 0) return result;
        helper(candidates, 0, target, path);
        return result;
    }

    public void helper(int[] candidates, int pivot, int amount, List<Integer> path){
        //base
        if(amount == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(amount < 0) return;

        //logic
        for(int i = pivot; i< candidates.length; i++){
            //action
            path.add(candidates[i]);
            //recurse
            helper(candidates, i, amount - candidates[i], path);

            //backtrack
            path.remove(path.size() - 1);
        }

    }
}
