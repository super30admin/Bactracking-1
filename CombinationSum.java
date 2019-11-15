// Time Complexity : O(exp^N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Nope.


// Your code here along with comments explaining your approach
class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(null == candidates || 0 == candidates.length){return result;}
        combinationSum(candidates,new ArrayList<>(),result,0,0,target);
        return result;
    }
    public void combinationSum(int[] arr,List<Integer> list,List<List<Integer>> result,int index,int sum, int target){
        if(sum == target){result.add(new ArrayList<>(list));return;}
        if(sum > target || index == arr.length){return;}
        list.add(arr[index]);
        combinationSum(arr,list,result,index,sum+arr[index],target);
        list.remove(list.size()-1);
        combinationSum(arr,list,result,index+1,sum,target);
    }
}