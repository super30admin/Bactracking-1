//Time Complexity: O(n^n)
//Space complexity:O(maximum length of answer)
//Approach: we used backtracking in this problem

class Solution {
    public List<String> addOperators(String num, int target) {
        
        backtracking(num,0,target,0,0,"");
        return output;
    }
    
    private List<String> output = new ArrayList<>();
    
    private void backtracking(String num,int index,int target,long prevSum,long prevAddition,String exp){
        if(index>=num.length()){
            if(prevSum==target){
                output.add(exp);
            }
        }
        
        for(int i=index;i<num.length();i++){
            Long currElem = Long.parseLong(num.substring(index,i+1));
            if(num.charAt(index)=='0'&&i!=index){
                continue;
            }
            
            if(index==0){
                backtracking(num,i+1,target,prevSum+currElem,currElem,exp+currElem);
            }else{
                backtracking(num,i+1,target,prevSum + currElem,currElem,exp+"+"+currElem);
                
                backtracking(num,i+1,target,prevSum - currElem,currElem*-1,exp+"-"+currElem);
                
                backtracking(num,i+1,target,prevSum - prevAddition+prevAddition*currElem,prevAddition*currElem,exp+"*"+currElem);
            }
        }
        
        
    }
}
