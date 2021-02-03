// Time Complexity : O(4 to the power of n) (exponantial) -> At each recursion, we have 4 options ( +, - , * or do nothing)
// Space Complexity : O(n) where n is the length of the string + O(n) for recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    int target;
    List<String> result;
    public List<String> addOperators(String num, int target) {
        this.target = target;
        result = new ArrayList();
        if(num == null || num.length() == 0) return result;
        helper(num, "", 0,0,0);
        return result;
    }

    private void helper(String num, String path, long calc, long tail, int index) {

        if(index >= num.length())  {
            if(target == calc) {
                result.add(path);
            }
            return;
        }


        for(int i = index; i < num.length(); i++) {

            if(index != i && num.charAt(index) == '0') continue; //To avoid cases like 105
            long curr = Long.parseLong(num.substring(index,i+1));
            if(index == 0) {
                helper(num, String.valueOf(curr), curr, curr , i+1);
            } else {

                //case +
                helper(num, path + "+" + curr, calc + curr, curr, i+1);

                //case  -
                helper(num, path + "-" + curr, calc - curr, -curr, i+1);

                //case *
                helper(num, path + "*" + curr, calc - tail + (tail * curr), tail * curr, i+1);
            }
        }
    }
}
