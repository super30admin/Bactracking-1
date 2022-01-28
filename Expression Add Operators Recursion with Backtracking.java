// Time Complexity : O(4^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, new StringBuilder(), 0, 0, 0, target);
        return result;
    }
    
    private void helper(String num, StringBuilder sb, int index, long calc, long tail, int target){

        // base 

        if(index == num.length()){
            if(calc == target){
                result.add(sb.toString());
                return;
            }
        }
        
        // logic
       for(int i = index; i < num.length(); i++){

           // preceding zero case
            if(index != i && num.charAt(index) == '0') break;

           long curr = Long.parseLong(num.substring(index, i + 1)); // 1*5

           int len = sb.toString().length();

           if(index == 0){
               sb.append(curr); //action
               helper(num, sb,  i + 1, curr, curr, target); // recurse
               sb.setLength(len); // backtrack
           } else {
               // +
               sb.append("+");//action
               sb.append(curr);//action
               helper(num, sb, i + 1, calc + curr, curr,  target); // recurse
               sb.setLength(len);// backtrack

               // -
               sb.append("-");//action
               sb.append(curr);//action
               helper(num, sb, i + 1, calc - curr, -curr, target); // // recurse
               sb.setLength(len);// backtrack
               
               // *
               sb.append("*");
               sb.append(curr);
               helper(num, sb, i + 1, calc - tail + tail*curr, tail*curr, target); // recurse
               sb.setLength(len);// backtrack

           }

       }

    }
}