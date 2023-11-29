// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class ExpressionAddOperators {
    class Solution {
        List<String> result;
        public List<String> addOperators(String num, int target) {
            this.result = new ArrayList<>();
            helper(num, 0, new StringBuilder(), 0, 0, target);
            return result;
        }
        private void helper(String num, int pivot, StringBuilder path, long calVal, long tail, int target){
            //base
            if(pivot >= num.length()){
                if(calVal == target){
                    result.add(path.toString());
                }
            }
            //logic
            for(int i = pivot; i < num.length(); i++){

                //preceding zero edge case(055)
                if(num.charAt(pivot) == '0' && pivot != i)
                    continue;
                long curr = Long.parseLong(num.substring(pivot, i+1));

                int initLen = path.length();

                if(pivot == 0){
                    //action
                    path.append(curr);
                    //recurse
                    helper(num, i+1, path, calVal + curr, curr, target);
                    //backtrack
                    path.setLength(initLen);
                }
                else{
                    //action
                    path.append("+");
                    path.append(curr);
                    //recurse
                    helper(num, i+1, path, calVal + curr, curr, target);
                    //backtrack
                    path.setLength(initLen);

                    //action
                    path.append("-");
                    path.append(curr);
                    //recurse
                    helper(num, i+1, path, calVal - curr, -curr, target);
                    //backtrack
                    path.setLength(initLen);

                    //action
                    path.append("*");
                    path.append(curr);
                    //recurse
                    helper(num, i+1, path, calVal - tail + tail * curr, tail * curr, target);
                    //backtrack
                    path.setLength(initLen);
                }
            }
        }
    }
}
