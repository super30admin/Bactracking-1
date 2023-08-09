//Problem 1: Combination Sum
// Time Complexity : O(m+n)
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//Approach-> every number has 2 choices, to choose and not choose
//Choose -> call recursive function on same number(1 number can be selected multiple times) and reduce the target by the selected number
//NOT choose-> call recursive func on next number(as we didnt choose that) keep the target same. 
//Can be done with 01 recursion or for loop based recursion (basically both are same)
class Solution {
    List<List<Integer>> res;
    //brute force TC: O(m+n) SC: O(m+n)(height of tree)
    // public List<List<Integer>> combinationSum(int[] candidates, int target) {
    //     this.res=new ArrayList<>();
    //     if(candidates==null) return res;
    //     helper(candidates,0, target,new ArrayList<>());
    //     return res;
    // }
    // private void helper(int[] candidates, int i, int target, List<Integer> path){
    //     //base
    //     //if candidate addition has passed actual target, return, or else all elements are passed, return
    //     if(target<0 || i ==candidates.length) return;
    //     if(target==0){ 
    //         res.add(new ArrayList<>(path));
    //         return;
    //     }
    //     //logic
    //     //not choose
    //     helper(candidates, i+1, target, path);

    //     //choose
    //     //action
    //     path.add(candidates[i]);
    //     //reverse
    //     helper(candidates, i, target-candidates[i], path);

    //     path.remove(path.size()-1);
    // }

    // for loop based recursion
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.res=new ArrayList<>();
        if(candidates==null) return res;
        helper(candidates,0, target,new ArrayList<>());
        return res;
    }
    private void helper(int[] candidates, int pivot, int target, List<Integer> path){
        //base
        if(target<0) return;
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        //logic
        
        for(int i=pivot;i<candidates.length;i++){ //for loop from pivot onwards to last element
            //action
            path.add(candidates[i]);
            helper(candidates, i, target-candidates[i], path);
            path.remove(path.size()-1);
            //choose
        }
    }
}

//Problem 1: Expression Add Operators
// Time Complexity : O(4^n)
// Space Complexity : O(4n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//Approach-> there are 4 operators in total, make recursive call to each operator with new string always and check if result is equal to target
// BACKTRACKING: maintain a single Stringbuilder, backtrack to the original string after a recursive call is completed
class Solution {
    //TC: 4^n 
    //SC: 4n

    // List<String> res;
    // public List<String> addOperators(String num, int target) {
    //     this.res=new ArrayList<>();
    //     helper(num, 0, 0, 0, target, "");
    //     return res;
    // }

    // private void helper(String num, int pivot, long calc, long tail, int target, String path){
    //     //base
    //     if(pivot==num.length()){ //reached end
    //         if(target==calc){
    //             res.add(path);
    //         }
    //         return;
    //     }

    //     //logic
    //     for(int i=pivot;i<num.length();i++){
    //         //action
    //         //placeholder proceeding zero
                // if(num.charAt(pivot)=='0' && i!=pivot) continue;
    //         long cur=Long.parseLong(num.substring(pivot,i+1));
            
    //         //make combinations
    //         if(pivot==0){
    //             helper(num,i+1, cur,cur, target,  path+cur);
    //         }else{
    //             //+
    //             helper(num,i+1, calc+cur, +cur, target, path+"+"+cur);
    //             //-
    //             helper(num,i+1, calc-cur, -cur, target, path+"-"+cur);
    //             //*
    //             helper(num,i+1, calc-tail + tail*cur, tail*cur, target, path+"*"+cur);
    //         }
    //     }
    // }

    //Solution with single StringBuilder //backtracking
    List<String> res;
    public List<String> addOperators(String num, int target) {
        this.res=new ArrayList<>();
        helper(num, 0, 0, 0, target, new StringBuilder());
        return res;
    }

    private void helper(String num, int pivot, long calc, long tail, int target, StringBuilder path){
        //base
        if(pivot==num.length()){ //reached end
            if(target==calc){
                res.add(path.toString());
            }
            return;
        }

        //logic
        for(int i=pivot;i<num.length();i++){
            int length=path.length();
            //action
            //placeholder proceeding zero
            if(num.charAt(pivot)=='0' && i!=pivot) continue;
            long cur=Long.parseLong(num.substring(pivot,i+1));
            
            //make combinations
            if(pivot==0){
                path.append(cur);
                helper(num,i+1, cur,cur, target,  path);
                path.setLength(length);
            }else{
                //+
                //action
                path.append("+");
                path.append(cur);
                helper(num,i+1, calc+cur, +cur, target, path);
                path.setLength(length);

                //-
                path.append("-");
                path.append(cur);
                helper(num,i+1, calc-cur, -cur, target, path);
                path.setLength(length);

                //*
                path.append("*");
                path.append(cur);
                helper(num,i+1, calc-tail + tail*cur, tail*cur, target, path);
                path.setLength(length);
            }
        }
    }

}