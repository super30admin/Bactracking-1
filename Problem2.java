//accepted on LT
//Perform for loop based recursion with backtracking
class Solution {
    List<String> sf = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        helper(num,target,new StringBuilder(),0,0,0);
        return sf;
        
    }
    public void helper(String num,int target,StringBuilder path,int pivot,long cal,long tail){
        //BASE
        if(pivot==num.length()){
             if(cal==target){
                sf.add(path.toString());
                
            }
            return;
        }
       
        //FOR Loop
        for(int i =pivot;i<num.length();i++ ){
            int plength = path.length();
            if(num.charAt(pivot)=='0' && pivot != i) continue;
            long curr = Long.parseLong(num.substring(pivot,i+1));
            if(pivot==0){
                path.append(curr);
                helper(num,target,path,i+1,curr,curr);
                path.setLength(plength);
            }
            else{
                //+
                //action
                path.append("+");
                path.append(curr);

                //recurse
                
               
                helper(num,target,path,i+1,cal+curr,curr);
                //bct
                path.setLength(plength);

                //-
                path.append("-");
                path.append(curr);
                helper(num,target,path,i+1,cal-curr,-curr);
                path.setLength(plength);

                //*
                path.append("*");
                path.append(curr);
                helper(num,target,path,i+1,cal-tail+tail*curr,tail*curr);

                //bctrack
                path.setLength(plength);
            }
            

        }
    }
}