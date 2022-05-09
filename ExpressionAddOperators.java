//time - O(4^n)
//space - O(n)
class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, target, 0, 0, 0, new StringBuilder());
        return result;
    }
    private void helper(String num, int target, long calc, long tail, int index, StringBuilder path){
        //base
        if(index==num.length()){
            if(calc==target){
                StringBuilder sb = path;
                result.add(sb.toString());
            }
            return;
        }

        //logic
        for(int i=index; i<num.length(); i++){
            if(num.charAt(index)=='0' && i!=index) continue;
            long curr = Long.parseLong(num.substring(index, i+1));
            int len = path.length();
            if(index==0){
                path.append(num.substring(index, i+1));
                helper(num, target, curr, curr, i+1, path);
                path.setLength(len);
            }
            else{
                //recurse for '+'
                path.append('+');
                path.append(num.substring(index, i+1));
                helper(num, target, calc+curr, curr, i+1, path);
                path.setLength(len);

                //recurse for '-'
                path.append('-');
                path.append(num.substring(index, i+1));
                helper(num, target, calc-curr, -curr, i+1, path);
                path.setLength(len);

                //recurse for '*'
                path.append('*');
                path.append(num.substring(index, i+1));
                helper(num, target, (calc-tail)+(tail*curr), tail*curr, i+1, path);
                path.setLength(len);
            }
        }
    }
}
