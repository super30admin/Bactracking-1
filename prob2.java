// Time Complexity : O(4^(N))  as there are 4 options -> number / + / - / *
// Space Complexity : O(N) for string builder
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Explain your approach: 
// for loop based backtracking pivot onwards, if pivot at first character, just append it to the stringbuilder
// else for +,-,*, add the symbol and curr value to the string builder, recurse with appropriate calc, tail, index
// for preceding zero just break

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        if(num == null || num.equals("")) return result;
        helper(num, target, 0, 0, 0, new StringBuilder());
        return result;
    }

    private void helper(String num, int target, int index, long calc, long tail, StringBuilder sb){
        // base
        if(index == num.length()){
            if(calc == target){
                result.add(sb.toString());
            }
            return;
        }
        // logic
        for(int i = index; i < num.length(); i++){
            // preceding zero
            if(index != i && num.charAt(index) == '0') break;

            long curr = Long.parseLong(num.substring(index, i+1));
            int len = sb.toString().length();
            if(index == 0){
                sb.append(curr);
                helper(num, target, i+1, curr, curr, sb);
                sb.setLength(len);
            }else{
                // +
                sb.append("+");
                sb.append(curr);
                helper(num, target, i+1, calc + curr, curr, sb);
                sb.setLength(len);
                // - 
                sb.append("-");
                sb.append(curr);
                helper(num, target, i+1, calc - curr, -curr, sb);
                sb.setLength(len);
                // * 
                sb.append("*");
                sb.append(curr);
                helper(num, target, i+1, calc - tail + tail * curr, tail * curr, sb);
                sb.setLength(len);
            }
        }
    }
}

// public class prob2 {
//     List<String> result;
//     public List<String> addOperators(String num, int target) {
//         result = new ArrayList<>();
//         if(num == null || num.equals("")) return result;
//         helper(num, target, 0, 0, 0, "");
//         return result;
//     }

//     private void helper(String num, int target, int index, long calc, long tail, String path){
//         // base
//         if(index == num.length()){
//             if(calc == target){
//                 result.add(path);
//             }
//             return;
//         }
//         // logic
//         for(int i = index; i < num.length(); i++){
//             // preceding zero
//             if(index != i && num.charAt(index) == '0') break;

//             long curr = Long.parseLong(num.substring(index, i+1));
//             if(index == 0){
//                 helper(num, target, i+1, curr, curr, path + curr);
//             }else{
//                 // +
//                 helper(num, target, i+1, calc + curr, curr, path + "+" + curr);
//                 // - 
//                 helper(num, target, i+1, calc - curr, -curr, path + "-" + curr);
//                 // * 
//                 helper(num, target, i+1, calc - tail + tail * curr, tail * curr, path + "*" + curr);
//             }
//         }
//     }
    
// }
