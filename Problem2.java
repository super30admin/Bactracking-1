class Solution {
    List<String> result;
    int targ;
    public List<String> addOperators(String num, int target) {
        targ = target;
        result = new ArrayList<>();
        helper(num, 0, 0, 0, "");
        return result;
    }
    private void helper(String num, int index, long calc, long tail, String path){
        //base
        if(index == num.length()){
            if(calc == targ){
                result.add(path);
                return;
            }
        }
        //logic
        for(int i=index; i<num.length(); i++){
            //preceeding zero case
            if(num.charAt(index) == '0' && index != i) break;
            long curr = Long.parseLong(num.substring(index, i+1));
            if(index == 0){
                helper(num, i+1, curr, curr, path+curr); 
            }else{
                //+  
                helper(num, i+1, calc + curr, curr, path + "+" + curr);  
                //-     
                helper(num, i+1, calc - curr, -curr, path + "-" + curr);             
                //*
                helper(num, i+1, calc - tail + tail*curr, tail*curr, path + "*" + curr); 
            }
        }
    }
}