import java.util.ArrayList;
import java.util.List;

//Time Complexity : O(2^N)
//Space Complexity : O(N)
public class Expression_Add_Operators{

   private List<String> result;
   public List<String> addOperators(String num, int target) {
      result = new ArrayList<>();  
       helper(num,target, 0, 0, 0,"");
       return result;
   }
   public void helper(String num, int target, long calc, long tail, int pivot, String path){
       //base
       if(pivot == num.length()){
           if(target == calc){
               result.add(path);
           }
           return;
       }
       //logic
       for(int i = pivot; i < num.length(); i++){
           long curr = Long.parseLong(num.substring(pivot, i+ 1)); 
           //preceding 0s
           if(num.charAt(pivot) == '0' && pivot != i) continue;
           if(pivot == 0){
               helper(num, target, curr, curr, i+1, path + curr);
           }
           else{
               //+
                helper(num,target, calc + curr, curr, i+ 1, path + "+" + curr);
               //-
                helper(num,target, calc - curr, -curr, i+ 1, path + "-" + curr);
               //*
               helper(num, target, calc - tail + tail * curr, tail*curr, i+1, path + "*" + curr);
           }
       }
   }
}
