// Time Complexity:           O(2n * 4^n)    = O(n*4^n)
// Space Complexity:          O(n + n + n-1) = O(n)
// where n is length of given String
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOpeartors {
    public static void main(String[] args) {
        String str = "105";
        int target = 5;
        SolutionExpressionAddOpeartors obj = new SolutionExpressionAddOpeartors();
        List<String> list = obj.addOperators(str, target);
        System.out.println(list);
    }
}


class SolutionExpressionAddOpeartors {

    private List<String> result;
    private String num;
    private int target;

    public List<String> addOperators(String num, int target) {
        this.result = new ArrayList<>();
        this.num = num;
        this.target = target;

        addOperators(0,0,0,new ArrayList<>());

        return result;
    }

    private void addOperators(int index, long val, long tail, List<String> ops) {

        // BASE CASE
        if(index == num.length()) {
            if(val == target) {                             // got target using current combination
                StringBuilder sb = new StringBuilder();     // getting string from List<String> "ops"
                for(String op : ops) {
                    sb.append(op);
                }
                result.add(sb.toString());                  // adding String to result
            }
            return;
        }


        // RECURSION
        for(int i=index; i<num.length(); i++) {
            String oprndStr = num.substring(index, i+1);
            long oprndLong = Long.parseLong(oprndStr);

            if(index == 0) {                                    // if first operand
                ops.add(oprndStr);                              // directly adding in "oprndStr"
                addOperators(
                        i+1,
                        oprndLong,
                        oprndLong,
                        ops
                );
                ops.remove(ops.size()-1);                 // bactracking
            }

            else {
                // add
                ops.add("+" + oprndStr);
                addOperators(
                        i+1,
                        val + oprndLong,
                        oprndLong,
                        ops
                );
                ops.remove(ops.size()-1);       // bactracking

                // sub
                ops.add("-" + oprndStr);
                addOperators(
                        i+1,
                        val - oprndLong,
                        -oprndLong,
                        ops
                );
                ops.remove(ops.size()-1);       // bactracking

                // mul
                ops.add("*" + oprndStr);
                addOperators(
                        i+1,
                        val - tail + (tail * oprndLong),
                        tail * oprndLong,
                        ops
                );
                ops.remove(ops.size()-1);       // bactracking

                // nothing
            }

            if(oprndStr.charAt(0) == '0')
                break;
        }
    }
}