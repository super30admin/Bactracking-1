//Time complexity:O(N X 4^N)
//Space copmplexity:O(log base 3 (length of string ))
//Ran on leetcode:Yes
//Solution with comments:

class Solution {
    public List<String> addOperators(String num, int target) {
        backtrack(num, target,0, 0,0,"");//starting with index 0
        return output;
    }
    List<String> output= new ArrayList<>();
    
    public void backtrack(String num, int target, int index, long prevSum , long prevElem, String exp){
        
        if(index>=num.length()){//we only check results when we reach end of string
            if(prevSum==target){
                output.add(exp);

            }
            return;
        }

        for(int i=index;i<num.length();i++){
            Long currElem= Long.parseLong(num.substring(index,i+1));// ceate substring at each point so that we also have                                                                                  combination of multiple character
            
            if(num.charAt(index)=='0' && i!=index)
                continue;
            
            if(index==0)
                backtrack(num, target, i+1, currElem, currElem, exp+currElem);//do no operation when we are at starting index
            else{
                //+
                backtrack(num, target, i+1, prevSum+currElem, currElem, exp+"+"+currElem );

                //-
                backtrack(num, target, i+1, prevSum-currElem, currElem*-1, exp+"-"+currElem);

                //*
                backtrack(num, target, i+1 , (prevSum-prevElem)+(currElem*prevElem), prevElem*currElem, exp +"*"+currElem );
            }
            
        }
        
    }
}