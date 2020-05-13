// Time Complexity : m * 2^n  m= target, n number of elements in array.
// Space Complexity :  maxDepth of recursive stack.
// Did this code successfully run on Leetcode :yes. 

// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//the code uses recursion plus backtrack. The follow the pattern action, recursion and backtrack. 
//Success
//Details 
//Runtime: Runtime: 3 ms, faster than 73.66% of Java online submissions for Combination Sum.
//Memory Usage: 39.9 MB, less than 11.86% of Java online submissions for Combination Sum.


 public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result= new ArrayList<>();
        if (candidates == null || candidates.length==0)
            return result;
        List<Integer> tmp = new ArrayList<>();
        backtrack(candidates,result,tmp , 0,  target,0);
        
        return result;
    }
    
    private void backtrack(int[] candidates,List<List<Integer>> result, List<Integer> tmp,int sum, int target, int index){
       //base 
       if (sum==target){
           result.add(new ArrayList<>(tmp));
           return;
       } 
        if (sum>target) return;
       //logic
       for (int i=index;i<candidates.length;i++){
         //action
         tmp.add(candidates[i]);
         //recurse
         backtrack(candidates,result,tmp, sum+candidates[i],target,i);
         //backtrack
         tmp.remove(tmp.size()-1);  
       } 
        
    }