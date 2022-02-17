// Time Complexity : O(2^n)
// Space Complexity :O(2^n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// DFS : take case of the zero case as index and i are not same and s.charAt(index) == 0 then continue; else find the curr value in int, if the index == 0; the pass all cal and tail the curr value, for - set cal = cal-curr, tail = -curr; same for +, for * : cal = cal-tail+tail*curr , tail = tail*curr, and put size and curr to the sb, at the end set the to previous length.

// Your code here along with comments explaining your approach
// using backtrack
class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        dfs(num, target, 0, 0, 0, new StringBuilder());
        return result;
    }
    private void dfs(String num, int target, int index, long cal, long tail, StringBuilder sb){
        // base
        if(num.length() == index){
            if(cal == target){
                result.add(sb.toString());
            }
            return;
        }
        // logic
        for(int i = index; i < num.length(); i++){
            if( i != index && num.charAt(index) == '0') continue;
            long curr = Long.parseLong(num.substring(index, i+1));
            int len = sb.toString().length();
            if(index == 0){
                sb.append(curr);
                dfs(num, target, i+1, curr, curr, sb);
                sb.setLength(len);
            }else{
                // +
                sb.append("+");
                sb.append(curr);
                dfs(num, target, i+1, cal+curr, curr, sb);
                sb.setLength(len);
                // -
                sb.append("-");
                sb.append(curr);
                dfs(num, target, i+1, cal-curr, -curr, sb);
                sb.setLength(len);
                // *
                sb.append("*");
                sb.append(curr);
                dfs(num, target, i+1, cal-tail+tail*curr, tail*curr, sb);
                sb.setLength(len);
            }
        }
    }
}

// using backtrack
// class Solution {
//     List<String> result;
//     public List<String> addOperators(String num, int target) {
//         result = new ArrayList<>();
//         dfs(num, target, 0,0,0,"");
//         return result;
//     }
//     private void dfs(String num, int target, int index, long cal, long tail, String res){
//         // base
//         if(index == num.length()){
//             if(cal == target){
//                 result.add(res);
//             }
//         }
//         // logic
//         for(int i = index; i < num.length(); i++){
//             if( i != index && num.charAt(index) == '0') continue;
//             long curr = Long.parseLong(num.substring(index, i+1));
//             if(index == 0){
//                 dfs(num, target, i+1 ,curr, curr, res+curr);
//             }else{
//                 // +
//                 dfs(num, target, i+1, cal+curr, curr, res+"+"+curr);
//                 // -
//                 dfs(num, target, i+1, cal-curr, -curr, res+"-"+curr);
//                 // *
//                 dfs(num, target, i+1, cal-tail+tail*curr, tail*curr, res+"*"+curr);
//             }
//         }
//     }
// }
