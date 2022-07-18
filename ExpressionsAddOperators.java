import java.util.ArrayList;
import java.util.List;


//Time Complexity=O(4^L)
//Space Complexity=O(n)
public class ExpressionsAddOperators {

    List<String> li;
    public List<String> addOperators(String num, int target) {

        li=new ArrayList<>();

        helper(num,0,0,0,target,new StringBuilder());

        return li;
    }

    private void helper(String num,long cal,long tail,int idx,int target,StringBuilder path){
        //base
        if(idx==num.length()){
            if(cal==target){
                li.add(new StringBuilder(path).toString());
                return;
            }
        }

        //logic
        for(int i=idx;i<num.length();i++){
            long curr=Long.parseLong(num.substring(idx,i+1));

            //preceding zero
            if(i!=idx && num.charAt(idx)=='0') continue;
            int l=path.length();
            if(idx==0){
                //Action
                path.append(curr);
                //Recurse
                helper(num,curr,curr,i+1,target,path);

                //Backtrack
                path.setLength(l);
            }else{
                //+
                //Action
                path.append("+");
                path.append(curr);

                //Recurse
                helper(num,cal+curr,curr,i+1,target,path);

                //BackTrack
                path.setLength(l);

                //-
                path.append("-");
                path.append(curr);
                helper(num,cal-curr,-curr,i+1,target,path);
                path.setLength(l);

                //*
                path.append("*");
                path.append(curr);
                helper(num,cal-tail+tail*curr,tail*curr,i+1,target,path);
                path.setLength(l);
            }
        }
    }
}
