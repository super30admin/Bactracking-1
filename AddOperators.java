/*
The time complexity is O(3^N) and the space complexity is O(N);

Yes, the code passed all the test cases in leetcode.
 */
class Solution {
    public List<String> addOperators(String num, int target) {

        List<String> res = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        expressions(res,num,sb,target,0,0,0);
        return res;
    }

    public void expressions(List<String> retList,String str,StringBuilder res,int target,long lastresolved,long presum,int start){
        if(start==str.length()){
            if(presum==target){
                retList.add(new String(res));
            }
            return;
        }

        for(int i=start;i<str.length();i++){

            if(str.charAt(start)=='0' && i!=start){break;}
            Long currVal = Long.parseLong(str.substring(start,i+1));
            int length = res.length();
            if(start==0){
                expressions(retList,str,res.append(currVal),target,currVal,currVal,i+1);
                res.setLength(length);
            }
            else{
                expressions(retList,str,res.append("+").append(currVal),target,currVal,presum+currVal,i+1);
                res.setLength(length);
                expressions(retList,str,res.append("-").append(currVal),target,-currVal,presum-currVal,i+1);
                res.setLength(length);                                                  expressions(retList,str,res.append("*").append(currVal),target,lastresolved*currVal,presum-lastresolved+lastresolved*currVal,i+1);
                res.setLength(length);
            }

        }
    }
}