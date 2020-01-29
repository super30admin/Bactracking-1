
// Time Complexity : O(N^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class CombinationSum { 
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list,new ArrayList<>(),candidates,target,0);
        return list;
    }
    
    public static void backtrack(List<List<Integer>> list,List<Integer> sublist,int nums[],int target,int start){
        int size = nums.length;
        if(target < 0){
            
        }
        else if(target == 0){
            list.add(new ArrayList<Integer>(sublist));
        }
        else{
        for(int i = start; i < size; i++ ){
            sublist.add(nums[i]);
            backtrack(list,sublist,nums, target - nums[i],i);
            sublist.remove(sublist.size() - 1);
        }
        }
    }
}