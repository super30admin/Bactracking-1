//Combination sum
//Time complexity = O(2^m+n)
//Space complexity = O(m+n)
class Solution {

     List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        result=new ArrayList<>();
        helper(candidates,target,new ArrayList<Integer>(),0);
        return result;
    }
    private void helper(int[] candidates,int target,List<Integer> path,int pivot)
    {
        //base case
         if(target<0) return;
        if(target==0)
        {
            result.add(new ArrayList<>(path));
            return;
        }
       
        for(int i=pivot;i<candidates.length;i++)
        {
            //action
            path.add(candidates[i]);
            //recurse
            helper(candidates,target-candidates[i],path,i); // i since we can consider all elements from pivot onwards
           // backtrack
            path.remove(path.size()-1);//remove last element 
        }

    }
}