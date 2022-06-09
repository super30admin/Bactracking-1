//time - O(3^n)
//space - O(n)
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        helper(num, target, 0, 0, 0, "", result);
        return result;
    }
    private void helper(String num, int target, long calc, long tail, int idx, String path, List<String> result){
        
      if(idx == num.length()){
            if(calc == target){
                result.add(path);
            }
            return;
        }
        for(int i=idx; i<num.length(); i++){
          
            long curr = Long.parseLong(num.substring(idx,i+1));
            if(num.charAt(idx)=='0' && idx!=i) continue;
            if(idx==0){
                helper(num, target, curr, curr, i+1, path+curr, result);
            }else{
            helper(num, target, calc+curr, curr, i+1, path+ "+" + curr, result);
            helper(num, target, calc-curr, -curr, i+1, path+ "-" + curr, result);
            helper(num, target, calc-tail + tail*curr, tail*curr, i+1, path+ "*" + curr, result);
            }


            
        }
    }
}