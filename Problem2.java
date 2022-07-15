// Time Complexity : O(LX4^L)
// Space Complexity : O(L)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//282. Expression Add Operators
//https://leetcode.com/problems/expression-add-operators/


class Solution {
    //BACKTRACKING Approach
    //time: 
    //space: O(l) - l is the length of the string
       List<String> result;
    public List<String> addOperators(String num, int target) {
        
        result = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        
        helper(num, target, 0, 0, 0, sb);
        
        return result;
    }
    
    private void helper(String num, int target, int index, double cal, double tail, StringBuilder path){
        //base
        if(index == num.length()){
            if(cal == target){
                result.add(path.toString().trim()); //System.out.println("RESULT path " + path + " ");
            }
            return;
        }
        
        //logic
        //regular String method
        //know how to create all the substrings
        //how the calls and for loop work for different scenario
        for(int i = index; i<num.length(); i++){
            
            if( i != index && num.charAt(index) == '0') continue; //presiding zero issue averted 
            
            String currS = num.substring(index, i+1); //System.out.println(" "); System.out.print("i " + i + " "); System.out.print("temp " + temp + "  ");
            Double curr = Double.parseDouble(currS);
            
            int len = path.length();
            
            if(index == 0){ //System.out.println("sending " + " "+(cal+te));
                
                //action
                path.append(currS);
                //recurse
                helper(num, target, i+1, curr, curr, path); 
                //backtrack
                path.setLength(len);
            
            }else{ //System.out.print("path " + path + " "); System.out.println("sending " + path+"+"+(temp));
                
                //+
                //action
                path.append('+');
                path.append(currS);
                //recurse
                helper(num, target, i+1, (cal+curr), curr, path);
                //backtrack
                path.setLength(len);
            
                //-
                //action
                path.append('-');
                path.append(currS);
                //recurse
                helper(num, target, i+1, (cal-curr), -curr, path);
                //backtrack
                path.setLength(len);
            
                //*
                //action
                path.append('*');
                path.append(currS);
                //recurse
                helper(num, target, i+1, (cal-tail) + tail*curr, tail*curr, path);
                //backtrack
                path.setLength(len);
                
            }   
            
        }
    }
}



/*
class Solution {
    //WITHOUT BACKTRACKING
    //time: 
    //space: O(l) - l is the length of the string
       List<String> result;
    public List<String> addOperators(String num, int target) {
        
        result = new ArrayList<>();
        
        helper(num, target, 0, 0, 0, " ");
        
        return result;
    }
    
    private void helper(String num, int target, int index, double cal, double tail, String path){
        //base
        if(index == num.length()){
            if(cal == target){
                result.add(path.trim()); //System.out.println("RESULT path " + path + " ");
            }
            return;
        }
        
        //logic
        //regular String method
        //know how to create all the substrings
        //how the calls and for loop work for different scenario
        for(int i = index; i<num.length(); i++){
            
            if( i != index && num.charAt(index) == '0') continue;
            
            String temp = num.substring(index, i+1); //System.out.println(" "); System.out.print("i " + i + " "); System.out.print("temp " + temp + "  ");
            Double te = Double.parseDouble(temp);
            
            if(index == 0){ //System.out.println("sending " + " "+(cal+te));
                
                //+
                helper(num, target, i+1, te, te, path + temp);   
            4
            }else{ System.out.print("path " + path + " "); //System.out.println("sending " + path+"+"+(temp));
                
                //+
                helper(num, target, i+1, (cal+te), te, path+'+'+(temp));
            
                //-
                helper(num, target, i+1, (cal-te), -te, path+'-'+(temp));
            
                //*
                helper(num, target, i+1, (cal-tail) + tail*te, tail*te, path+'*'+(temp));
            }   
            
        }
    }
}
*/
