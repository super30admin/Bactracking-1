//Time complexity: O(N * 4^N)
//Space complexity: O(N)
class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helperMethod(num, target, new StringBuilder(), 0, 0, 0);
        return result;
    }
    
    public void helperMethod(String num, int target, StringBuilder sb, long cal, long tail, int index)      {
        //base
        if(index == num.length()) {
            if(cal == target) {
                result.add(sb.toString());
            }
            return;
        }
        //logic
        for(int i = index; i < num.length(); i++) {
            
            if(num.charAt(index) == '0' && i != index) continue;
            long current = Long.parseLong(num.substring(index, i + 1));
            int len = sb.toString().length();
            if(index == 0) {
                sb.append(current);
                helperMethod(num, target, sb, current, current, i + 1);
                //backtrack
                sb.setLength(len);
            }
            else {
                //+
                sb.append("+");
                sb.append(current);
                helperMethod(num, target, sb, cal + current, current, i + 1);
                sb.setLength(len);
                //-
                sb.append("-");
                sb.append(current);
                helperMethod(num, target, sb, cal - current, -current, i + 1);
                sb.setLength(len);
                
                //*
                sb.append("*");
                sb.append(current);
                helperMethod(num, target, sb, cal - tail + tail * current, tail * current, i + 1);
                sb.setLength(len);
            }
            
        }
    }
}