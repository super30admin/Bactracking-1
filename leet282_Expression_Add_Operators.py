# Solution

# // Time Complexity : O(4^n) since in each case we will have 4 options for each number
# // Space Complexity : O(n) implicit stack can go upto the length of the string
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Yes, I initially took an approach where instead of concatenating using the for loop
# I was trying to add one more recursion for the concatenation. I could not figure out how to get final result for that which
# satisfies that leading zero issue. So then I saw that there is no need to use a recursion for concat part, instead we can use the
# for loop itself for that


# // Your code here along with comments explaining your approach
# Approach is we need to consider that we always have to start with first number. Since we cannot skip any number. Now from starting
# number, we have four options. We add,subtract,multiple or concatenate with next number. For add,subtract and multiply we will
# use recursion. And inside the first recursion for loop we will keep concatenating from "pivot" till "i" to form the 4th option.
# Now, we need to remember, as we are concatenating, lets say our case is 1506. 1,15,150,1506 are all valid. When we go into
# recursion for 1, we have 1+5+0, 1-5+0, 1*5+0 which are valid again. But since we are concatenating at each level, 1+5+06
# 1-5+06, 1*5+06 are all invalid because, here 0 becomes dummy and it becomes 1+5+6, 1-5+6, 1*5+6 which means we are not using all
# the elements/numbers of string. So if pivot is starting from 0, we should not consider the concatenated values starting from
# 0.
# Now, to follow BODMAS, everytime we are using multiplication, we need to consider all the values till the previous one as tail
# and do manipulation. Below is an example:
# Let's say scenario is 1+2+3*4*5.
# We would have found 1+2+3 by the time we reached *4. So it will be 6 when we reach 4. Now when I reached 3, while passing + and 3
# I should also keep +3 as tail. Now when I am using * with 4, current value will be 6, but we have tail as +3. So we can use
# 6-(+3)+(+3*4) translated to formula 6-(tail)+(tail*4). This gives us right calculated value for 1+2+3*4 which is 15. 
# And since the recursion was "*" new tail becomes 3*4 = 12. Now again the next recursion is "*5". And current value is 15. So new
# calculated value will be 15-(tail)+(tail*5) which is 15-(12)+(12*5) = 3+60 = 63 the right value using BODMAS rule.
# Again remember newTail = oldTail*multiplire only if we are doing "*". For "+","-" it will always be +multiplier or -multiplier

def addOperators(num, target):
        result = []
        n = len(num)
        helper(num,target,"",0,0,0,result,n)
        return result
    
def helper(num,target,path,tail,pivot,calc,result,n):
    # Edge Case
    if pivot == n:
        if calc == target:
            result.append(path)
        return

    # Logic
    for i in range(pivot,n):
        if num[pivot] == "0" and i != pivot:
            continue
        cur = num[pivot:i+1]
        parsedVal = int(cur)
        if pivot == 0:
            helper(num,target,path+cur,parsedVal,i+1,calc+parsedVal,result,n)
            # return
        else:
            # +
            helper(num,target,path+"+"+cur,parsedVal,i+1,calc+parsedVal,result,n)
            # -
            helper(num,target,path+"-"+cur,-parsedVal,i+1,calc-parsedVal,result,n)
            # *
            helper(num,target,path+"*"+cur,tail*parsedVal,i+1,calc-tail+(tail*parsedVal),result,n)
            # concat
            # self.helper(num,target,path+num[i],parsedVal,i+1,(calc*10) + parsedVal,result,n)

if __name__ == "__main__":
     num = "1506"
     target = 12
     print(addOperators(num, target))
