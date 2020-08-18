import java.util.ArrayList;
import java.util.List;

class AddOperators {
    List<String> result;
    int targ;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        if(num == null || num.length()==0)return result;
        targ = target;
        helper(num,target,new StringBuilder(),0,0,0);
        return result;
    }
    private void helper(String num,int target,StringBuilder sb ,long cal,long end,int index){
        //base
        if(index == num.length() && cal==target){
            result.add(sb.toString());
            return;
        }
        //logic
        for(int i = index;i < num.length();i++){
            if(index != i && num.charAt(index) == '0')break;
            long curr = Long.parseLong(num.substring(index,i+1));
            int len = sb.toString().length();
            if(index == 0){
               sb.append(curr);
                helper(num,target,sb,curr,curr,i+1);
                sb.setLength(len);
            }
            else{
                sb.append("+");
                sb.append(curr);
                helper(num,target,sb,cal+curr,curr,i+1);
                sb.setLength(len);
                
                sb.append("-");
                sb.append(curr);
                helper(num,target,sb,cal-curr,-curr,i+1);
                sb.setLength(len);
            
                sb.append("*");
                sb.append(curr);
                helper(num,target,sb,cal-end + end*curr,end*curr,i+1);
                sb.setLength(len);
            
            }
        }
    }
    public static void main(String args[]){
        AddOperators obj = new AddOperators();
        System.out.println(obj.addOperators("123", 6));       
    }
}