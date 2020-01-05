/**
LeetCode Submitted : YES
Space Complexity : O(1)
Time Complexity : O(3^length of String)


The idea is to recursively call 3 operators at each decision in the recursion tree (+,-,*). Once * is encountered backtrack the calcuated value using PEDMAS rule such that parent of parent node is multiplied first and then perform with old operator. Also, we need to handle scenarios of in betwween zeros seperately. 
**/
class Solution {
    List<String> results = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        if(num == null || num.length() < 1)
            return results;
        
        addOperatorsBackTrack(num,"",0,0L,target,0L,0L);
        return results;
    }
    
    private void addOperatorsBackTrack(String num,String path, int index, long current, int target,long calculated, long tail){
        if(index == num.length())
        {
            if(calculated == target)
                results.add(path);
            return;
        }
        
            for(int i = index; i<num.length();i++){
                if(index != i && num.charAt(index) == '0')
                     break;
                
                current = Long.parseLong(num.substring(index,i+1));
                
                if(index == 0)
                    addOperatorsBackTrack(num,path + current, i+1, current, target, current, current);  
                else{
                    addOperatorsBackTrack(num,path + "+" + current,i+1,current,target,calculated + current,current);
                    addOperatorsBackTrack(num,path + "-" + current,i+1,current,target,calculated - current,-current);
                    addOperatorsBackTrack(num,path + "*" + current,i+1,current,target,(calculated - tail) + current * tail,current*tail);    
                }    
            }
                 
        }
    }
