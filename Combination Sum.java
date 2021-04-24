// Backtracking : ITERATIVE template
//Time Complexity : O(2^n). As we make decission to whether to choose or not to choose at each level
//Space Complecity : O(n), the recursive stack take O(n) space
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : In the iterative solution, used a helper function to perform backtracking.
// Each time the backtrack recurive function is called, the current element is added to the list and subtracted from the remaing target.
// Along with this the elements are added to the path list. If the target is zero, then we have got the desired list of elements that can reach to target and can be added to the main list.
//If the target is less than 0 or negative value then we can no longer go further and have to backtrack(this is dne by removing the last element from the list) to see if the next elemnts can reach us top target.
//In the choose and not choose approach everything is same as iterative approach except  that recursive call is made twice at each level. Once when we choose and item and when
// we not choose and item.

// Your code here along with comments explaining your approach
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length==0||candidates==null){
            return result;
        }
        //use helper function to perform recursion
        backtrack(candidates,target,0,new ArrayList<>());
        return result;
    }
    private void backtrack(int[] candidates, int target, int index,List<Integer> path){
        //if target is a negativa value dont continue
        if(target<0){
            return;
        }
        //if zero add the current list to main list
        if(target==0){
            result.add(new ArrayList<>(path));
            return;
        }
        //iterate through the i/p array recursively
        for(int i=index;i<candidates.length;i++){
            //ACTION :  chhose the value
            path.add(candidates[i]);
            //RECURSE : go down the path through recurssion
            backtrack(candidates,target-candidates[i],i,path);
            //BACKTRACK: if the target is not reached go to previous step and continue with other items
            path.remove(path.size()-1);
        }
    } 
}


//Choose and not choose template
//Time Complexity : O(2^n). As we make decission to whether to choose or not to choose at each level
//Space Complecity : O(n), the recursive stack take O(n) space
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length==0||candidates==null){
            return result;
        }
        //use helper function to perform recursion
        backtrack(candidates,target,0,new ArrayList<>());
        return result;
    }
    private void backtrack(int[] candidates, int target, int index,List<Integer> path){
        if(index == candidates.length||target < 0){
            return;
        }
        if(target == 0){
            result.add(new ArrayList<>(path));//create a new list to store the intermediate result
            return;
        }
        //dont choose option
        backtrack(candidates,target,index+1,path);//moving to next element
        //for choose case copy the element choosen to list
        //ACTION part
        path.add(candidates[index]);
        //RECURSE part
        backtrack(candidates,target-candidates[index],index,path);//here the new target is rem of choosen element and original target and the index remains same as the chosen elemnet can be reused
        //BACKTRACK part
        //remove the last element from the list to resue the result from previous step and go and choose the other path
        path.remove(path.size()-1);
        
    }
}