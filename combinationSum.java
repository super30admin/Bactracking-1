    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/combination-sum/
    Time Complexity for operators : o(n^n) .. n is the length of the string
    Extra Space Complexity for operators : o(n) for (List<String> path) without recursive stack
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. Backtracking
                    A) Call the backtracking function from main fucntion with initial values.
                    B) The backtracking function will contains input as string candidates, taregt, path, index.
                    C) Base case, if target < 0.That means, we have travelled till the end.
                    D) target == 0, then add it to the list.
                    E) index >= candidates.length then we passed index then return.
                    F) In the main backtracking for loop(to get the substring), first add element to the list
                    E) then do backtracking, call abcktracking function by passi for index as we need repeated elements.
                    F) At the end, remove last element from the String.
                    G) in main function, return final output.
    */  

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        answer = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(candidates,target,path,0);
        return answer;
        
    }
    
    List<List<Integer>> answer;
    
    public void backtracking(int[] candidates,int target, List<Integer> path, int index){
        // base
        
        if(target<0){
            return;    
        }else if(target == 0){
            
            // keep eye on below statment why. we need to create new arraylist and then add into to final list
            // Initially I added path directly which created empty list 
            
            answer.add(new ArrayList<>(path));
            return;
        }else if(index >= candidates.length){
            return;
        }
        
        
        // backtracking
        
        for(int i=index; i<candidates.length;i++){
        
            
            // add
            path.add(candidates[i]);
            
            // backtrack
            backtracking(candidates,target-candidates[i],path,i);
            
            // remove
            path.remove(path.size()-1);
            
        }
    }
}