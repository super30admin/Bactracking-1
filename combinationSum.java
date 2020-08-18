//time complexity: O(2^n), we have two cases: choose or not choose
//space complexity: O(logn) ; longest branch of the tree
//executed on leetcode: yes

//solution without backtracking; space inefficient since we are using a new arry list at every node
/**
class Solution {
    List<List<Integer>> result;
    int targ;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates==null||candidates.length==0) return result;
        targ=target;
        helper(candidates,new ArrayList<>(),0,0);
        return result;
    }
    private void helper(int[] candidates,List<Integer> temp,int index,int sum)
    {
        if(targ==sum)
        {
            result.add(temp);
            return;
        }
        if(index==candidates.length||sum>targ) return;
        //choose
        temp.add(candidates[index]);
        helper(candidates,new ArrayList<>(temp),index,sum+candidates[index]);
        //dont choose
        temp.remove(temp.size()-1);
        helper(candidates,new ArrayList<>(temp),index+1,sum);
    }
}
**/

//backtracking solution; space efficient; we are using the same list to add and remove numbers at different levels in the tree
//time complexity : O(n)
//space complexity: O(logn)
class Solution {
    List<List<Integer>> result;
    int targ;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates==null||candidates.length==0) return result;
        targ=target;
        helper(candidates,new ArrayList<>(),0,0);
        return result;
    }
    private void helper(int[] candidates,List<Integer> temp,int index,int sum)
    {
        if(targ==sum)
        {
            result.add(new ArrayList<>(temp));// here we will return a copy of temp, wy? because at the root temp will be empty and after all the recusion backtracks, result will have a reference to a temp which is empty, we will get a list of null lists as result.
            //result.add(temp);
            return;
        }
        if(index==candidates.length||sum>targ) return;
        //choose
        temp.add(candidates[index]);
        helper(candidates,temp,index,sum+candidates[index]);
        //dont choose
        temp.remove(temp.size()-1);
        helper(candidates,temp,index+1,sum);
    }
}