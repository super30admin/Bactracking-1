//Time Complexity - O(4^n)
// Space Complexity- O(n)

class Solution {
  int targ;
  List<String> result;
    public List<String> addOperators(String num, int target) {
      targ = target;
      result = new ArrayList<>();
      helper(num, 0, 0l, 0l, "");
      return result;
        
    }
  private void helper(String num,int index, Long calcVal, Long tail, String path) {
    //base case
    if(index == num.length()) {
      if(calcVal == targ) {
        result.add(path);
        return;
      }
    }
    
    //logic
    for(int i = index; i< num.length(); i++) {
      //precceding 0 case
      if(num.charAt(index) == '0' && index != i) continue;
      long curr = Long.parseLong(num.substring(index, i+1));
      //root
      if(index==0) {
        helper(num, i+1, curr, curr, path+curr);
      } else {
        // + case
         helper(num, i+1, calcVal+curr, curr, path+"+"+curr);
        // - case
         helper(num, i+1, calcVal-curr, -curr, path+"-"+curr);
        // * case
        helper(num, i+1, calcVal-tail+tail*curr, tail*curr, path+"*"+curr);
      }
    }
    
  }
}