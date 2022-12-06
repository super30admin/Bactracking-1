//Time complexity is O(N^T/M) N is length of array, T is target values, M is minimum of given numbers in Array
//Space complexity is O(T/M)
class Solution {
    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates, target, 0, 0, new ArrayList());
        return result;
    }
    public void helper(int[] arr, int target, int currsum, int curr, List<Integer> li){
        if(currsum==target){
            result.add(li);
            return;
        }
        if(currsum>target){
            return;
        }
        for(int i=curr;i<arr.length;i++){
            li.add(arr[i]);
            helper(arr, target, currsum+arr[i], i, li);
            li.remove(li.size()-1);
        }        
    }
}