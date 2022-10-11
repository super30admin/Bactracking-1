//Approach-1: Exhaustive Search
//Overall Time Complexity:O(2^(M*N))
//Overall Space Compelxity:O(2^(M*N))
class Solution {
    List<List<Integer>> result;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        dfs(candidates, 0, target, new ArrayList<Integer>());
        return result;
    }
    
    public void dfs(int[] candidates, int indx, int target, List<Integer> path){
        //Base Case
        if(target == 0){
            result.add(path);
            return;
        }
        if(target < 0 || indx == candidates.length) return;
            
        //Functionality
        //Not-Select Case
        dfs(candidates, indx + 1, target, new ArrayList<>(path));
        
        //Select-case
        path.add(candidates[indx]);
        dfs(candidates, indx, target - candidates[indx], new ArrayList<>(path));
    }
}




//Approach-2: Back-tracking
//Overall Time Complexity:O(2^(M*N))
//Overall Space Compelxity:O(2^(M*N))
class Solution {
    List<List<Integer>> result;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        dfs(candidates, 0, target, new ArrayList<Integer>());
        return result;
    }
    
    public void dfs(int[] candidates, int indx, int target, List<Integer> path){
        //Base Case
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0 || indx == candidates.length) return;
            
        //Functionality
        //Not-Select Case
        dfs(candidates, indx + 1, target, path);
        
        //Select-case
        path.add(candidates[indx]);
        dfs(candidates, indx, target - candidates[indx], path);
        path.remove(path.size() - 1);
    }
}



//Approach-3: ForLoop Based Recursion - Maintaining a pivot
//Overall Time Complexity:O(2^(M*N))
//Overall Space Compelxity:O(2^(M*N))
class Solution {
    List<List<Integer>> result;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        dfs(candidates, 0, target, new ArrayList<Integer>());
        return result;
    }
    
    public void dfs(int[] candidates, int pivot, int target, List<Integer> path){
        //Base Case
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0) return;
        
        for(int i = pivot; i < candidates.length; i++){
            List<Integer> temp = new ArrayList<>(path);
            temp.add(candidates[i]);
            dfs(candidates, i, target - candidates[i], temp);
        }
    }
}



//Approach-4: ForLoop Based Recursion - Maintaining a pivot (Backtracking)
//Overall Time Complexity:O(2^(M*N))
//Overall Space Compelxity:O(2^(M*N))
class Solution {
    List<List<Integer>> result;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        dfs(candidates, 0, target, new ArrayList<Integer>());
        return result;
    }
    
    public void dfs(int[] candidates, int pivot, int target, List<Integer> path){
        //Base Case
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0) return;
        
        for(int i = pivot; i < candidates.length; i++){
            path.add(candidates[i]);
            dfs(candidates, i, target - candidates[i], path);
            path.remove(path.size() - 1);
        }
    }
}



