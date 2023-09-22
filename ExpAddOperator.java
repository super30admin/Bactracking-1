//TC = N*3^N
//SC = O(N)

class Solution{
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, target, 0, 0, 0, "");
        return result;
    }
    private void helper(String num, int target, int pivote, long calc, long tail, String path){
        //base
        if(pivote == num.length()){
            if(calc == target){
                result.add(path.toString());
            }
            return;
        }

        //logic
        for(int i = pivote; i<num.length(); i++){
            if(num.charAt(pivote) == '0' && i!= pivote) continue;
            long curr = Long.parseLong(num.substring(pivote, i+1));
            //make conbibations
            if(pivote == 0){
                helper(num, target, i+1, curr, curr, path+curr);
            }else{
                //+
                //-
                //*
                helper(num, target, i+1, calc+curr, curr, path+ "+"+curr);
                helper(num, target, i+1, calc-curr, curr, path+ "-"+curr);
                helper(num, target, i+1, calc - tail + tail * curr, tail*curr, path+"*"+curr);
            }
        }

  
    }
}