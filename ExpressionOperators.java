import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExpressionOperators {

    /*Extremely hard question
PS
Given a string containing numbers and a target value. I need to return all the combinations which can
lead to the target using operator + - *.
Also, you can place 2 numbers together out of 3 to calculate target eg input =123 target =15 then 12+3=15

Iterate?
maintain a calculated value resolves the issue with iterate over numbers and maintaining with operators + -. Issue comes
when we try to iterate with multiplication eg if target is 6 and the combination is 1+2*3 the calculated ans will be 9
instead of 7(operator precedence).

So we need to maintain tail which will give the exact situation at a given time
if 2 gets subtracted from the calculated value then tail will have -2, if you adding 3 it will have 3. Tail will

Value under consideration will be current

So  How to find calc  		tail for each operator
+	calc+curr 		  			 +tail
-	calc-curr 		  			 -tail
*   calc-tail +tail*curr	     tail * curr

What to pass to recursive function
nums, target, index, calc value, tail, expression
//https://leetcode.com/problems/expression-add-operators/description/
//Time Complexity O(4^n) where n equals number of combinations
//Space Complexity O(h) - where h equals the height of recursive tree
*/
    public static void main(String[] args) {
        String num = "123";
        int target = 6;
        System.out.println(addOperators(num,target));
    }
    static List<String> result;
    public static List<String> addOperators(String num, int target) {
        if(num==null || num.length()==0) return Collections.emptyList();
        result = new ArrayList<>();
        helper(num,target,0,0,0,"");
        return result;
    }

    private static void helper(String num, int target, int index, long calc, long tail, String path) {
//base
        if(index==num.length()){
            if(calc==target){
                result.add(path);
            }
            return;
        }
            //logic
        for (int i = index ; i <num.length() ; i++) {
            if (index != i && num.charAt(index) == '0') continue;
            long curr = Long.parseLong(num.substring(index, i + 1));
            if (index == 0) {
                helper(num, target, i + 1, curr, curr, path + curr);
            } else {
                //+case
                helper(num, target, i + 1, calc + curr, +curr, path + "+" + curr);
                //-case
                helper(num, target, i + 1, calc - curr, -curr, path + "-" + curr);
                //*case
                helper(num, target, i + 1, calc - tail + tail * curr, tail * curr, path + "*" + curr);

            }
        }


    }


}

