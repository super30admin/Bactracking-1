//Expression Add operators
// Time complexity = O(4^n)
//Space complexity = O(n)
class Solution {

     List<String> result;
        public List<String> addOperators(String num, int target) {
            this.result = new ArrayList<>();
            helper(num, 0,0,0,target,new StringBuilder());
            return result;
        }
        public void helper(String num, int pivot, long cal, long tail, int target, StringBuilder path){
            //base condition
            if(pivot==num.length()){
                if(target==cal){
                    result.add(path.toString());
                }
                return;
            }
            //LOGIC
            for(int i=pivot; i<num.length(); i++) {
                //Zero preceding then chk if its not pivot
                if(num.charAt(pivot)=='0' && pivot!=i) continue;
                long curr = Long.parseLong(num.substring(pivot, i+1));
                //top level
                int len = path.length();
                if(pivot==0){
                    helper(num, i+1, curr, curr, target, path.append(curr));
                    path.setLength(len);
                }
                else{
                    //+ action
                    path.append('+');
                    path.append(curr);
                    //recurse
                    helper(num, i+1, curr+cal, curr, target, path);
                    //backtrack
                    path.setLength(len);
                    //- exp
                    path.append('-');
                    path.append(curr);
                    helper(num, i+1, cal-curr, -curr, target, path);
                    path.setLength(len);
                    //*exp
                    path.append('*');
                    path.append(curr);
                    helper(num, i+1, cal-tail + tail*curr,curr*tail, target, path);
                    path.setLength(len);
                }
            }

        }
}