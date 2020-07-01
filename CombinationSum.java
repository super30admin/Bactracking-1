// Time Complexity : O(n*2^n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes 			
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


//backtrack


class Solution {
    List<List<Integer>> result;
    int targ;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        result = new ArrayList<>();
        targ = target;
        
        backtrack(candidates,new ArrayList<>(),0,0);
        return result;
    }
    
    private void backtrack(int[] candidates , List<Integer> temp , int sum,  int index)     {
        
      //base
        if(sum == targ){
            result.add( new ArrayList<>(temp));
            System.out.println(" here ");
        }
        if( sum > targ)
            return;
        
      //logic
        
        for(int i = index ; i < candidates.length ;i++){
         
            temp.add(candidates[i]);
            backtrack(candidates , temp , sum + candidates[i],i);
            temp.remove(temp.size()-1);
        }
        
    }
}

// Time Complexity : O(n*2^n)
// Space Complexity :O(n*2*n)
// Did this code successfully run on Leetcode : yes 			
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

lass Solution {
    List<List<Integer>> result;
    int targ;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        result = new ArrayList<>();
        targ = target;
        backtrack(candidates,new ArrayList<>(),0,0);
        return result;
    }
    
    private void backtrack(int[] candidates , List<Integer> temp , int sum,  int index)     {
        
      //base
        if(sum == targ){
            result.add(temp);
            return;
        }
        if( sum > targ || index >= candidates.length)
            return;
      //logic
        //choose
        backtrack(candidates, new ArrayList<>(temp) , sum , index+1);
        temp.add(candidates[index]);
        backtrack(candidates , new ArrayList<>(temp) , sum + candidates[index],index);
      
        
                

        
    }
}


