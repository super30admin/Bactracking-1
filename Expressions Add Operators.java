//  Time Complexity: O(4^n) if we use string then O(n * 4^n)
//  Space Complexity: O(n) if we use string then O(n * 4^n)
class Solution {

    List<String> result;
    public List<String> addOperators(String num, int target) {
        this.result = new ArrayList<>();
        helper(num, target, 0, new StringBuilder(), 0, 0);
        return result;
    }

    private void helper(String num, int target, int pivot, StringBuilder path, long calc, long tail){
        // base
        // System.out.println("pivot " + pivot + " " +path); 
        if(pivot == num.length() && calc == target){
            result.add(new String(path));
        }


        // logic
        for(int i=pivot; i< num.length(); i++){

            if(i != pivot && num.charAt(pivot) == '0') continue;
            long curr = Long.parseLong(num.substring(pivot, i+1));
            // System.out.println("i = " + i );


            int len = path.length();
            if(pivot == 0){
                path.append(curr);
                helper(num, target, i+1, path, curr, curr);
                path.setLength(len);
            }else{

                // +
                path.append( "+" + curr);
                helper(num, target, i+1, path, calc + curr, curr);
                path.setLength(len);

                // -
                path.append( "-" + curr);
                helper(num, target, i+1, path , calc - curr, -curr);
                path.setLength(len);

                // *
                path.append( "*" + curr);
                helper(num, target, i+1, path, (calc - tail) + (tail * curr) , tail * curr);
                path.setLength(len);

            }
        }
    }
}