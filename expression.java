// Time Complexity : O(n*3^n) (for loop+exploring 3 operations at each node)
// Space Complexity : O(3^n) for recursive stack space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
here we use backtracking since we want to look at all possible combination but the prob arises when we are multiplying

SInce in multiplication we can come across 1+2*3 situation  here we get 7 but we want 9
so we have to store prevOperations result and the total ,which we get after adding this prevOperations result (prevSum)
and we do it for multi-digit number so thats why for loop

if idx == num.length and we have reached target return else backtrack by passing all the required  params 


*/

class Solution {

    List<String> res = new LinkedList<>();

    public List<String> addOperators(String num, int target) {
        backtracking(num, target, 0, 0, 0, "");

        return res;

    }

    private void backtracking(String num, int target, int idx, long prevSum, long prevOper, String ans) {

        // base
        if (idx >= num.length()) {
            if (target == prevSum)
                res.add(ans);

            return;
        }

        // the for loop is because our number can be more than 1 digit number
        for (int i = idx; i < num.length(); i++) {
            long curr = Long.parseLong(num.substring(idx, i + 1));

            // this is done in order to skip the 0s in the start (while taking multiple
            // digits number into account)
            if (num.charAt(idx) == '0' && idx != i)
                continue;
            // recursion
            if (idx == 0) {
                backtracking(num, target, i + 1, curr, curr, ans + curr);
            } else {
                // +
                backtracking(num, target, i + 1, prevSum + curr, curr, ans + "+" + curr);

                // -
                // -1* curr since the element last added was the -curr
                // we are doing this in order to do the same operation while retrieving for the
                // multiplication part,
                // else we will not be able to undo the operation
                backtracking(num, target, i + 1, prevSum - curr, -1 * curr, ans + "-" + curr);

                // *
                // similarly prevOper*curr is the last thing we did
                backtracking(num, target, i + 1, prevSum - prevOper + prevOper * curr, prevOper * curr,
                        ans + "*" + curr);

            }
        }

        // long curr = Long.parseLong( String.valueOf(num.charAt(idx)));

        // // recursion
        // if (idx == 0){
        // backtracking(num, target, idx+1, curr, curr, ans + num.charAt(idx));
        // }else{
        // //+
        // backtracking(num, target, idx+1, prevSum+curr , curr, ans + "+" +
        // num.charAt(idx));

        // //-
        // //-1* curr since the element last added was the -curr
        // backtracking(num,target,idx+1,prevSum-curr , -1 * curr, ans + "-" +
        // num.charAt(idx));

        // //*
        // backtracking(num,target,idx+1,prevSum - prevOper + prevOper*curr,
        // prevOper*curr
        // , ans + "*" + num.charAt(idx));

        // }

    }
}