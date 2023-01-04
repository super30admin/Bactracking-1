// Time Complexity : O(n*3n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
We will recurse over the operands. We will keep on adding the prev into the String and caculate current value with that
*/
class Solution {
    private List<String> result;
    
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<String>();
        helper(num,target,null,null,0,0,new LinkedList<String>());
        return result;
    }
    private void helper(String num, int target ,Integer calc,Integer tail,int pivot,int previous,LinkedList<String> sb){

        //base case
        if(calc!=null && calc == target && pivot == num.length()){ // when we reach the end of the String, we would need to then check if the expression results into target
            if(sb.size()>0){
            
           sb.add(String.valueOf(previous)); // Adding the last operand
            StringBuilder r = new StringBuilder();
            int idx= -1;
            for(String s: sb){
            	idx++;
                if(idx < 2) continue; // we need to skip first two characters, which would be 0 and an op e.g 0 +
                r.append(s);
                
            }

        result.add(r.toString()); // Storing the expression string into the result
            }
        return;
        }

       
        //Action
        sb.add(String.valueOf(previous));
        int prev=0;
        int current =0;
        //logic
        for(int i=pivot;i<num.length();i++){
        	try { // if addition results in overflow, then we need to return
        current = Math.addExact((prev * 10),  Integer.parseInt(String.valueOf(num.charAt(i))));
        }
        catch(ArithmeticException  ex) {
        	// solution further not possible
        	return;
        }

        //choices of operands
        for(int o=0;o<3;o++){ // 0 to 2, 0 = +, 1=-, 2=*
        //if +
        if(o==0){
        	int newCal=0;
        	int nextTail =0;
        	try {
        	
        	if(calc==null) newCal=current;
        	else 
        		{
        		newCal = Math.addExact(calc , current); // if overflow, then skip
        		};
             nextTail = current;
        	}
        	catch(ArithmeticException e) { 
        		continue; // this operation not possible
        	}
            //action
            sb.add("+");
            helper(num,target,newCal,nextTail,i+1,current,sb); //recurse
            sb.removeLast(); //backtrack <- this one removes last digit
            sb.removeLast(); //backtrack <- this one removes the binary operation
            
        }
        //if - 
        else if(o==1){
            int newCal=0;
            if(calc == null) {
            	continue;
            //newCal = current;
            }
            else{
            	try {
                newCal = Math.subtractExact(calc , current);// if overflow, then skip
            	}
            	catch(ArithmeticException e) {
            		continue;// this operation not possible
            	}
            }
            int nextTail = (-1) * current;
            sb.add("-"); //action
            helper(num,target,newCal,nextTail,i+1,current,sb); //recurse
            sb.removeLast();//backtrack <- this one removes last digit
            sb.removeLast();//backtrack <- this one removes the binary operation
        }
        //if *
        else if(o == 2){
            int newCal=0;
            if(calc == null || tail ==null) {
            	continue;
            }
            else{ 
                // we will nullify the previous operation ,as we need to give precedence to the multiplication
            	try {
                newCal = calc - tail + Math.multiplyExact(tail , current);// if overflow, then skip
            	}
            	catch(ArithmeticException e) {
            		continue; // solution not possible
            	}
            }

            int nextTail = (tail * current);
            sb.add("*"); //action
            helper(num,target,newCal,nextTail,i+1,current,sb); //recurse
            sb.removeLast();//backtrack <- this one removes last digit
            sb.removeLast();//backtrack <- this one removes the binary operation
        }
        
       
        }
        // Check for leading zeros
        // if current was 0 , then proceeding further would make it a leading 0 , as question states that it should not contain it, then stop from here
        if(current == 0) {
        	return;
        }
        prev = current;
       
        }
    }
}