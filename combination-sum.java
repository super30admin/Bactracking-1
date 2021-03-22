// Time Complexity :
O(2^n * k) where where k is the length of the each combination generated

// Space Complexity :
0(k * x) where where k is the length of the each combination generated and x is number of combinations

// Did this code successfully run on Leetcode :
YES
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach




class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    //define the final result
    List<List<Integer>> result = new ArrayList<>();
    //define an intermediate list to store the elements that are trying to form the sum
    List<Integer> ds= new ArrayList<>();
    //call the helper function with ind = 0
    helper(candidates, target, 0, result,ds);
    return result;
    }
    
    private void helper(int[] candidates, int target, int ind, List<List<Integer>> result, List<Integer> ds){
        //Base case to add the correct combination
        
    if(ind == candidates.length){
    //if the target becomes 0 which means we found a valid combination
        if(target == 0){
            result.add(new ArrayList<>(ds));
        } 
    //if the target is not 0, then the combination is not found
        return;
        
        }
        
      //If we choose an element
            if(candidates[ind] <= target){
                ds.add(candidates[ind]);
                //call the recursive function
                helper(candidates, target-candidates[ind], ind, result,ds);
                /*now reset the ds by removing the element while coming back after recursion*/
                ds.remove(ds.size() - 1);
            }
        //If we don't choose the element
        helper(candidates, target,ind + 1 , result,ds);
        }
    }
