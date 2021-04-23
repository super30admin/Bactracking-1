// Time Complexity : O(n.2^n) where n is the length of the string (worst case where all letters are the same)
// Space Complexity : O(n) where n is the length of the string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
class PalindromePartition {
    public List<List<String>> result ; 
    public List<List<String>> partition(String s) {
        result = new ArrayList();
        if(s == null || s.length()==0) return result;
        backtrack(s, new ArrayList(), 0);
        return result;
    }
    
    private void backtrack(String s, List<String> path, int idx){
        if(idx == s.length()){
            result.add(new ArrayList(path));
        }
        for(int i=idx;i<s.length();i++){
            String str = s.substring(idx,i+1);
            if(isPalindrome(str)){
                path.add(str);
                backtrack(s, path,i+1);
                path.remove(path.size() -1);
            }
        }
    }
    
    private boolean isPalindrome(String s){
        int lo=0, hi=s.length()-1;
        while(lo<hi){
            if(s.charAt(lo++) != s.charAt(hi--)) return false;
        }
        return true;
    }
}