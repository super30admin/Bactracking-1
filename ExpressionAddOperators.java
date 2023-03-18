
// brute force
public class ExpressionAddOperators {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num,0,0,0,"",target);
        return result;
    }
    private void helper(String num, int pivot, long calc, long tail, String path,int target){
        // base
        if(pivot==num.length()&&calc==target){
            result.add(path);
            return;
        }

        // logic
        for(int i=pivot;i<num.length();i++){
            // preceeding 0
            if(num.charAt(pivot)=='0' && i!=pivot) continue;
            long curr = Long.parseLong(num.substring(pivot, i+1));
            if(pivot==0){
                helper(num,i+1,curr,curr,path+curr,target);
            }else{
                // +
                helper(num,i+1, calc+curr, +curr, path+ "+" +curr, target);
                // -
                helper(num,i+1, calc-curr, -curr, path+ "-" +curr, target);
                // *
                helper(num,i+1, calc-tail+tail*curr, tail*curr, path+ "*" +curr, target);
            }
        }
    }
}

// TC - O(n*3 power n)
// SC - exponential


// backtracking - using stringbuilder to avoid creating new string everytime
public class ExpressionAddOperators {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num,0,0,0,new StringBuilder(),target);
        return result;
    }
    private void helper(String num, int pivot, long calc, long tail, StringBuilder path,int target){
        // base
        if(pivot==num.length()&&calc==target){
            result.add(path.toString());
            return;
        }

        // logic
        for(int i=pivot;i<num.length();i++){
            // preceeding 0
            if(num.charAt(pivot)=='0' && i!=pivot) continue;
            long curr = Long.parseLong(num.substring(pivot, i+1));
            // initial path length before backtracking
            int le = path.length();
            if(pivot==0){
                // action
                path.append(curr);
                // recurse
                helper(num,i+1,curr,curr,path,target);
                // backtrack
                path.setLength(le);
            }else{
                // +
                // action
                path.append('+');
                path.append(curr);
                // recurse
                helper(num,i+1, calc+curr, +curr, path, target);
                // backtrack
                path.setLength(le);
                // -
                // action
                path.append('-');
                path.append(curr);
                // recurse
                helper(num,i+1, calc-curr, -curr, path, target);
                // backtrack
                path.setLength(le);
                // *
                // action
                path.append('*');
                path.append(curr);
                // recurse
                helper(num,i+1, calc-tail+tail*curr, tail*curr, path, target);
                // backtrack
                path.setLength(le);
            }
        }
    }
}

// TC - O(n*3 power n)
// SC - exponential