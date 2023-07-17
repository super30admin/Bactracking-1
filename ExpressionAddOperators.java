import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    //TimeComlexity: 3*2^N
    //Space complexity: unsure
    List<String> current;
    List<List<String>> expressions;
    List<String> expression;
    public List<String> addOperators(String num, int target) {
        current = new ArrayList<>();
        expressions = new ArrayList<>();
        expression = new ArrayList<>();

        helper(num, 0, 0, 0, new StringBuilder(), target);

        return expression;
    }

    private void helper(String num, int idx, long val, long tail, StringBuilder path, int target){
        //base
        if(idx == num.length()){
            if(val == target){
                expression.add(path.toString());
            }
            return;
        }
        //logic
        for(int i = idx; i< num.length(); i++){
            int length = path.length();
            long curr = Long.parseLong(num.substring(idx, i+1));
            if(num.charAt(idx) == '0' && i != idx) continue;
            if(idx == 0){
                path.append(curr);
                helper(num, i+1, curr, curr, path, target);
                path.setLength(length);
            }else{
                //+
                path.append("+"+curr);
                helper(num, i+1, val+curr, curr, path, target);
                path.setLength(length);
                //-
                path.append("-"+curr);
                helper(num, i+1, val-curr, -curr, path, target);
                path.setLength(length);
                //*
                path.append("*"+curr);
                helper(num, i+1, val-tail+(tail*curr), curr*tail, path, target);
                path.setLength(length);
            }
        }
    }
}
