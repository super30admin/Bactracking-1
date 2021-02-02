// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result=new ArrayList<>();
        helper(candidates,target,0,new ArrayList<Integer>());
        return result;
        
    }
    
    public void helper(int[] candidates,int target,int index,List<Integer> path){
        //base condititon
        if(target<0|| index==candidates.length){
            return;
        }
        if(target==0){
           // System.out.println(path);
            result.add(new ArrayList<>(path));
            return;
        }
        
        //action
        List<Integer> newPath=new ArrayList<>(path);
        newPath.add(candidates[index]);
        helper(candidates,target-candidates[index],index,newPath);
        helper(candidates,target,index+1,new ArrayList<>(path));
    }
}


//using the backtracking process rather than the deep copy.
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result=new ArrayList<>();
        helper(candidates,target,0,new ArrayList<Integer>());
        return result;
        
    }
    
    public void helper(int[] candidates,int target,int index,List<Integer> path){
        //base condititon
        if(target<0|| index==candidates.length){
            return;
        }
        if(target==0){
           // System.out.println(path);
            result.add(new ArrayList<>(path));
            return;
        }
        
        //action
        // List<Integer> newPath=new ArrayList<>(path);
        // newPath.add(candidates[index]);
        path.add(candidates[index]);
        helper(candidates,target-candidates[index],index,path);
        path.remove(path.size()-1);
        helper(candidates,target,index+1,path);
    }
}










