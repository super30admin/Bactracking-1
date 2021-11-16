class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        helper(result, target, num, 0, 0, new StringBuilder(), 0);
        return result;
    }

    public void helper(List<String> result, int target, String num, int index, long currentVal, StringBuilder currentEqn, long tail){
        if(index==num.length()){
            if(currentVal == target)
                result.add(currentEqn.toString());
            return;
        }
        long number;
        int size;
        for(int i=index;i<num.length();i++){
            number = Long.parseLong(num.substring(index,i+1));
            if(index!=0){
                size = currentEqn.length();
                currentEqn = currentEqn.append('*');
                currentEqn = currentEqn.append(number);
                helper(result, target, num, i+1, currentVal - tail + (tail*number), currentEqn, tail*number);
                currentEqn.setCharAt(size, '+');
                helper(result, target, num, i+1, currentVal + number, currentEqn, number);
                currentEqn.setCharAt(size, '-');
                helper(result, target, num, i+1, currentVal - number, currentEqn, -1*number);
                currentEqn = currentEqn.delete(size, currentEqn.length());
            }
            else{
                size = currentEqn.length();
                currentEqn = currentEqn.append(number);
                helper(result, target, num, i+1, number, currentEqn, number);
                currentEqn = currentEqn.delete(size,currentEqn.length());
            }
            if(num.charAt(index)=='0')
                break;
        }
    }
}