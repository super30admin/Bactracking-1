import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    // TC:O(n*4^n) where n is num.length()
    // SC:O(n*4^n)
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, target,0, "", 0, 0);
        return result;
    }

    private void helper(String num, int target,int pivot, String path, long calc, long tail){

        if(pivot == num.length() && calc == target){
            result.add(path);
        }

        //logic
        for(int i = pivot; i < num.length(); i++){
            if (i != pivot && num.charAt(pivot) == '0') {
                // Avoid leading zeros in the number
                continue;
            }
            long curr = Long.parseLong(num.substring(pivot,i+1));

            if(pivot == 0){
                helper(num, target, i+1, path+curr, curr, curr);
            }else{
                //+                            //1+2
                helper(num, target, i+1, path+"+"+curr,calc+curr, curr);
                //-
                helper(num, target, i+1, path+"-"+curr,calc-curr, -curr);
                //*
                helper(num, target, i+1, path+"*"+curr,calc- tail + (tail*curr), tail*curr);
            }
        }
    }
//*************** Explicit Backtracking Using String Builder
    // TC:O(4^n) where n is num.length()
    // SC:O(n) + O(n)
    List<String> result2;
    public List<String> addOperators2(String num, int target) {
        result2 = new ArrayList<>();
        helper2(num, target,0, new StringBuilder(), 0, 0);
        return result2;
    }

    private void helper2(String num, int target,int pivot, StringBuilder path, long calc, long tail){

        if(pivot == num.length() && calc == target){
            result2.add(new String(path));
        }

        //logic
        for(int i = pivot; i < num.length(); i++){
            if (i != pivot && num.charAt(pivot) == '0') {
                // Avoid leading zeros in the number
                continue;
            }
            long curr = Long.parseLong(num.substring(pivot,i+1));
            int le = path.length();

            if(pivot == 0){
                path.append(curr);
                helper2(num, target, i+1, path, curr, curr);
                path.setLength(le);
            }else{
                //+                            //1+2
                path.append("+");
                path.append(curr);
                helper2(num, target, i+1, path,calc+curr, curr);
                path.setLength(le);
                //-
                path.append("-");
                path.append(curr);
                helper2(num, target, i+1, path,calc-curr, -curr);
                path.setLength(le);
                //*
                path.append("*");
                path.append(curr);
                helper2(num, target, i+1, path,calc- tail + (tail*curr), tail*curr);
                path.setLength(le);
            }
        }
    }
}
