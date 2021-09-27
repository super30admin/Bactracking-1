package Bactracking1;
// Time Complexity : O(4^n)
// Space Complexity : O(h) (recursion stack)
// Did this code successfully run on Leetcode : yes

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, 0, 0, 0, new StringBuilder(), target);
        return result;

    }

    private void helper(String s, int index, long calc, long tail, StringBuilder path, int target){
        //base
        if(index == s.length()){
            if(calc == target)
                result.add(path.toString());
            return;
        }

        //logic
        for(int i=index; i<s.length(); i++){
            if(index != i && s.charAt(index) == '0' ) break;
            String sub = s.substring(index, i+1);
            long num = Long.parseLong(sub);
            int len = path.length();
            if(index == 0){
                path.append(sub);
                helper(s, i+1, num, num, path, target);
                path.setLength(len);
            } else{
                //+
                path.append('+');
                path.append(sub);
                helper(s, i+1, calc + num, num, path, target);
                path.setLength(len);


                //-
                path.append('-');
                path.append(sub);
                helper(s, i+1, calc - num, -num, path, target);
                path.setLength(len);


                //*
                path.append('*');
                path.append(sub);
                helper(s, i+1, (calc - tail) + tail*num, tail*num, path, target);
                path.setLength(len);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new ExpressionAddOperators().addOperators("123", 6));
    }
}
