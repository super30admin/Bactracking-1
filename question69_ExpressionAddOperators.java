package Backtracking1;

import java.util.ArrayList;
import java.util.List;

public class question69_ExpressionAddOperators {
    /* Created by palak on 6/30/2021 */

    /*
        Time Complexity: O(2^N)
        Space Complexity: O(N)
    */
    List<String> result;
    int target;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        this.target = target;
        helper(num, target, new StringBuilder(), 0, 0, 0);
        return result;
    }
    private void helper(String num, int target, StringBuilder sb, long cal, long tail, int index){
        //Base
        if(index == num.length()) {
            if(cal == target) {
                result.add(sb.toString());
                return;
            }
        }

        //Logic
        for(int i = index ; i < num.length() ; i++) {
            //precedding zero
            if(index != i && num.charAt(index) == '0') break;
            long curr = Long.parseLong(num.substring(index, i + 1));
            int len = sb.length();
            if(index == 0) {
                sb.append(curr); //action
                helper(num, target, sb, curr, curr, i + 1); //recurse
                sb.setLength(len); //backtracing
            } else {
                //+
                sb.append("+"); //action
                sb.append(curr); //action
                helper(num, target, sb, cal + curr , curr, i + 1); //recurse
                sb.setLength(len); //backtracing
                //-
                sb.append("-"); //action
                sb.append(curr); //action
                helper(num, target, sb, cal - curr , -curr, i + 1); //recurse
                sb.setLength(len); //backtracing
                //*
                sb.append("*"); //action
                sb.append(curr); //action
                helper(num, target, sb, cal - tail + tail * curr , tail * curr, i + 1); //recurse
                sb.setLength(len); //backtracing
            }
        }
    }

    public static void main(String[] args) {

    }
}
