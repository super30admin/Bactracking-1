//Combination Sum
//Time Complexity = Exponential
//Space Complexity = Exponential


class Solution {
List<List<Integer>> result;
public List<List<Integer>> combinationSum(int[] candidates, int target) {
result = new ArrayList();
if(candidates == null) {
return result;
}
helper(candidates, target, 0,new ArrayList<Integer>());
return result;
}

    private void helper(int[] candidates, int target,int pivot,List path) {
        if(target < 0) {
            return;
        }
        if(target == 0) {
            result.add(new ArrayList(path));
            return;
        }

        for(int i = pivot; i < candidates.length; i++) {
            path.add(candidates[i]);
            helper(candidates, target - candidates[i], i, path);
            path.remove(path.size() - 1);
        }

    }

}


//Expression Add Operators
//Time Complexity = Exponential
//Space Complexity = Exponential

class Solution {
List<String> result;
public List<String> addOperators(String num, int target) {
result = new ArrayList<>();

        helper(num, target, 0, 0, 0, new StringBuilder());
        return result;
    }
    private void helper(String num, int target, int index, long calc, long tail,StringBuilder sb) {
        //base
        if(index == num.length()) {
            if(calc == target) {
                result.add(sb.toString());
            }
            return;
        }
        //logic
        for(int i = index; i < num.length(); i++) {
            if(num.charAt(index) == '0' && i != index) {
                break;
            }
            Long current = Long.parseLong(num.substring(index, i+1));
            int len = sb.toString().length();
            if(index == 0) {
                sb.append(current);
                helper(num, target, i + 1, current, current, sb);
                sb.setLength(len);
            } else {
                //+
                sb.append("+");
                sb.append(current);
                helper(num, target, i + 1,calc + current, current, sb);
                sb.setLength(len);
                //-
                sb.append("-");
                sb.append(current);
                helper(num, target, i + 1,calc - current, -current, sb);
                sb.setLength(len);
                //*
                sb.append("*");
                sb.append(current);
                helper(num, target, i + 1,calc - tail + tail * current, tail * current, sb);
                sb.setLength(len);
            }

        }
    }

}