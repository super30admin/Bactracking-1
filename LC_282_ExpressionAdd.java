package LC_282_ExpressionAdd;

import java.util.ArrayList;
import java.util.List;

public class LC_282_ExpressionAdd {

	List<String> result = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        
    	backtrack("",num,target,0,0,0);
    	return result;
       
    }
       private void backtrack(String path, String num, int target, long calculated, long tail, int index)
       {
    	   //base case
    	   
    	   if(index==num.length())
		   {
			   if(calculated == target)
			   {
				   result.add(path);
			   }
		   }
    	   //Logic
    	   for(int i = index;i<num.length();i++)
    	   {
    		   if(i != index && num.charAt(index)=='0');
    		   long curr = Long.parseLong(num.substring(index, i+1));
    		   
    		   if(index==0)
    		   {
    			   backtrack(path+curr,num,target,curr,curr,i+1);
    		   }
    		   else
    		   {
    			   backtrack(path+"+"+curr,num,target,calculated+curr,+curr,i+1);
    			   backtrack(path+"-"+curr,num,target,calculated-curr,-curr,i+1);
    			   backtrack(path+"*"+curr,num,target,calculated-tail+tail*curr,tail*curr,i+1);

    		   }
    			   
    	   }
      
}

	public static void main(String[] args) {
		
		LC_282_ExpressionAdd obj = new LC_282_ExpressionAdd();
		System.out.println("output :"+ obj.addOperators("1234", 10));
	}

}
