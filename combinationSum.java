// Time Complexity : Exponential
// Space Complexity :
class Solution {
    List<List<Integer>> res;
 
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null || candidates.length==0) return new ArrayList<>();
        res=new ArrayList<>();
       
        recurse(candidates, target, 0 , new ArrayList<>());
        
        return res;
    }
    
    private void recurse(int[] arr,int target,int index, List<Integer> path){
        //base
        if(target<0){
            return;
        }
        
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        
        //logic
        //for loop based recursion
        
        for(int i=index; i<arr.length;i++){
            //action
            path.add(arr[i]);

            //recurse
            recurse(arr, target-arr[i], i,path);

            //backtrack
            path.remove(path.size()-1);
        }
    }
}