import java.util.ArrayList;
import java.util.List;
/*
Time Complexity: O(N*4^N), there are 4 configurations for the backtracking method, +, -, * and creating string
Space Complexity: O(N) size of the recursion tree N
Run on Leetcode: Yes

Approach:
1. I am using depth first search on the given number and making all the possible target using the digits of the given
string num and operators +, -, and *, when the target matches then I am updated my result list with the configuration
2. Now I will be adding all the expressions that gives me target value
 */
public class ExpressionAddOperators {
    public List<String> result = new ArrayList<>();
    public long stringLength, resTarget;
    public String num;
    public List<String> addOperators(String num, int target){
        this.num = num;
        if(num == null || num.length()== 0){
            return result;
        }
        stringLength = num.length();
        resTarget = target;
        backtrackOnGivenString("", 0, 0,0);
        return result;
    }

    public void backtrackOnGivenString(String s, int index, long multiplication, long addition){
        if(index == stringLength){
            if(addition == resTarget){
                result.add(s);
                return;
            }
        }

        for(int i = index; i<stringLength; i++){
            if(i!= index && num.charAt(i) == '0'){
                break;
            }
            long n = Long.parseLong(num.substring(index, i+1));
            if(index == 0){
                backtrackOnGivenString(n+"", i+1, n, n);
                continue;
            }
            backtrackOnGivenString(s+"+"+n, i+1, n, addition+n);
            backtrackOnGivenString(s+"-"+n, i+1, -n, addition-n);
            /*
                to calculate multiplication, I should subtract previous number, and then add current
                multiplication result to the subtraction result
             */
            backtrackOnGivenString(s+"*"+n, i+1, multiplication*n, addition-multiplication+multiplication*n);
        }
    }
    public static void main(String[] args){
        ExpressionAddOperators obj = new ExpressionAddOperators();
        ExpressionAddOperators obj1 = new ExpressionAddOperators();
        System.out.println("Expression Add Operators: "+obj.addOperators("123", 6));
        System.out.println("Expression Add Operators: "+obj1.addOperators("232", 8));
    }
}
