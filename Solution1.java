// Time Complexity : O(2^n) at every recursive step we have two decisions , and recursion continues till n , n being the length of the array
// Space Complexity :O(n) maximum calls in the recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No 


// Your code here along with comments explaining your approach
import java.util.ArrayList;
import java.util.List;

class Solution {
    //Recursive solution-0-1 case
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result= new ArrayList<>();
        if(candidates==null || candidates.length==0)
            return result;
        
        helper(candidates,target,0, new ArrayList<>());
        
        return result;
    }
    
    private void helper(int [] candidates, int target, int index, List<Integer> path){
        
        // base
        if(index==candidates.length || target<0){
            return;
        }
        if(target==0){
            result.add(path);
            return;
        }
        //logic
        //case0
        helper(candidates,target,index+1,path);
        
        //case1
        List<Integer> newList= new ArrayList<>(path);
        newList.add(candidates[index]);
        helper(candidates,target-candidates[index],index,newList);
    }

    //Backtracking solution-Recursive Iterative approach
    List<List<Integer>> result1;
    public List<List<Integer>> combinationSum1(1int[] candidates, int target) {
        result1= new ArrayList<>();
        if(candidates==null || candidates.length==0)
            return result1;
        
        helper(candidates,target,0, new ArrayList<>());
        
        return result;
    }
    
    private void helper1(int [] candidates, int target, int index, List<Integer> path){
        
        // base
        if(target<0){
            return;
        }
        if(target==0){
            result1.add(new ArrayList<>(path));
            return;
        }
        // need not check if index is out of bound because its checked by the for loop
        //logic
        for(int i=index;i<candidates.length;i++){
            path.add(candidates[i]);
            helper(candidates,target-candidates[i],i,path);
            path.remove(path.size()-1);
        }        
    }
}