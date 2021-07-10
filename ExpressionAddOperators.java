class ExpressionAddOperators{

    //Time complexity -  4 ^ N - 4 choices
    //                       N - sb.tostring()
    //                   O(N*4^N)

    // Space complexity - O(N)
    int targ;
    List<String> result;
    public List<String> addOperators(String num, int target) {
        targ = target;
        result  = new ArrayList<>();
        if(num == null || num.length() == 0) return result;
        helper(num, 0, 0, 0, "");
        return result;
    }

    private void helper(String num, int index, long calc, long tail, String path){
        // base
        if(index == num.length() && calc == targ){
            result.add(path);
            return;
        }


        // logic
        for(int i=index; i< num.length(); i++){
            //if there is preceeding zero to current number then continue
            if(num.charAt(index) == '0' && index != i) continue;

            // cal cur number
            long cur = Long.parseLong(num.substring(index, i + 1));
            if(index == 0){
                // skipping operator
                helper(num, i + 1, cur, cur, path + cur);

            } else {
                // consider operators
                // +
                helper(num, i + 1, calc + cur, cur, path + "+" + cur);
                // -
                helper(num, i + 1, calc - cur, -cur, path + "-" + cur);
                // *
                helper(num, i + 1, calc - tail + tail * cur,  tail * cur, path + "*" + cur);
            }
        }
    }


    // BACTRACK
    int targ;
    List<String> result;
    public List<String> addOperators(String num, int target) {
        targ = target;
        result  = new ArrayList<>();
        if(num == null || num.length() == 0) return result;
        helper(num, 0, 0, 0, new StringBuilder());
        return result;
    }

    private void helper(String num, int index, long calc, long tail, StringBuilder sb){
        // base
        if(index == num.length() && calc == targ){
            result.add(sb.toString());
            return;
        }


        // logic
        for(int i=index; i< num.length(); i++){
            //if there is preceeding zero to current number then continue
            if(num.charAt(index) == '0' && index != i) continue;

            // cal cur number
            long cur = Long.parseLong(num.substring(index, i + 1));
            int len = sb.toString().length();
            if(index == 0){
                // skipping operator
                sb.append(cur);
                helper(num, i + 1, cur, cur, sb);
                sb.setLength(len);

            } else {
                // consider operators
                // +
                sb.append("+");
                sb.append(cur);
                helper(num, i + 1, calc + cur, cur, sb);
                sb.setLength(len);

                // -
                sb.append("-");
                sb.append(cur);
                helper(num, i + 1, calc - cur, -cur, sb);
                sb.setLength(len);

                // *
                sb.append("*");
                sb.append(cur);
                helper(num, i + 1, calc - tail + tail * cur,  tail * cur, sb);
                sb.setLength(len);
            }
        }
    }
}