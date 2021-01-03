// Backtrack
// Time - O(exp)
// Space - O(exp)

class Solution {
    List<String> result;
    
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<String>();    
        if(num == null || num.length() == 0) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        helper(num, target, sb, 0, 0, 0);
        
        return result;
    }
    
    private void helper(String num, int target, StringBuilder sb, long tail, int index, long calc) {
        if(index == num.length()) {
            if(target == calc) {
                result.add(sb.toString());
            }
            return;
        }
        for(int i=index;i<num.length();i++) {
            if(num.charAt(index) == '0' && index != i) {
                continue;
            }
            Long curr = Long.parseLong(num.substring(index, i+1));
            int len = sb.length();
            
            if(index == 0) {
                sb.append(curr);
                helper(num, target, sb,  curr, i + 1, curr);                    
                sb.setLength(len);
            }
            else {
                sb.append('+');
                sb.append(curr);
                helper(num, target, sb,  curr, i + 1,  calc + curr);
                sb.setLength(len);
                
                sb.append('-');
                sb.append(curr);
                helper(num, target, sb,  -curr, i + 1,  calc - curr);
                sb.setLength(len);
                
                sb.append('*');
                sb.append(curr);
                helper(num, target, sb,  tail * curr, i + 1,  calc - tail + tail * curr);                
                sb.setLength(len);
                
            }

        }
        
    }
}
// Recursion

// Time - O(exp)
// Space - O(exp)

class Solution {
    List<String> result;
    
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<String>();    
        if(num == null || num.length() == 0) {
            return result;
        }
        
        helper(num, target, "", 0, 0, 0);
        
        return result;
    }
    
    private void helper(String num, int target, String path, long tail, int index, long calc) {
        if(index == num.length()) {
            if(target == calc) {
                result.add(path);
            }
            return;
        }
        for(int i=index;i<num.length();i++) {
            if(num.charAt(index) == '0' && index != i) {
                continue;
            }
            Long curr = Long.parseLong(num.substring(index, i+1));
            if(index == 0) {
                helper(num, target, path + curr,  curr, i + 1, curr);                    
            }
            else {
                helper(num, target, path + '+' + curr,  curr, i + 1,  calc + curr);
                helper(num, target, path + '-' + curr,  -curr, i + 1,  calc - curr);
                helper(num, target, path + '*' + curr,  tail * curr, i + 1,  calc - tail + tail * curr);
                
            }

        }
        
    }
}
