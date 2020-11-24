//Time Complexity : O(4^n)  // Recursion
//Space Complexity : O(4^n) // Recursion
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

//Time Complexity : O(4^n)  // Backtrack
//Space Complexity : O(n)   // Backtrack
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

package com.s30.satish;
import java.util.List;
import java.util.ArrayList;

// Backtrack
class Expression_Add_Operators_282 {
    List<String> result = new ArrayList<>();
    int targetNum;
    public List<String> addOperators(String num, int target) {
        if(num == null || num.length() == 0)
            return result;
        targetNum = target;
        helper(num, target, new StringBuilder(), 0, 0, 0);
        return result;
    }
    private void helper(String num, int target, StringBuilder sb, long calc, long tail, int index)
    {
        // Base
        if(index == num.length())
        {
            if(calc == targetNum)
            {
                result.add(sb.toString());
                return;
            }
        }
        // Logic
        for(int i = index; i < num.length(); i++)
        {
            if(index != i && num.charAt(index) == '0')
                break;
            long curr = Long.parseLong(num.substring(index, i+1));
            int lengt = sb.toString().length();
            if(index == 0)
            {
                sb.append(curr);
                helper(num, target, sb, curr, curr, i+1);
                sb.setLength(lengt);
            }
            
            else
            {
                // +
                sb.append("+");
                sb.append(curr);
                helper(num, target, sb, calc + curr, curr, i+1);
                sb.setLength(lengt);
                
                // -
                sb.append("-");
                sb.append(curr);
                helper(num, target, sb, calc - curr, -curr, i+1);
                sb.setLength(lengt);
                
                // *
                sb.append("*");
                sb.append(curr);
                helper(num, target, sb, calc - tail + tail * curr, tail*curr, i+1);
                sb.setLength(lengt);
            }    
        }
    }
}

// Recursion

//    List<String> result = new ArrayList<>();
//    int targetNum;
//    public List<String> addOperators(String num, int target) {
//        if(num == null || num.length() == 0)
//            return result;
//        targetNum = target;
//        helper(num, 0, 0, "", 0);
//        return result;
//    }
//    private void helper(String num, long tail, long calc, String path, int index)
//    {
//        // Base
//        if(index == num.length())
//        {
//            if(calc == targetNum)
//            {
//                result.add(path);
//                return;
//            }
//        }
//        // Logic
//        for(int i = index; i < num.length(); i++)
//        {
//            long curr = Long.parseLong(num.substring(index, i+1));
//            if(index != i && num.charAt(index) == '0')
//                continue;
//            if(index == 0)
//                helper(num, curr, curr, path + curr, i+1);
//            else
//            {
//                // +
//                helper(num, +curr, calc + curr, path + "+" + curr, i+1);
//                
//                // -
//                helper(num, -curr, calc - curr, path + "-" + curr, i+1);
//                
//                // *
//                helper(num, tail * curr, calc - tail + tail * curr, path + "*" + curr, i+1);
//            }
//                
//        }
//    }
//}