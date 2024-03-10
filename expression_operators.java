class Solution {
    List<String> result = new ArrayList<>();
    void recursiveFunction(String num,int pivot, String path, long calc, long tail, int target) {
   //base 
   if(pivot == num.length()) {
       if(target == calc) {
           result.add(path);
       }
       return;
   }

        //logic
        for(int i = pivot; i<num.length();i++) {
            if(num.charAt(pivot) == '0'  && i != pivot ) continue;
            long curr = Long.parseLong(num.substring(pivot,i+1));
            if(pivot == 0) {
                recursiveFunction(num,i+1,path+curr,curr,curr,target);
            } else {
                recursiveFunction(num,i+1,path+ '+' +curr,calc+curr,curr,target);

                recursiveFunction(num,i+1,path+'-' +curr,calc-curr,-curr,target);

                recursiveFunction(num,i+1,path+ '*' +curr,calc-tail+tail*curr,tail*curr,target);
            }
        }
    }
    public List<String> addOperators(String num, int target) {
        recursiveFunction(num, 0,"", 0, 0, target);
        return result;
    }
}