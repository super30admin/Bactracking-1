// ######### Approach 1 : 0-1 recursion ########
//Time Complexity: O(2^m*n) (m is target and n is no of elements)
//Space Complexity: O(2^m*n)


// Basic 0-1 Use case of choose and not choose
// When our elements add up to the target we need to store that local arraylist path
// into the global result
// So we have to maintain a unique path arraylist at every node.
// In the recursion you start with an empty path
// For not choose case: i+1 and same path
// For choose case: create a new arrayList Li and add the candidate to the Li
//                  i remains the same and remove i for next recursion
//                  target-candidates[i] because you chose i itself
// Base condition: when target reaches 0, add the path to the result and return
// When target < 0 and i is candidates.length return
// NOTE: you are making new arraylist at each node and passing it as "path" parameter.

class Solution {
    
    // 0-1 
    public List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        result=new ArrayList<>();
        helper(candidates,0,new ArrayList<>(),target);
        return result;
    }
    
    private void helper(int[] candidates, int i,List<Integer> path,int target){
        
        //base
        if(target==0){
            result.add(path);
            return;
        }
        
        if(i==candidates.length || target < 0) return;
        
        //not choose
        helper(candidates,i+1,path,target);
        
        List<Integer> li=new ArrayList<>(path);
        li.add(candidates[i]);
        
        //choose
        helper(candidates,i,li,target-candidates[i]);
    }
}



// ######### Approach 2 : 0-1 with BACKTRACKING ########
//Time Complexity: O(2^m*n) (m is target and n is no of elements)
//Space Complexity: O(2^m*n)


// Same as the last approach but instead of created a new arraylist at every node
// We keep adding nodes to the path and remove it after processing it. 
// If the path gets caught in the base case where target = 0, 
// We create a deep copy of that path in the base condition itself

class Solution {
    
    // 0-1 with Backtracking
    public List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        result=new ArrayList<>();
        helper(candidates,0,new ArrayList<>(),target);
        return result;
    }
    
    private void helper(int[] candidates, int i,List<Integer> path,int target){
        
        //base
        if(target==0){
            result.add(new ArrayList<>(path));
            return;
        }
        
        if(i==candidates.length || target < 0) return;
        
        //not choose
        helper(candidates,i+1,path,target);
        
        path.add(candidates[i]);
        
        //choose
        helper(candidates,i,path,target-candidates[i]);
        
        path.remove(path.size()-1);
    }
}


// ######### Approach 3 : FOR LOOP RECURSION ########
//Time Complexity: O(2^m*n) (m is target and n is no of elements)
//Space Complexity: O(2^m*n)



// In for loop based recursion we keep a fixed pointer known as pivot and we keep moving pointer 'i'
// Basically we start at a pivot as the parent at 0th position and move i from 0 to the end.
// After that recursion is over pivot would be at element 1 and i will start from element 1 to the end
// Same process till the pivot goes till the last element 
// NOTE: The for loop doesnt move the pivot, we pass 'i' as pivot for the next recursion call
// In your recursive function for loop starts with i=pivot
// Create a new arraylist inside this foor loop and adding the node
// And then calling recurse within for loop where now the pivot changes, your 'i' is passed as pivot
// When target==0, you add the current path to the result

class Solution {
    
    // For loop based recursion
    public List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        result=new ArrayList<>();
        helper(candidates,0,new ArrayList<>(),target);
        return result;
    }
    
    private void helper(int[] candidates, int pivot,List<Integer> path,int target){
        
        if(target==0){
            result.add(path);
            return;
        }
        
        if(pivot==candidates.length || target<0) return;
        
        for(int i=pivot;i<candidates.length;i++){
            
            List<Integer>li=new ArrayList<>(path);
            li.add(candidates[i]);
            
            helper(candidates,i,li,target-candidates[i]);
            
        }
        
    }
}


// ######### Approach 4 : FOR LOOP recursion with BACKTRACKING ########
//Time Complexity: O(2^m*n) (m is target and n is no of elements)
//Space Complexity: O(2^m*n)



// Here we are using backtracking where we remove the node from the path after adding it
// But we only create a deep copy and add it to the result when we hit the base condition target=0 
// Unlike normal recursion where at every node we are creating deep copy of the path first and
// then sending it to the next recursion

class Solution {
    
    // For loop based recursion with BACKTRACKING
    public List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        result=new ArrayList<>();
        helper(candidates,0,new ArrayList<>(),target);
        return result;
    }
    
    private void helper(int[] candidates, int pivot,List<Integer> path,int target){
        
        if(target==0){
            result.add(new ArrayList<>(path));
            return;
        }
        
        if(pivot==candidates.length || target<0) return;
        
        for(int i=pivot;i<candidates.length;i++){
            
            
            path.add(candidates[i]);
            
            helper(candidates,i,path,target-candidates[i]);
            
            path.remove(path.size()-1);
            
        }
        
    }
}

