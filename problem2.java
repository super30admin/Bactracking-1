import java.util.ArrayList;
import java.util.List;

class expressionAddOperators{
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        if(num == null || num.length() == 0) return result;

        helper(num, target, 0, 0, 0, "");
        return result;
    }

    private void helper(String num, int target, long cal, long tail, int index, String path){
        if(index == num.length()){
            if(cal == target){
                result.add(path);
            }
            return;
        }


        for(int i = index; i < num.length();i++){
            if(i != index && num.charAt(index) == '0') continue;
            long curr = Long.parseLong(num.substring(index, i +1));
            if(index == 0){
                helper(num, target, curr, curr, i + 1, path + curr);
            }
            else{
                // +
                helper(num, target, cal + curr, curr, i + 1, path + "+" + curr);
                // -
                helper(num, target, cal - curr, -curr, i + 1, path + "-" + curr);
                //*
                helper(num, target, (cal - tail) + (tail * curr), tail * curr, i + 1, path + "*" + curr);
            }
        }
    }
}

//time complexity O(2^n)
//space complexity O(2^n)