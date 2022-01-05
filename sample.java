// expression add operators
//tc 4^n
//sc n
class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, target, 0, 0, 0, "");
        return result;
    }
    private void helper(String num, int target, long prevNum, long tail, int index, String path){
        
        if(index==num.length()){
            if(prevNum == target){
                result.add(path);
                return;
            }
            return;
        }
        
        for(int i = index; i<num.length(); i++){
            if(num.charAt(index)=='0' && index!=i){
                continue;
            }
            long currNum = Long.parseLong(num.substring(index,i+1));
            if(index==0){
                helper(num, target, prevNum + currNum, currNum, i+1, path + currNum);
            }
            else{
//String num, int target, long prevNum, long tail, int index, String path                
                //+
                helper(num, target, prevNum + currNum, currNum, i+1, path + '+' + currNum);
                
                //-
                helper(num, target, prevNum - currNum, (-1)*currNum, i+1, path + '-' + currNum);
                
                //*
                long newMultiply = (prevNum - tail) + (tail * currNum);
                
                helper(num, target, newMultiply, tail * currNum, i + 1, path + '*' + currNum);
                
            }
        }
        
        
    }
}


// cmbination sum
//tc is n square // sc is n
// class Solution {
//     List<List<Integer>> result;
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         result = new ArrayList<>();
//         helper(new ArrayList<>(),candidates,target,0);
//         return result;
//     }
//     private void helper(List<Integer> currList,int[] candidates, int target, int i){
//         if(i==candidates.length){
//             return;
//         }
//         if(target<0){
//             return;
//         }
//         if(target==0){
//             result.add(new ArrayList<>(currList));
//             return;
//         }
//         // not taken
//         helper(currList,candidates,target,i+1);
        
//         //taken
//         currList.add(candidates[i]);
//         helper(currList,candidates,target-candidates[i],i);
        
//         //backtrack
//         currList.remove(currList.size()-1);
//     }
// }

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(new ArrayList<>(), candidates, target, 0,result);
        return result;
    }
    private void helper(List<Integer> path,int[] candidates, int target, int index, List<List<Integer>> result){
        if(target==0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target<0 || index==candidates.length){
            return;
        }
        for(int i = index; i<candidates.length;i++){
            path.add(candidates[i]); //action
            helper(path,candidates,target-candidates[i],i,result); //recurse
            path.remove(path.size()-1); //backtrack
        }
    }
}
