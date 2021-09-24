// Time Complexity : O(n * 4^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num,target,0,0,0,"");
        return result;
    }
    public void helper(String num, int target, long cal, long tail, int index, String path)
    {
        //base
        //as we need to utilize all the numbers before we get target
        if(index == num.length()){
            if(cal == target){
                result.add(path);
            }
        }
        //logic
        for(int i =index;i<num.length();i++){
            //preceing zero
            if(num.charAt(index)=='0' && i != index)continue;
            //for loop between index and pivot so only numbers
          Long curr = Long.parseLong(num.substring(index,i+1));
            //for the first element its cal and tail will be that number itself
          if(index==0){
              helper(num,target,curr,curr,i+1,path + curr);
          }
            else{
                //+
                helper(num,target,cal + curr, curr, i+1, path + "+" + curr);
                //-
                helper(num,target,cal - curr, -curr, i+1, path + "-" + curr);
                //*
                helper(num,target,cal-tail + tail*curr, tail*curr, i+1, path + "*" + curr);
            }
        }
    }
}