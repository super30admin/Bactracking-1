import java.util.*;
public class ExpressionAddOperators {
    

    public static List<String> result;

    public static List<String> addOperators(String num, int target) {
        
        result = new ArrayList<>();
        
        if(num == null || num.length()==0) return result;
        
        helper(num,target,0,0,0,"");
        
        return result;
        
    }
    
    
    private static void helper(String num, int target, long calc, long tail, int index, String path){
        
        if(index == num.length())
        {
            if(calc == target)
            {
                result.add(path);
            }
            
            return;
        }
        
        for(int i = index ;i < num.length() ; i++)
        {
            if(i!=index && num.charAt(index) == '0') continue;
              long curr = Long.parseLong(num.substring(index,i+1));
            if(index == 0)
            {
                helper(num, target, curr, curr, i+1,path + curr );
            }
            else
            {
                //+
                
                helper(num, target, calc + curr, curr, i+1, path + "+"+curr);
                
                //-
                helper(num, target, calc - curr, -curr, i+1, path + "-"+curr);
                
                //*
                helper(num, target, (calc - tail) + (tail*curr),tail*curr, i+1, path + "*"+curr);
            }
            
        }
        
    }

    public static void main(String args[])
    {
        String num= "123";
        int target = 6;

        List<String> ans = addOperators(num, target);
        for(String a: ans)
        {
            System.out.println(a);
        }
    }

}
