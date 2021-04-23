/*
Space com:O(h)==h is the height of the rec stack
Time comp:(4 ^n)
checking null condition for num
calling the helper method 
In the helper method we check if it reached the last index
and target==calculated value
iterating through the loop
 and making recursive calls
*/


class Solution {
    List<String>result;
    public List<String> addOperators(String num, int target) {
      result= new ArrayList<>();
        if(num==null || num.length()==0){
            return result;
        }
        helper(num, target, 0, 0,0,"");
            return result;
    
    }
    
    private void helper(String num, int target,long cal, long tail, int index, String path){
        if(num.length()==index && target== cal ){
            result.add(path);
            return;
        }
        
        for(int i=index;i<num.length();i++){
            long curr= Long.parseLong(num.substring(index,i+1));
            if(index!=i && num.charAt(index)=='0') {continue;}
            if(index==0){
                
              helper(num, target, curr, curr,i+1,path+curr);  
            }
            else{
                //+
                 helper(num, target, curr+cal, curr,i+1,path+"+"+curr);
                 
                //-
                helper(num, target, cal-curr, -curr,i+1,path+"-"+curr);
                //*
                helper(num, target, cal-tail + curr*tail, curr *tail,i+1,path+"*"+curr);
            }
        }
    }
}