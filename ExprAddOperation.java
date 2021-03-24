// Time Complexity : O(4^N) since we're having 4 different recursive paths and N - input String length
// Addition, Subtraction, Multiplication and grouping
// Space Complexity : O(N) Used for recursion Stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    List<String> result = new ArrayList<>();
    
    public List<String> addOperators(String num, int target) {
        backtracking(num,0,0,0,"",target);
        return result;
    }
    public void backtracking(String num, int index,long prevSum,long prevAdd, String expr, int target){
        if(index >= num.length() && prevSum == target){
            result.add(expr);
            return;
        }
        for(int i =index;i<num.length();i++){
            long curr = Long.parseLong(num.substring(index,i+1));
            if(num.charAt(index) == '0' && index != i) continue;
          // If the index at starting point, theprevSum value will be the same
            if(index == 0){
                backtracking(num,i+1,curr,curr,expr+curr,target);
            }
            else{
                // + operation combination
                backtracking(num,i+1,prevSum+curr,curr,expr+"+"+curr,target);
                // - operation combination
                backtracking(num,i+1,prevSum-curr,-curr,expr+"-"+curr,target);
                // * operation combination
                backtracking(num,i+1,prevSum-prevAdd+prevAdd*curr,prevAdd*curr,expr+"*"+curr,target);
            }
        }
    }
}
