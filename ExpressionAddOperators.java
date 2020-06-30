/**
 * Time Complexity : O(4^n)
 * Space Complexity : O(4^n+n)
 */

import java.util.*;
public class ExpressionAddOperators {
    List<String> result;
    int targ;
    public List<String> addOperators(String num, int target) {
        result=new ArrayList<>();
        targ=target;
        if(num==null || num.length()==0)
            return result;

        helper(num,"",0,0,0);

        return result;
    }

    private void helper(String num, String path,long sum, long tail, int index)
    {
        if(index==num.length())
        {
            if(sum==targ)
                result.add(path);

            return;
        }

        for(int i=index;i<num.length();i++)
        {
            //preceding zero
            if(i!=index && num.charAt(index)=='0') break;
            long curr=Long.parseLong(num.substring(index,i+1));
          if(index==0)
              helper(num,path+curr,curr,curr,i+1);
           else
           {  
               helper(num,path+"+"+curr,sum+curr,curr,i+1);
               helper(num,path+"-"+curr,sum-curr,-curr,i+1);
               helper(num,path+"*"+curr,(sum-tail)+(tail*curr),tail*curr,i+1);   

           }

        }
    }
}