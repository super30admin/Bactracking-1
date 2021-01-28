//Problem 69:  Expression Add Operators
//Time Complexity: O(4^n)=> exponential, because we are making 4 Decisions. n stands for input array length
//Space Complexity : O(n), because I'm using StringBuilder which is mutable data structure along with concept of backtracking; 


/*
Steps:
   Use the concept of calc and tail
   1) If current operator is '+'   calc = calc+curr   |  tail = curr
   2) If current operator is '-'   calc = calc-curr   |  tail = -curr
   3) If current operator is '*'   calc = calc-tail+tail*curr   |  tail = tail*curr 

   Basically evaluate expression on each concatenation and carry forward the current sum and the tail which currVal. So that in case of multiplication we can nullify the tail which is previous value.
   
   Note: For consider precedence 0 case which is num = "105", target = 5 . res = ["1*0+5","10-5"]
*/

import java.util.*;
class Solution69 {
    List<String> res; 
    int targ;    
    public List<String> addOperators(String num, int target) {

        res = new ArrayList<>();
        targ = target;
        if(num==null || num.length()==0) return res;
        
        //Bruteforce: TC: O(4^N), because we are making 4 Decisions | SC: O(N*4^N)
        //helper(num,"",0,0,0);

        //Backtracking TC: O(4^N), because we are making 4 Decisions | SC: O(N)
        helperBacktrack(num,new StringBuilder(),0,0,0);
         
        return res;
        
    }
    
  
    //Here calc is long because product of numbers can give Integer overflow. 
    private void helperBacktrack(String num, StringBuilder currPath, long calc,long tail, int idx){
        
        //base
        if(idx==num.length()){
            
            if(calc==targ) res.add(currPath.toString());
            
            return;
        }
        
        //logic
        
        for(int i=idx;i<num.length();i++){
            
            //precedence 0
            if(idx!=i && num.charAt(idx)=='0') continue;  //precedence over 0
            //there could be a case for 105 i.e 1*05 or 1*0005. This is invalid because long will convert 05 to 5 & this will give wrong result which is 1*5. Thus make sure when start idx is 0 and i pointer is not zero then u have to skip the case.
            
            Long currVal = Long.parseLong(num.substring(idx,i+1));//staring from idx then take 1,12,123|  //start idx to i+1, it will take care of all single digits as well as multiple digits//eg: we are taking 12 also
            int len = currPath.length();
            
            if(idx==0){//starting element
                 currPath.append(currVal); //action
                 helperBacktrack(num,currPath,currVal,currVal,i+1); //recursive
                 currPath.setLength(len); // backtrack
                
            }else{
                
                //+
                currPath.append("+");     //action
                currPath.append(currVal); //action
                helperBacktrack(num,currPath,calc+currVal,currVal,i+1); //recursive
                currPath.setLength(len); // backtrack
                
                //-
                currPath.append("-");     //action
                currPath.append(currVal); //action
                helperBacktrack(num,currPath,calc-currVal,-currVal,i+1); //recursive
                currPath.setLength(len); // backtrack
                
                
                //*
                currPath.append("*");     //action
                currPath.append(currVal); //action
                helperBacktrack(num,currPath,calc-tail+tail*currVal,tail*currVal,i+1); //recursive//here nullify previous val by calc-tail and adding tail*curr
                currPath.setLength(len); // backtrack
                
            }
                
            
        }
        
        
    }
    
        
    private void helper(String num,String path,long calc,long tail,int idx){
        
        //base
        if(idx==num.length()){
            
            if(calc==targ) res.add(path);
            
            return;
        }
        
        //logic
        //pivot pattern
        for(int i=idx;i<num.length();i++){
            Long currVal = Long.parseLong(num.substring(idx,i+1));//start idx to i+1, it will take care of all single digits as well as multiple digits//eg: we are taking 12 also
            
            //precedence over 0
            //there could be a case for 105 i.e 1*05 or 1*0005. This is invalid because long will convert 05 to 5 & this will give wrong result which is 1*5. Thus make sure when start idx is 0 and i pointer is not zero then u have to skip the case.
            if(idx!=i && num.charAt(idx)=='0') continue;
            
            if(idx==0){
                helper(num, path + currVal, currVal, currVal, i+1);
            }else{
                
                //+
                helper(num, path + "+" +currVal, calc+currVal, currVal, i+1);
                
                //-
                helper(num, path + "-" +currVal,calc-currVal,-currVal,i+1);
                
                //*
                helper(num, path + "*" +currVal, calc-tail + tail * currVal, tail * currVal, i+1);//here nullify previous val by calc-tail and adding tail*curr
                
            }
        }
        
    }
    
}
