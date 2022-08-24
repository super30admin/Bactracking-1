//TC: o(3*2^(n)) 3 operation +.-,* with 2^N 
//SC: o(n)

//Backtracking solution
// normal recursion creates new string every time we recuse 
// so creating string builder and backtracking by removing the added path is the optimol solution

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num,0,target,0,0,new StringBuilder());
        return result;
        
    }
    /*
    formula:
    operator    calcSum     tail
    +           calc+curr   +curr
    -           calc-curr   -curr
    *           calc-tail+  tail *curr
                tail*curr   
     */
    private void helper(String num,int pivot, int target,long calcSum,long tail,StringBuilder path){
        
        //base 
        //if reachers the num.lenght then there is no child and if target is equal to the target then add the path to result
        if(pivot == num.length()){
            if(target==calcSum){
                result.add(path.toString());
            }
        }
        
        //logic
        for(int i = pivot;i<num.length();i++){
            if(num.charAt(pivot) == '0' && pivot != i) continue;
            // adding above line to handle this case
            /* 
            "105" 5
            output : ["1*0+5","1*5","10-5"]
            expected : ["1*0+5","10-5"]
            
            As all the elements are not taken in "1*5" this should't come in ouput
            to remove this case we are removing if num.charAt(pivot) is equal to = and pivot is not equal to i then we are breaking
        
            */
            long curr = Long.parseLong(num.substring(pivot,i+1)); // calculating the current 
            int len = path.length();    
                if(pivot==0){
                    //action
                    path.append(curr);
                    //recurse
                    helper(num,i+1,target,curr,curr,path);
                    //backtrack
                    path.setLength(len);
                }
                else{
                    // action
                    path.append("+");
                    path.append(curr);
                    //recurse
                     helper(num,i+1,target,calcSum+curr,curr,path);  //+
                    //backtrack
                    path.setLength(len);
                    
                    // action
                    path.append("-");
                    path.append(curr);
                    //recurse
                     helper(num,i+1,target,calcSum-curr,-curr,path);  //-
                    //backtrack
                    path.setLength(len);
                    
                    // action
                    path.append("*");
                    path.append(curr);
                    //recurse
                     helper(num,i+1,target,calcSum-tail+tail*curr,tail*curr,path); //*
                    //backtrack
                    path.setLength(len);
                    
                }
        }
    }
}

// normal recursive solutions
class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num,0,target,0,0,"");
        return result;
        
    }
    /*
    formula:
    operator    calcSum     tail
    +           calc+curr   +curr
    -           calc-curr   -curr
    *           calc-tail+  tail *curr
                tail*curr   
     */
    private void helper(String num,int pivot, int target,long calcSum,long tail,String path){
        
        //base 
        if(pivot == num.length()){
            if(target==calcSum){
                result.add(path);
            }
        }
        
        //logic
        for(int i = pivot;i<num.length();i++){
            if(num.charAt(pivot) == '0' && pivot != i) continue;
            // adding above line to handle this case
            /* 
            "105" 5
            output : ["1*0+5","1*5","10-5"]
            expected : ["1*0+5","10-5"]
            
            As all the elements are not taken in "1*5" this should't come in ouput
            to remove this case we are removing if num.charAt(pivot) is equal to = and pivot is not equal to i then we are breaking
        
            */
            long curr = Long.parseLong(num.substring(pivot,i+1)); // calculating the current 
                
                if(pivot==0){
                    helper(num,i+1,target,curr,curr,path+curr);
                }
                else{
                     helper(num,i+1,target,calcSum+curr,curr,path+"+"+curr);  //+
                    
                     helper(num,i+1,target,calcSum-curr,-curr,path+"-"+curr);  //-
                    
                     helper(num,i+1,target,calcSum-tail+tail*curr,tail*curr,path+"*"+curr); //*
                    
                }
        }
    }
}
