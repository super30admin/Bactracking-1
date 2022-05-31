
//Time: O(2^N) | Space: O(N)
// Backtracking solution
class Solution {
    List<String> res;
    public List<String> addOperators(String num, int target) {
        res = new ArrayList<>();
        helper(num, target, 0, 0,0, new StringBuilder());
        return res;
    }
    private void helper(String num, int target, long calc, long tail, int pivot, StringBuilder curr) {
        // when at the leaf, we are checking whether the calc satisfies the target or not
        if(pivot == num.length()) {
            if(calc == target) {
                res.add(curr.toString());
            }
            return;
        }
        for(int i=pivot;i<num.length();i++) {
            long currNum = Long.parseLong(num.substring(pivot,i+1));
            // currNum will be like 1, 12, 123, 1234, incase of input like 1234
            // storing the prevLength to backtrack later on, set the length of stringbuilder back to what it was
            int prevLength = curr.length();
            // preceding zero scenario
            if(num.charAt(pivot) == '0' && pivot != i) continue;
            // when we have string like 1, only one character, then there won't be any tail,
            // curr value and tail will be same
            if(pivot == 0) {
                curr.append(currNum);
                helper(num, target, currNum, currNum, i+1,curr);
                curr.setLength(prevLength);
            }
            else {
                curr.append("+");
                curr.append(currNum);
                helper(num, target, calc+currNum, currNum, i+1, curr);
                curr.setLength(prevLength);
                curr.append("-");
                curr.append(currNum);
                helper(num, target,  calc-currNum, - currNum, i+1, curr);
                curr.setLength(prevLength);
                curr.append("*");
                curr.append(currNum);
                helper(num, target,  (calc-tail)+(tail*currNum), tail*currNum, i+1,curr);
                curr.setLength(prevLength);
            }
        }
    }
}