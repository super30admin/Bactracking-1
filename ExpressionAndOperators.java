// Time Complexity : O(4*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// At every step there are 4 choices - no operation, addition, subtraction or multiplication
// We will write logics for these, for multiplications the we would have to 
// subtract and get the immediate left and right so as to apply the precedence rule.

class Solution {
    ArrayList<String> ans;
    String digits;
    long target;
    public List<String> addOperators(String num, int target) {
        this.target = target;
        this.digits = num;
        this.ans = new ArrayList<String>();
        // if(num.length() == 0)
        //     return ans;
        compute(0, 0, 0, 0, new ArrayList<String>());
        return this.ans;
    }
    private void compute(int index, long prev, long cur, long val, ArrayList<String> ops){
        String nums = this.digits;
        if(index == nums.length()){
            if(val == target && cur == 0){
                StringBuilder sb = new StringBuilder();
                ops.subList(1, ops.size()).forEach(v -> sb.append(v));
                this.ans.add(sb.toString());
            }
            return;
        }
        cur = cur*10 +Character.getNumericValue(nums.charAt(index));
        String curvalrep = Long.toString(cur);
       // int l = nums.length();
        if(cur > 0){
            //No Operation
            compute(index+1, prev, cur, val, ops);
        }
        //addition
        ops.add("+");
        ops.add(curvalrep);
        compute(index+1, cur, 0, val + cur, ops);
        ops.remove(ops.size() - 1);
        ops.remove(ops.size() - 1);
        if (ops.size() > 0) {

      // Subtaction
      ops.add("-");
      ops.add(curvalrep);
      compute(index + 1, -cur, 0, val - cur, ops);
      ops.remove(ops.size() - 1);
      ops.remove(ops.size() - 1);

      // MULTIPLICATION
      ops.add("*");
      ops.add(curvalrep);
      compute(index + 1, cur * prev, 0, val - prev + (cur * prev), ops);
      ops.remove(ops.size() - 1);
      ops.remove(ops.size() - 1);
    }
    }
}