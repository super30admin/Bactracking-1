/*
    approach: for loop based recursion
    - We need to output all possible expressions using ALL nums in num string that result into target
    - The only operators we have to try are '+','-','*'
    - Which also means we need make 3 recursive calls for EACH ith substr we have formed.
    - How do we form all the expressions?
        - For loop based recursion.
        - We will have a start idx that will be passed into the initial recursive call
        - And our for loop starts from that start idx until it reaches the end of num string
        - If need to form '1', '12', '123' from the given '123' string,
            - we can create substr using str[startIdx:i] -- i keeps moving and start stays where it is (ex: at idx 0) - so that works well in our favor
        - But we need to form expressions...
        - For each ith element, we need to test out and form 3 expressions with '+','-','*' (i.e 3 recursive calls)
        - However when start == 0, our path will be "", we do not have any expressions to append 
        - we only append when start != 0 ( in other words, the last char in our path is a valid digit )
    - What are all the parameters we need to pass down in the recursive call ?
        - the start idx of our for loop
        - expression path string (ex: '1+2+3')
        - calculated value (ex: 6 -- computed value of above expression)
        - tail - What is this? why? read inside "How do we maintain and enforce PEMDAS operator precedence?"
            - keep in mind when start == 0, the tail will be the same as currNum ( i.e calc value )
    - How do we maintain and enforce PEMDAS operator precedence?
        - If we have 1+2x3 - our program will solve this as 9 - which is incorrect, the correct answer is 6 -- (3x2) + 1
        - How do we enforce PEMDAS?
        - Thats what the tail parameter is for
        - The tail int value will hold whatever to calc value at a current node in the tree
        - for example; if we we had calc val as 1, and the new current number is 2 and we are adding them ( 1+2 ), 
            - calc = 1
            - tail = 1
            - new calc = 1+2 = 3
            - new tail = 2
            - then our tail will hold whatever we JUST did to get the new calc value ( i.e +2)
        - for example; if we we had calc val as 1, and the new current number is 2 and we are subtracting them ( 1-2 ) 
            - calc = 1
            - tail = 1
            - new calc = 1-2 = -1
            - new tail = -2
            - then our tail will hold whatever we JUST did to get the new calc value ( i.e -2)
            
        - for example; if we we had calc val as 1, and the new current number is 2 and we are multiplying them ( 1x2 )
            - calc = 1
            - tail = 1
            - new calc = 1x2 = 2
                - The actual formula for calc val on multiplication is:
                    - calc-tail+(tail*currStrNum)
                    - 1-1 + (1*2)
                    - 0 + 2 = 2
            - new tail = 2
                - The actual format for new tial on multiplication is:
                    - tail*currentStrNum
                    - 1*2 = 2
        
    - What evaluates whether this expression works or not?
        - base condition will check whether we have used all numbers or not (start == len(str))
            and that the calc value == target
            - if yes, save the path string into our result var
    - What do we need to backtrack? 
        - Nothing in golang ( techincally need to backtrack the path string expression )
        - Golang passes by value, so recursion will have its own NEW path string in memory and will not be a shared array in memory
        - if we used strings.Builder in golang, there is not a method to remove the last character in strings.Builder :sad-face
    
    - Edge case:
        - If startIdx != i, and value at startIdx == 0, we need to continue or else our path string to int conversion will remove the preceding 0
        - 1 0 5
            s i
        - the substring we form is using s[start:i+1]
        - this will create "05"
        - but converting this to an int will result into just 5
    
    time: o(n*3^Len(num))
    space: o(n)

*/
func addOperators(num string, target int) []string {
    
    var result []string
    
    var dfs func(path string, start, calc, tail int)
    dfs = func(path string, start, calc, tail int) {
        // base
        if start == len(num) && calc == target {
            result = append(result, path)
            return
        }
        
        for i := start; i < len(num); i++ {
            if string(num[start]) == "0" && start != i {continue}
            currStr := string(num[start:i+1])
            currStrNum, _ := strconv.Atoi(currStr)
            if start == 0 {
                dfs(path+currStr, i+1, currStrNum, currStrNum)
            } else {
                dfs(path+"+"+currStr, i+1, calc+currStrNum,currStrNum)
                dfs(path+"-"+currStr, i+1, calc-currStrNum,-currStrNum)
                dfs(path+"*"+currStr, i+1, calc-tail+(tail*currStrNum), tail*currStrNum)
            }
        }
    }
    dfs("", 0,0,0)
    return result
}
