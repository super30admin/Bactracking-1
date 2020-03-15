import java.util.LinkedList;
import java.util.List;
//time complexity : i guess worst case would be if all numbers are factors of target then it'd be 4^n
//space complexity :  O(4^n)
//leet code : yes
//steps : for every operand and expression there are 4 possible ways one for No operation, addition, subtraction and multiplication. these four levels are caiired using DFS


class Solution {
    public List<String> addOperators(String num, int target) {
        
        List<String> result = new LinkedList<>();
        
        backTracking(result, num, target,0,"",0,0);
        return result;
    }
    
   public void backTracking(List<String> result, String num, int target, int index, String expression, long val, long prevSign){
        
        //is goal
        if(index==num.length()){
            if(val==target){
                result.add(expression);
            }
            return;
        }
        
        for(int cursor = index; cursor<num.length(); cursor++){
            if(index!=cursor && num.charAt(index)=='0') break;
            Long operand = Long.parseLong(num.substring(index,cursor+1));
            
            
            
            //noOp
            if(index==0){
                backTracking(result,num,target,cursor+1, ""+operand, operand,operand);
            }
            else {
                //add
                backTracking(result,num,target,cursor+1,expression + "+" +operand,val+operand,operand);
                //subtract-1*
                backTracking(result,num,target,cursor+1,expression+"-"+operand,val-operand,-1*operand);
                //multiply
                backTracking(result,num,target,cursor+1,expression+"*"+operand,val-prevSign+operand*prevSign,operand*prevSign);
                
                
            }
            
        }
        
        
    }
    
}