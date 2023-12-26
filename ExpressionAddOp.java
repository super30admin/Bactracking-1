//T.C O(4 pow n) +,-,*, no op options between digits
//S.C O(n) rec space for digits + operators between digits
import java.util.ArrayList;
import java.util.List;

class ExpressionAddOp {
    List<String> res;
    public List<String> addOperators(String num, int target) {
        res = new ArrayList<>();
        helper(num, target,new StringBuilder(),0,0,0);
        return res;
    }

    private void helper(String num, int target, StringBuilder sb, long calc, long tail, int index){

        //base
        if(index == num.length()){
            if(calc == target){
                res.add(sb.toString());
                return;
            }
        }
        //logic
        for(int i= index;i<num.length();i++){
            //preceding zero case
            if(index!=i && num.charAt(index)=='0') break;

            long curr = Long.parseLong(num.substring(index,i+1));
            int len = sb.toString().length();
            if(index == 0){
                sb.append(curr);//action
                helper(num, target, sb, curr, curr, i+1);
                sb.setLength(len); //backtrack
            } else{
                sb.append("+");
                sb.append(curr);
                helper(num, target, sb, calc+curr, curr, i+1);
                sb.setLength(len);

                sb.append("-");
                sb.append(curr);
                helper(num, target, sb, calc - curr, -curr, i+1);
                sb.setLength(len);

                sb.append("*");
                sb.append(curr);
                helper(num, target, sb, calc-tail + tail * curr, tail*curr,i+1);
                sb.setLength(len);
            }
        }
    }
}