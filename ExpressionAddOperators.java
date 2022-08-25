
//TC = O(2^n)
//Space = O(n)

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
      result = new ArrayList<>();
      helper(num, 0, 0, 0, "", target);
      return result;
    }
    
    private void helper(String num, int idx, long cal, long tail, String path, int target){
     //base
    if(idx == num.length())
    {
        if(cal == target){ // 6 == 6
            result.add(path);  //"1*2*3" // "1+2+3"     
        }
        return;

    }

    //logic
    for(int i= idx; i< num.length() ; i++){
        
        //precdeing zero
        if(num.charAt(idx) == '0' && i != idx) continue;
        
        //long curr = Long.parseLong(num, substring(idx, i+1));
         long curr = Long.parseLong(num.substring(idx, i+1) ); 

        if(idx == 0){
            helper(num, i+1, curr, curr, path+curr, target); 
        }
        
        else{
            //+
            helper(num, i+1, cal + curr,               + curr,     path +"+"+ curr, target);
            //-
            helper(num, i+1, cal - curr,               - curr,     path +"-"+ curr, target);
            //*
            helper(num, i+1, cal - tail + tail * curr, tail*curr,  path +"*"+ curr, target);
        }
    }
     }
}
