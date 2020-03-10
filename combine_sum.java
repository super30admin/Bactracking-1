// Time Complexity : 2^n where n is the number or elements in the array 
// Space Complexity : 2^n 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
// TimeComplexity - 2^n where n is the number or elements in the array
// Space Complexity - 

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length ==0)
            return result;
        
        
        backtracking(candidates, target, 0, 0, new ArrayList<>());
        // recursionSolution(candidates, target, 0, 0, new ArrayList<>());
        
        return result;
        
    }
    

// Approach 1 BAcktracking   
  // Problem -   Get the path which gives the sum value equal to target. This includes duplicate numbers in the array(eg - 2,2,2)
 //  Maintain a global array list(REsultant list) and a local array list(Current Path). Also, maintain current sum to validate against the target.
    // Set index = start of given array and pass along the recurssion
    // Pick same number multiple times(insert in currPath) until the sum reaches target or greater than target.
    // if the sum is equal to target add the local list(currPath) to global list(REsultant list).
    // if sum exceeds the total value remove the last element from the currPath(local list)  proceed from the previous state of recursion.
    
    //Parameters - input candidate array, input targetvalue, calculated current sum at each step, index(which is always the start point), Current Path(Local list maintained with current sum value)
    private void backtracking(int[] candidates, int target, int currSum, int index, List<Integer> currPath){
        
        // Base
        if(currSum == target){
            result.add(new ArrayList<>(currPath));
            return;
        }
            if(currSum > target) return;
        
        //logic
        for(int i = index; i<candidates.length; i++){   // Process from index value till the candidate length. 
            //Action 
            currPath.add(candidates[i]); // Add current candidate in local list(currPath). Keep Adding until the target matches the sum
            //Recurse
            backtracking(candidates, target, currSum + candidates[i], i, currPath ); // Call recursively for all the candidates in the list.
            // Backtrack
            currPath.remove(currPath.size()-1); // At each point when sum equals target or sum is greater than target this point will be reached, remove the last element from the currPath and proceed with next value from index.
        }
    }
     
    
// Approach 2 - Recursion
    // We have two choice to perform - Either choose the candidate or NOT choose the candidate.
    // NOT CHOOSE - Move the index, no changes to currSum and currPath from Prev iteration will be preserved(added) for this step
    // CHOOSE  - calculate new sum, include current value to the currPath and create new ArrayList with currPath.Index value will not be changed as we can process the same number again and again.
    //  Create new local array list at each level and add the candidate to the list
    // If the currSum matches the target add the local list to the resultant list.

    //Normal Recursive Solution
        private void recursionSolution(int[] candidates, int target, int currSum, int index, List<Integer> currPath){
            
            // base
            if(target == currSum){
                result.add(currPath);
                return;
            }
                
            if(currSum > target  || index >= candidates.length)
                return;
            //logic
            
               // Not choose the number 
                recursionSolution(candidates, target, currSum, index+1, new ArrayList<>(currPath)); // This is equivalent to moving the index value to next candidate by preserving all the values asa it is.
            
                // Choose the number
                currPath.add(candidates[index]);  // Add the current candidate to the array List
                recursionSolution(candidates, target, currSum + candidates[index], index, new ArrayList<>(currPath)); // pass the processed value to next iteration.
            
        }
}
