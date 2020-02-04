
class Solution {
    List<String> result = new ArrayList<>();
    //main function
    public List<String> addOperators(String num, int target) {
        backtrack("", num, target, 0,0,0);
        return result;
    }
    //recursive call
    private void backtrack(String path, String num, int target, long calculated, long tail, int index){
        //base case
        if(index == num.length()){
            if(calculated == target){
                result.add(path);
            }
        }
        //logic
        for(int i = index; i<num.length(); i++){
            //in case of preceeding 0 -  edge case
            if(i != index && num.charAt(index) == '0') break;
            //current substring
            long curr = Long.parseLong(num.substring(index,i+1));
            if(index == 0){
                backtrack(path + curr, num, target, curr, curr, i+1);
            }
            //for each operator
            else{
                //for add
                backtrack(path + '+' + curr, num, target, calculated+curr, curr, i+1);
                //for substract
                backtrack(path + '-' + curr, num, target, calculated-curr, -curr, i+1);
                //for multiplication
                backtrack(path + '*' + curr, num, target, calculated-tail+tail*curr, tail*curr, i+1);
            }
        }
    }
}