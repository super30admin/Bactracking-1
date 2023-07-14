// Time Complexity : O(2^n * 3^n)) where n is the length of the num array
// Space Complexity :O(n) where n is the length of the num array
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :
import java.util.ArrayList;
import java.util.List;
class ExpressionAndOperators {
    private List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, target, 0, 0, 0, new StringBuilder());
        return result;
    }

    //current, calculated, tail
    private void helper(String num, int target, int pivot, long calc,
                        long tail, StringBuilder sb){

        //base
        if(pivot == num.length()){
            if(calc == target){
                result.add(sb.toString());
            }
            return;
        }
        //logic
        for(int i = pivot; i<num.length(); i++){
            //leading 0s case
            if(num.charAt(pivot) == '0' && i!= pivot){
                continue;
            }

            int l = sb.length();
            Long current = Long.parseLong(num.substring(pivot, i+1));

            if(pivot == 0){
                sb.append(current);
                helper(num, target, i+1, current, current, sb);
                sb.setLength(l);
            }else{
                //3 options
                //+
                sb.append("+");
                sb.append(current);
                helper(num, target, i+1, calc + current, current, sb);
                sb.setLength(l);

                //-
                sb.append("-");
                sb.append(current);
                helper(num, target, i+1, calc - current, -current, sb);
                sb.setLength(l);

                //*
                sb.append("*");
                sb.append(current);
                helper(num, target, i+1, calc - tail + (tail * current), tail*current, sb);
                sb.setLength(l);
            }
        }
    }
}