
class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num,"",0,0,0,target);
        return result;

    }
    private void helper(String num,String path, int index,long cal, long tail, int target){

        if(index == num.length()){
                if(cal == target){
                    result.add(path);
                    return;
                }
                }
        //logic

        for(int i = index; i<num.length();i++){
            if(i != index && num.charAt(index) == '0') continue;
            long curr = Long.parseLong(num.substring(index,i+1));
            if(index == 0){
                helper(num,path+curr,i+1,curr,curr,target);
            }else{
                //+
                helper(num, path + "+" + curr,i+1,cal + curr,curr,target);
                //-
                helper(num, path + "-" + curr,i+1,cal - curr,-curr,target);
                //*
                helper(num, path + "*" + curr,i+1,cal - tail+(tail * curr),tail*curr,target);
            }
        }
    }
}