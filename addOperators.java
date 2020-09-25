    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/expression-add-operators/
    Time Complexity for operators : o(n*4^n) .. n is the length of the string
    Extra Space Complexity for operators : o(n) for (List<String> path) without recursive stack
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. Backtracking
                    A) Call the beacktracking function from main fucntion with initial values.
                    B) The backtracking function will contains input as string num,taregt, answer list, expression,
                       prevSum, prevAddition and index.
                       prevSum - prev sum .. these fields are need when we do multiplication as due to priority.
                       prevAddition - the previous element added.
                    C) Base case, if index >= num.length that means we explored all possibilities for that number.
                    D) In the base case, if prevSum == target then add into the final list.
                    E) In the main backtracking for loop(to get the substring), first add below corner case
                    F)  when we have input as "105" then when first string is. 1 and second substring will be "05"
                            // the Long curr. expression considers it as 5 and not 05. in that case 0 get escaped
                            // inorder to avaoid such condition below expression helps.
                    G)  If I am at index '0' then it is the stating point and pass the initial values.
                    H)  Then, do the backtracking for each expression (+,-,*)
                    I)  (addition -> +) - All values will be same except below three
                            expression - expression + '+' + curr
                            prevSum - sum did in previous iteration
                            prevAddition - addition added in previos iteration
                    J)  (addition -> 1) - All values will be same except below three
                            expression - expression + '1' + curr
                            prevSum - sum did in previous iteration
                            prevAddition - addition added in previos iteration
                    K)  (addition -> *) - All values will be same except below three
                            expression - expression + '*' + curr
                            prevSum - sum did in previous iteration (prevSum - prevAddition + prevAddition*curr)
                            prevAddition - addition added in previos iteration (prevAddition*curr)
    */  

class addOperators {
    public List<String> addOperatorsProblem(String num, int target) {
        List<String> answer = new ArrayList<>();
        
        backtracking(num,target,answer,"",0,0,0);
        
        return answer;
    }
    
    public void backtracking(String num,int target, List<String> answer, String expression, long prevSum, long prevAddition, int index){
        
        // base case
        if(index>=num.length()){
            if(prevSum == target){
                answer.add(expression);
            }
            return;
        }
            
        
        for(int i=index;i<num.length();i++){
            
            //backtracking condition (recursion)
            //int curr = Integer.parseInt(String.valueOf(num.charAt(index)));        
            Long curr = Long.parseLong(num.substring(index,i+1));
            
            // why below line is needed
            // when we have input as "105" then when first string is. 1 and second substring will be "05"
            // the Long curr. expression considers it as 5 and not 05. in that case 0 get escaped
            // inorder to avaoid such condition below expression helps

            if(num.charAt(index) == '0' && i != index){
                continue;
            }
            
            // System.out.println("index: "+index+"i: "+i);

            if(index == 0){
                backtracking(num,target,answer,expression + curr, curr,curr,i + 1);
            }else{
                // +
                backtracking(num,target,answer,expression+'+'+curr, prevSum + curr, curr,i + 1);

                // - check all the previous sum and previous addition conditions properly
                
                backtracking(num,target,answer,expression + '-' + curr, prevSum - curr, curr*-1,i + 1);


                // *
                backtracking(num,target,answer,expression + '*' + curr, prevSum - prevAddition + prevAddition*curr, prevAddition*curr,i + 1);
            }
        }
    }
}