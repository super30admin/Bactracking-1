package Nov24;

import java.util.ArrayList;
import java.util.List;

class ExpressionAddOperators {
    
    /* 
	Time Complexity: O(4^n) because we have 4 choices at every node:   +,-,*,no operator

	Space Complexity: constant space for String Builder since we are creating one stringbuilder only + O(4^n) for recursive stack
	      
	Did this code successfully run on Leetcode : Yes

	Any problem you faced while coding this : No

	Approach:
    Important point to remember that at every level we have take care of the last operation as well.
    
     op     |        calc               |      tail(mess that we are creating)
     -------|----------------------------|----------------------------------------
     '+'    |        calc+curr           |     +curr
     '-'    |        calc+curr           |     -curr
     '*'    |        calc-tail+tail*curr |     tail*curr
    
*/
     List<String> result;
     int target;
    public List<String> addOperators(String num, int target) {
       result = new ArrayList<String>();
        this.target = target;
        if(num==null || num.length()==0)
            return result;
        
        backtrack(num,new StringBuilder(),0,0,0); 
       
        return result;
    }
    public void backtrack(String num, StringBuilder path,long calc,long tail,int index){
        
        // base 
        if(index==num.length()){
            if(calc==target){
                result.add(path.toString());
                return;
            }
        }
        
        for(int i=index;i<num.length();i++){ 
            if(index != i && num.charAt(index)=='0') break;
            long curr = Long.parseLong(num.substring(index,i+1));
            int len = path.toString().length();
            if(index==0){
                 path.append(curr);
                 backtrack(num,path,curr,curr,i+1);  
                 path.setLength(len);   
            }else{
                //+
                 path.append("+");
                 path.append(curr);
                 backtrack(num,path,calc+curr,curr,i+1);  
                 path.setLength(len);  
                
                //-
                 path.append("-");
                 path.append(curr);
                 backtrack(num,path,calc-curr,-curr,i+1);  
                 path.setLength(len);  
                //*
                 path.append("*");
                 path.append(curr);
                 backtrack(num,path,calc-tail+tail * curr,tail*curr,i+1);  
                 path.setLength(len);  
                
            }
            
        }
        
    }
    
}