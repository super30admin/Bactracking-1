class Problem282 {
    //TC-O(3^n)
    //SC O(3^n)
    List<String> result;
    public List<String> addOperators(String num, int target) {
        this.result=new ArrayList<>();
        helper(num,target,0,0,0,"");
        return result;
        
    }
    
    public void helper(String num, int target,int pivot, long calc,long tail, String path){
        if(pivot==num.length()){
            if(calc==target){
                result.add(path);
            }
            return;
        }
        
        //for loop recurssion
        for(int i=pivot;i<num.length();i++){
            if (i != pivot && num.charAt(pivot) == '0') {
                break;
            }
            long curr=Long.parseLong(num.substring(pivot,i+1));
            if(pivot == 0){
                helper(num, target, i + 1, curr, curr, path + curr);
            }else{ //We have three cases
                //+ case
                helper(num, target, i + 1, calc + curr, +curr, path + "+" + curr);
                //- case
                helper(num, target, i + 1, calc - curr, -curr, path + "-" + curr);
                //* case
                helper(num, target, i + 1, calc - tail + tail * curr, tail * curr, path + "*" + curr);
            }
        }
        
    }
}
