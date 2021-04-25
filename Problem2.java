//Add Operators
//tc - O(n*4^n)
//sc - O(n)
import java.util.*;
public class Problem2 {
    public static void main(String[] args){
        Problem2 p = new Problem2();
        System.out.println(p.addOperators("123", 6));

    }
    static List<String> res = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        if(num==null || num.length()==0){
            return res;
        } 
        helper(num, target, "", 0,0,0);
        return res;
        
        
    }
    public void helper(String num, int target, String path, int index, long calc, long tail){
        //base
        if(index == num.length()){
            if(target == calc){
                res.add(path);
            }
            return;
        }
        
        //logic
        for(int i = index; i< num.length(); i++){
            long curr = Long.parseLong(num.substring(index, i+1)); //curr value  //1,2
            if(index != i && num.charAt(index) =='0'){ //taking care of '05'
                continue;
            }
            if(index ==0){
                helper(num, target, path+ curr, i+1,curr, curr);
            }
            else{
                //+
                helper(num, target, path +"+" + curr, i+1, calc + curr, curr);
                
                //-
                helper(num, target, path +"-"+curr, i+1, calc - curr, -curr);
                //* for the bodmas rule
                helper(num, target, path + "*" +curr, i+1,calc - tail + curr * tail , curr* tail);
            }
        }
    }
    
}
