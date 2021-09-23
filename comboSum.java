// Time Complexity : O(n^e), exponential
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


public class comboSum {
    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> combinationSum(int[] a, int target) {
         helper(0,a,new ArrayList(),target); 
        return result;
    }
    public void helper(int start,int[]a,ArrayList<Integer> myArrList,int target) {
        if(target == 0){
            result.add(new ArrayList(myArrList));     
        }
        if(target < 0) return;
        
        for(int i = start; i< a.length; i++) {
            myArrList.add(a[i]);
            helper(i, a, myArrList, target - a[i]);
            myArrList.remove(myArrList.size() - 1);
        }
    }
}
