//Problem 68: Combination Sum
//Time Complexity: O(n), n stands for input array length
//Space Complexity : O(n), because I'm using a current path list for storing current elements on each recursive call; 

/*Steps

   1) Bruteforce:   //TC:O(N) | SC:O(N^2), because each time I'm copying existing current path to two new list
      Basically I have to choose the element or not. On each recursive call, I copied my current path list to two new list called op1  & op2. Then if I'm chosing the element then I added it into op1 and passed it with the recursive call.In addition, I subtracted its value from the target sum and passed the same index. Otherwise, if I'm not chosing the current element I simply passed my op2 and current target, along with index+1.

      If targetSum ==0 then I just added the current path in my final result, otherwise if target<0 or  index>input array.length, then I just returned.
      
      Once function returns, I did backtracking and removed last index from the current path list.

    2) Optimal : //TC:O(N) | SC:O(N);
       Similar to above, just use 'for loop' for iterating from start to end of the input array and making the recursive call. It helps in optimizing space complexity. Now no need to copy current path to new list on each recursive call. Only copy the current path into result list when target==0; 

*/

import java.util.*;

class Solution68 {
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        res = new ArrayList<>();
        
        //egde
        if(candidates==null || candidates.length==0) return res;
        
        //TC:O(N) | SC:O(N);
        helper(candidates,target,new ArrayList<>(), 0,candidates.length);
        
        //Bruteforce
        //TC:O(N) | SC:O(N^2);-> Using Input Output Method
        //helper(candidates,target,new ArrayList<>(), 0);
        
        return res;
        
    }

    //TC:O(N) | SC:O(N);
    private void helper(int[] candidates, int target,List<Integer> currPath,int start, int end){
        
        if(start>=end || target<0 ) return;
        
        if(target==0){
            res.add(new ArrayList<>(currPath));
            return;
        }
        
        for(int i=start;i<end;i++){
            currPath.add(candidates[i]);
            helper(candidates,target-candidates[i],currPath,i,end);
            currPath.remove(currPath.size()-1);
        }
        
    }
    
    //TC:O(N) | SC:O(N^2), because each time I'm copying existing current path to two new list
    /*private void helper(int[] candidates, int target,List<Integer> currPath,int idx){
        
        //base
        if(idx>=candidates.length) return;
        
        if(target<0) return;
        
        if(target==0){
            res.add(new ArrayList<>(currPath));
            return;
        }
        
        List<Integer> op1 = new ArrayList<>(currPath);
        List<Integer> op2 = new ArrayList<>(currPath);
        
        op1.add(candidates[idx]);
        
        //choose
        helper(candidates,target-candidates[idx],op1,idx);
        //not choose
        helper(candidates,target,op2,idx+1);
        
        if(op1.size()>0) op1.remove(op1.size()-1);
        if(op2.size()>0) op2.remove(op2.size()-1);
        
    }*/
    
}