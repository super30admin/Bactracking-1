/*
Time complexity: O(2^mn)
Space complexity: O(mn)
*/
import java.util.*;
class Solution {
    void helper(int[] array,int sum,int start, List<Integer> path, List<List<Integer>> res){
        //base condition
        if(sum<0){
            return ;
        }
        if(sum==0){
            res.add(new ArrayList<>(path));
            return;
        }
        
        //branching condition.
        for(int i=start;i<array.length;i++){
            path.add(array[i]);
            helper(array,sum-array[i],i,path,res);
             path.remove(path.size()-1);       
        }
       
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res=new ArrayList<List<Integer>>();
    List<Integer> path=new ArrayList<Integer>();
    helper(candidates,target,0,path,res);
    return res;
    }
}