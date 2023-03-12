class Solution {
    List<String> result = new ArrayList<>();
    int targ;
    public List<String> addOperators(String num, int target) {
        this.targ = target;
        if(num == null || num.length() == 0) {
            return result;
        }
        helper(num, "", 0, 0, 0);
        return result;
    }
    private void helper(String num, String path, long calc, long tail, int index) {
        // base
        if(index == num.length()){
            if(targ == calc){
                result.add(path);
            }
            return;
        }
        // logic
        for(int i = index; i < num.length(); i++){
            if(num.charAt(index) == '0' && index != i) break;
            long curr = Long.parseLong(num.substring(index, i + 1));
            if(index == 0){
                helper(num, path + curr, curr, curr, i + 1);
            } else {
                helper(num, path + "+" + curr, calc + curr, curr, i + 1);
                helper(num, path + "-" + curr, calc - curr, -curr, i + 1);
                helper(num, path + "*" + curr, calc - tail + tail * curr, tail * curr, i + 1);
            }
        }
    }
}