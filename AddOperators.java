//TC: O(N * 4^N). We have 4 different recursive paths - 4^N(add, minus, mul, no op) The length of expr could be 'N'.
//SC: Recursion stack O(N), intermediate list could be size O(N) if all digits are operands.

/*
1. Start from index and add the element to current path. 
2. The recursive paths can be 4. +, -, *, and no operator but to move froward to next index. 
3. Keep prevSum and prevAdd elements. When prevSum == target, path is valid. 
4. During *, * gets a higher precendence than + or -. 
5. For loop will start from index and goes till end. 


*/
import java.util.*;

public class AddOperators{

    static List<String> result = new ArrayList<>();
    public static List<String> addOperators(String num, int target){

        bt(num, target, 0, 0, 0, "");

        return result;
    }

    private static void bt(String num, int target,int index, long ps, long pa, String expr){

        if(index >= num.length()){
            if(ps == target)
                result.add(expr);
                return;
            
        }

        for(int i = index; i < num.length(); i++){
          
            long cur = Long.parseLong(num.substring(index, i+1));

            if(num.charAt(index) == '0' && index != i) continue;

            if(index == 0){
                bt(num, target, i + 1, cur, cur, expr + cur);
            }else{
    
                //+
                bt(num, target, i + 1, ps + cur, cur, expr + "+" + cur);
    
                //-
                bt(num, target, i + 1, ps - cur, -cur, expr + "-" + cur);
    
                //*
                bt(num, target, i + 1, ps - pa + pa * cur, pa * cur, expr + "*" + cur);
            }
        }
    }

    public static void main(String[] args){
        String num = "105";
        List<String> res = addOperators(num, 5);
        System.out.println(res);

    }

}