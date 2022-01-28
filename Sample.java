// Time Complexity :O(2^n+m) m = Array length
// Space Complexity :O(2n^+m) m = Array length
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates,0,new ArrayList<>(),target);
        return result;
    }
private  void helper(int [] candidates, int index,List<Integer> path, int target ){
        //base
        if(target == 0){
            result.add(path);
            return;
        }
        if(target < 0 || index == candidates.length) return;
    
        //logic
        //choose
        List<Integer> temp = new ArrayList<>(path);
        temp.add(candidates[index]);
        helper(candidates, index, temp, target -candidates[index]);
        //notchoose
        helper(candidates,index+1,new ArrayList<>(path), target);
        //notchoose
    }
}
// Time Complexity :O(2^n+m) m = Array length
// Space Complexity :O(2n^+m) m = Array length
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates,0,new ArrayList<>(),target);
        return result;
    }
private  void helper(int [] candidates, int index,List<Integer> path, int target ){
        //base
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0 || index == candidates.length) return;
    
        //logic
        //choose
        path.add(candidates[index]);
        helper(candidates, index, path, target -candidates[index]);
        path.remove(path.size()-1);
        //notchoose
        helper(candidates,index+1,new ArrayList<>(path), target);
        //notchoose
    }
}


// Time Complexity :O(2^n) 
// Space Complexity :O(n2^) 
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates,0,new ArrayList<>(),target);
        return result;
    }
private  void helper(int [] candidates, int index,List<Integer> path, int target ){
        //base
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0 ||index == candidates.length) return;
        for(int i = index;i<candidates.length;i++){
            List<Integer> temp = new ArrayList<>(path);
            temp.add(candidates[i]);
            helper(candidates,i,temp,target - candidates[i]);
        }
    }
}

// Time Complexity :O(2^n ) 
// Space Complexity :O(n2^n) 
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates,0,new ArrayList<>(),target);
        return result;
    }
private  void helper(int [] candidates, int index,List<Integer> path, int target ){
        //base
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0 ||index == candidates.length) return;
        for(int i = index;i<candidates.length;i++){
            //action
            path.add(candidates[i]);
            //recurse
            helper(candidates,i,path,target - candidates[i]);
            //Backtrack
            path.remove(path.size()-1);
        }
    }
}

// Time Complexity :O(2^n) n = Array length
// Space Complexity :O(n2^n) n = Array length
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        //if(num.length() == null) return;
        helper(num,"",0,0,0,target);
        return result;
        
    }
    private void helper(String num,String path, int index,long cal, long tail, int target){
        
        if(index == num.length()){
                if(cal == target){
                    result.add(path);
                    return;
                }
                }
        //logic
        
        for(int i = index; i<num.length();i++){
            if(i != index && num.charAt(index) == '0') continue;
            long curr = Long.parseLong(num.substring(index,i+1));
            if(index == 0){
                helper(num,path+curr,i+1,curr,curr,target);
            }else{
                //+
                helper(num, path + "+" + curr,i+1,cal + curr,curr,target);
                //-
                helper(num, path + "-" + curr,i+1,cal - curr,-curr,target);
                //*
                helper(num, path + "*" + curr,i+1,cal - tail+(tail * curr),tail*curr,target);
            }
        }
    }
}
