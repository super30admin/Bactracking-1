/**
 Time: exponential - O(n^n) n- length of the input string num
 Space: O(n)
 **/
class Solution {
    List<String> res;
    public List<String> addOperators(String num, int target) {
        res = new ArrayList<>();
        helper(num,target,"",0,0,0);
        return res;
    }
    public void helper(String num, int target, String str, long total, long tail, int index){
        //base
        if(index == num.length()){
            if(total == target)
                res.add(new String(str));
            return;
        }

        for(int i=index; i<num.length();i++){
            Long no = Long.valueOf(num.substring(index,i+1));

            if(i!=index && num.charAt(index) == '0') return;

            if(index == 0){
                str = new String(Long.toString(no));
                helper(num,target,str,no,no,i+1);
            }else{

                // StringBuilder s = new StringBuilder(str);
                helper(num,target,str+"+"+no,total+no,no,i+1);
                // str = s;
                helper(num,target,str+"-"+no,total-no,-no,i+1);
                // str = s;
                helper(num,target,str+"*"+no,(total-tail)+(tail*no),tail*no,i+1);
                // str = s;
                //helper(num,target,str.append("/"+no),total+no,no,i+1);
            }

        }

    }
}