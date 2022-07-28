//Time complexity :exponential
//Space Complexity:exponential
//Twitch interview
//For loop using recursion
//Consider interger as given string and target =6 then use all digits in one side and operators om other side caculated value,expression ,operator based on these 3 things,
//Taking care of zero using for loop recursion.
//1.+  cacl+curr    +curr
//2.-  calc-curr    -curr
//3.*  (calc-tail)+(tail*curr) tail*curr then the result will be the length of the long substring.
class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        if(num == null || num.length() == 0) return result;
        helper(num,target,0,"",0,0);
        return result;
    }
    private void helper(String num,int target,int index,String path,long calc,long tail){
        //base
        if(index == num.length()){
            if(calc == target){
                result.add(path);
            }
            return;
        }
        //logic
        for(int i = index;i<num.length();i++){
            if(index != i && num.charAt(index) == '0')continue;
            long curr = Long.parseLong(num.substring(index,i+1));
            if(index == 0){
                helper(num,target,i+1,path+curr,curr,curr);
            }
            else{
                //+case
                helper(num,target,i+1,path+'+'+curr,calc+curr,curr);
                //-case
                helper(num,target,i+1,path+'-'+curr,calc-curr,-curr);
                //*case
                helper(num,target,i+1,path+'*'+curr,calc - tail + tail * curr,tail*curr);
            }
        }
    }
}