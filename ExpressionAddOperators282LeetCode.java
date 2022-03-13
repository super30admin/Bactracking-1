//Time Complexity: O(n* (4^n)) // n = length of string, at each string we have 4 choices, and stored it in intermediate result, to calculate final result, we need to iterate through intermediate result as well
//Space Complexity: O(n)       //stack size(recursive call size, also, to store intermediate result)
//runs successfully
//didn't face any problems

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators282LeetCode {

        //int index;
        List<String> result;                            //creating result list
        String num;                                     //given string
        int target;                                     //given target

        //operators and when we are getting this operator, we need to pass below prevValue and tail
        //Operator      preValue        Tail
        // +        preValue+num       num
        // -        preValue-num        -num
        // *        preValue-tail       tail* num
        //          + tail * num

        public List<String> addOperators(String num, int target) {

            result = new ArrayList<>();
            this.num = num;
            this.target = target;

            operations(0, 0, 0, new ArrayList<>());         //calling the function

            return result;


        }
        //value holds the value till current recursion sum and tail hold the value of previous operand, and list holds the value of formula of string
        private void operations(int index, long value, long tail, List<String> list){

            //base
            if(index == num.length()){                  //if indeax equals to num.length then


                if(value == target){                    //check if value== target

                    //if so then iterate through list and add element to the stringbuilder and convert it to the string and add to the result list
                    StringBuilder res = new StringBuilder();
                    for(String str:list){
                        res.append(str);
                    }
                    result.add(res.toString());

                }
                return;
            }



            //recurse
            for(int i=index; i<num.length(); i++){              //iterate through num string

                String currentString = num.substring(index, i+1);       //get each character one at a time, after completing one character, we will get 2 character at a time

                if(currentString.length()>=2 && currentString.charAt(0) == '0'){ // check if currentString contain preceding zero, and if so then return
                    break;
                }


                long currentValue = Long.parseLong(currentString);      //convert that string character into long value

                if(index==0){                               //check if we are getting first character in num string

                    list.add(currentString);                //if so, then add it to the list and calling the resursive function
                    operations(i+1, currentValue, currentValue, list);
                    list.remove(list.size()-1);             //backtracking our previous step

                }
                else{

                    //add
                    list.add("+" + currentString);          //if we are not getting first character in nums string, then first we need to check if we get the target value using addition, so for that we need to add "+" and current String into list
                    operations(i+1, value+ currentValue, currentValue, list);   //calling the recursive function with that
                    list.remove(list.size()-1);             //backtracting our previous step


                    //subtract
                    list.add("-"+currentString);        //if we are not getting first character in nums string, then first we need to check if we get the target value using subtraction, so for that we need to add "-" and current String into list
                    operations(i+1, value-currentValue, -currentValue, list); //calling the recursive function
                    list.remove(list.size()-1);        //backtracking our previous step


                    //multiplication
                    list.add("*"+currentString);        //if we are not getting first character in nums string, then first we need to check if we get the target value using multiplication, so for that we need to add "*" and current String into list
                    operations(i+1, value-tail + tail*currentValue, tail*currentValue, list);  //calling the recursive function
                    list.remove(list.size()-1);     //backtracking our previous step

                }

                // if(num.charAt(index) == '0'){
                //     break;
                // }

            }


        }

}
