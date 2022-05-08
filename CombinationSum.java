//Recursive 0,1 approach

class Solution {

    //Time Complexity = 0(2^n) where n is the input string
    //Space Complexity: 0(a) where a is the minimum element in the array
    //Did it successfully run on leetcode: Yes
    //Any problem while doing the problem: No

    //In brief, explain your approach

    List<List<Integer>> result; //creating a list of list of integer to store the result when target is met
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());   //Passing values to the recursive function
        return result;
    }
    public void helper(int [] candidates, int target, int index, List<Integer> path){
        //base
        if(index == candidates.length || target < 0){   //checking if the target goes negative or index goes out of bounds
            return;
        }
        if(target == 0){    //if target tends to get 0, then add the path to my result.
            result.add(path);
            return;
        }
        //logic

        //not choose case or 0 case
        helper(candidates, target, index + 1, new ArrayList<>(path));
        //choose case or 1 case
        path.add(candidates[index]);
        helper(candidates, target - candidates[index], index, new ArrayList<>(path));
    }
}

//Backtracking 0,1 approach
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }
    public void helper(int [] candidates, int target, int index, List<Integer> path){
        //base
        if(index == candidates.length || target < 0){
            return;
        }
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic

        //not choose case or 0 case
        helper(candidates, target, index + 1, path);
        //choose case or 1 case
        //action
        path.add(candidates[index]);
        //recursion
        helper(candidates, target - candidates[index], index, path);
        //backtrack
        path.remove(path.size()-1);
    }
}

//For loop based recursion
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }
    public void helper(int [] candidates, int target, int index, List<Integer> path){
        //base
        if(target == 0){
            result.add(path);
            return;
        }
        if(target < 0){
            return;
        }
        //logic
        for(int i = index; i < candidates.length; i++){
            List<Integer> newList = new ArrayList<>(path);
            newList.add(candidates[i]);
            helper(candidates, target - candidates[i], i, newList);
        }
    }
}

//For loop based recursion with backtracking
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }
    public void helper(int [] candidates, int target, int index, List<Integer> path){
        //base
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0){
            return;
        }
        //logic
        for(int i = index; i < candidates.length; i++){
            path.add(candidates[i]);
            helper(candidates, target - candidates[i], i, path);
            path.remove(path.size()-1);
        }
    }
}
