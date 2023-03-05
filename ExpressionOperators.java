import java.util.*;
public class ExpressionOperators {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num,0,target,new StringBuilder(),0,0);
        return result;
    }
    private void helper(String num, int pivot, int target,StringBuilder path,long calc,long tail){
        //base
        if(pivot == num.length()){
            if(calc==target){
                result.add(path.toString());
            }
            return;
        }
        //logic
        for(int i=pivot;i<num.length();i++){
            if(num.charAt(pivot) == '0' && i!= pivot) continue;
            int len = path.length();
            long curr = Long.parseLong(num.substring(pivot,i+1));
            if(pivot==0){
                path.append(curr);
                helper(num,i+1,target,path,curr,curr);
                path.setLength(len);
            }
            else{
                path.append("+");
                path.append(curr);
                helper(num, i+1, target, path, calc+curr, +curr);
                path.setLength(len);

                path.append("-");
                path.append(curr);
                helper(num, i+1, target, path, calc-curr, -curr);
                path.setLength(len);

                path.append("*");
                path.append(curr);
                helper(num, i+1, target, path, calc-tail+tail*curr,tail*curr);
                path.setLength(len);
            }
        }
    }
}
