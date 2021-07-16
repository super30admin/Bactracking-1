// Time Complexity : Exponential
// Space Complexity : O(n)

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, target, new StringBuilder(), 0, 0 ,0);
        return result;
    }
    
    private void helper(String num, int target, StringBuilder path, int index, long calSum, long tail){
        //base
        if(index == num.length() && calSum == target){
            result.add(path.toString());
            return;
        }
        //logic
        for(int i = index; i < num.length(); i++){
            if(num.charAt(index) == '0' && i != index)
                continue;
            long cur = Long.parseLong(num.substring(index, i + 1));
            int len = path.toString().length();
            if(index == 0){
                path.append(cur);
                helper(num, target, path, i + 1, cur, cur);
                path.setLength(len);
            }
            else{
                //+
                path.append("+");
                path.append(cur);
                helper(num, target, path, i + 1, calSum + cur, cur);
                path.setLength(len);
                //-
                path.append("-");
                path.append(cur);
                helper(num, target, path, i + 1, calSum - cur, -cur);
                path.setLength(len);
                //*
                path.append("*");
                path.append(cur);
                helper(num, target, path, i + 1, calSum - tail + tail * cur, tail * cur);
                path.setLength(len);
            }
        }
    }
}