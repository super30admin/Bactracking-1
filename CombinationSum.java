//Time Complexity: O(2^mn)
//Space Complexity: O(2^mn)

/*
 * In this approach we can do it with a for loop in recursion. The base case is when the target is 0 we add the path in the result. And if the target is negative or the index
 * is out of the array length then we return. We then run a for loop from pivot to end of array length. We create a deep copy of path to avoid using same reference.
 * We add the current element in the path and we recurse on all the children.
*/

//for loop based recursion
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        helper(candidates, 0, new ArrayList<>(), target);
        return result;
    }
    private void helper(int[] candidates, int pivot, List<Integer> path, int target){
        //base
        if(target == 0){
            // result.add(path);
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0 || pivot == candidates.length)return;
        //logic
        for(int i = pivot;i<candidates.length;i++){
            List<Integer> li= new ArrayList<>(path);
            li.add(candidates[i]);
            helper(candidates,i, li,target-candidates[i]);
        }
    }
}
//normal recursion

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        helper(candidates, 0, new ArrayList<>(), target);
        return result;
    }
    private void helper(int[] candidates, int index, List<Integer> path, int target){
        //base
        if(target == 0){
            // result.add(path);
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0 || index == candidates.length)return;
        //logic
        //not choose
        helper(candidates, index+1, path,target);
        //choose

        // List<Integer> li = new ArrayList<>(path);
        // li.add(candidates[index]);
        path.add(candidates[index]);
        helper(candidates, index, path, target - candidates[index]);
        path.remove(path.size()-1);
    
    }
}