//TC : exponential
class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        if(num == null || num.length() == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        helper(num, target, 0, 0, 0, "");
        return result;
        
    }
    private void helper(String num, int target, int index, long calc, long tail, String path){
        //base
        if(index == num.length()) {
            if(calc == target) {
                result.add(path);

            }
        }
        //logic
        for(int i = index; i < num.length(); i++) {
            if(num.charAt(index) == '0' && index != i) {
                continue;
            }
            long curr = Long.parseLong(num.substring(index, i +1));
            if(index == 0) {
                helper(num, target, i +1, curr, curr, path + curr);
            }
            else {
                //+operator
                helper(num, target, i + 1, calc + curr, +curr, path + '+' + curr);
                //-operator
                helper(num, target, i + 1, calc - curr, -curr, path + '-' + curr);
                //* operator
                helper(num, target, i + 1, calc - tail + tail * curr, tail * curr, path + '*' + curr);

            }
        } 
    }
}