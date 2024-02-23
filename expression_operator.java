//Time - O(3^n)
//Space - O(n*k)
class Solution {
    List<String> res = new ArrayList<String>();
    public List<String> addOperators(String num, int target) {
        helper(0,num,new StringBuilder(),target,0,0);
        return res;
    }

    public void helper(int idx, String num, StringBuilder sb, int target, long calc, long tail){
        //base

        if(calc==target && idx==num.length()){
            res.add(sb.toString());
            return;
        }

        //logic
        for(int i=idx;i<num.length();i++){
            if(num.charAt(idx)=='0' && i!=idx){
                continue;
            }
            String s = num.substring(idx,i+1);
            long curr = Long.parseLong(s);
            int l = sb.length();
            if(idx==0){
                sb.append(s);
                helper(i+1,num,sb,target,+curr,+curr);
                sb.setLength(l);
            }
            else{
                //'+'
                sb.append('+');
                sb.append(s);
                helper(i+1,num,sb,target,calc+curr,+curr);
                sb.setLength(l);

                //'-'
                sb.append('-');
                sb.append(s);
                helper(i+1,num,sb,target,calc-curr,-curr);
                sb.setLength(l);

                //'*'
                sb.append('*');
                sb.append(s);
                helper(i+1,num,sb,target,(calc-tail)+(curr*tail),curr*tail);
                sb.setLength(l);
            }
        }
    }
}
