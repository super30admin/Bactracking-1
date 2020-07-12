// Time Complexity : O(2^n) n is the length of the candidate array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


//Solution : Backtracking
class Solution {
    //declare the result list of list
    List<List<Integer>> result;
    //declare tar globally and initialize in the below func
    int tar;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //initialize the result
        result = new ArrayList<>(); 
        //initialize tar
        tar = target;
        //check for null and 0 condition
        if(candidates == null || candidates.length == 0) return result;
        //call backtrack method (with parameters) 
        //: candidates array, sum = 0, new temp list, index position (0 at start))
        backtrackhelper(candidates, 0, new ArrayList<>(), 0); 
        //return the result list after completion of backtrack(recursion) function
        return result;
        
    }
    
    private void backtrackhelper(int[] candidates, int sum, List<Integer> temp, int index) {
        //if sum is = target, then add that copy(new copy, else temp will be empty in the end) of temp to result
        if(sum == tar) {
            result.add(new ArrayList<>(temp));
            //return after adding to result
            return;
        }
        
        //if sum > target, return 
        if(sum > tar) return; 
        
        //logic  
        //iterate the array starting from index position
        for(int i = index; i < candidates.length; i++){
            //add the ith position value to the temp list
            temp.add(candidates[i]);
            //recursion
            //call backtrackhelper method again, with updated parameters
            //(candidates array, sum is sum+candidates[i] as we added the element to the array
            //temp is the temp array no need of new list, as we add a copy of the temp list to the result
            //and index position is i (as we can add same elements)
            backtrackhelper(candidates, sum + candidates[i], temp, i);
            //backtrack (remove last element added)
            temp.remove(temp.size()-1);
        }   
    }
}


/////////////////////////


//Solution : Recursion
//First : dont choose number, then choose number
class Solution {
    //declare the result list of list
    List<List<Integer>> result;
    //declare tar globally and initialize in the below func
    int tar;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //initialize the result
        result = new ArrayList<>(); 
        //initialize tar
        tar = target;
        //check for null and 0 condition
        if(candidates == null || candidates.length == 0) return result;
         //call helper method (with parameters) 
        //candidates array, sum = 0, new temp list, index 0 at start
        helper(candidates, 0, new ArrayList<>(), 0); 
        //return the result list after completion of recursion function
        return result;
        
    }
    
    private void helper(int[] candidates, int sum, List<Integer> temp, int index) {
        //base condition
        //check is sum == tar, if equal add the temp list to result
        //not a copy as we send a new temp copy at each recursion call, so temp will not be changed
        if(sum == tar) {
            //add temp to result and return
            result.add(temp);
            return;
        }
        //if sum > tar or index out of bounds return the recursive call
        if(sum > tar || index == candidates.length) {
            return;
        }
             
        //logic
        
        //dont choose candidate number
        
        //candidate not chosen, so sum remains same and index inc by 1
        helper(candidates, sum, new ArrayList<>(temp), index+1);
        
        
        //choose candidate number
        
        //add the candidate at index position to temp
        temp.add(candidates[index]);
        //sum incs by candidates[index], send copy of temp list 
        //index position remains same as multiple candidates can be picked 
        helper(candidates, sum+candidates[index], new ArrayList<>(temp), index);     
        
    }
}


//////////////////


//Solution : Recursion
//First : choose number, then dont choose number
class Solution {
    //declare the result list of list
    List<List<Integer>> result;
    //declare tar globally and initialize in the below func
    int tar;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //initialize the result
        result = new ArrayList<>(); 
        //initialize tar
        tar = target;
        //check for null and 0 condition
        if(candidates == null || candidates.length == 0) return result;
         //call helper method (with parameters) 
        //candidates array, sum = 0, new temp list, index 0 at start
        helper(candidates, 0, new ArrayList<>(), 0); 
        //return the result list after completion of recursion function
        return result;
        
    }
    
    private void helper(int[] candidates, int sum, List<Integer> temp, int index) {
        //base condition
        //check is sum == tar, if equal add the temp list to result
        //not a copy as we send a new temp copy at each recursion call, so temp will not be changed
        if(sum == tar) {
            //add temp to result and return
            result.add(temp);
            return;
        }
        //if sum > tar or index out of bounds return the recursive call
        if(sum > tar || index == candidates.length) {
            return;
        }
             
        //logic
        
        //choose candidate number
        
        //create a new list (for dont choose we dont want temp to have the chosen numbers)
        //in the newlist add temp elements
        //then add the current element (candidates[index])
        List<Integer> newList = new ArrayList<>(temp); 
        newList.add(candidates[index]);
        //in parameters send the newList as temp (to check in base condition)
        //sum incs by candidates[index] 
        //index position remains same as multiple candidates can be picked 
        helper(candidates, sum+candidates[index], newList, index); 
        
        
        //dont choose candidate number
        
        //candidate not chosen, so sum remains same and index inc by 1
        helper(candidates, sum, new ArrayList<>(temp), index+1);  
        
    }
}


