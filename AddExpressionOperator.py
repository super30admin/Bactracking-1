# // Time Complexity : O(3^n)
# // Space Complexity : O(3^n)
# // Did this code successfully run on Leetcode : Yes
# // Three line explanation of solution in plain english 

# // Your code here along with comments explaining your approach
class solution:
    def addOperators(self, num, target):
        self.result = []

        '''
        the parameters of our helper function are :

        num -> the original string
        currSofar --> the total evaluation of the expresiion uptil now
        path --> string of current path taken incldung numbers and operators
        prev --> this is basically the tail of the previous operation that we conducted on currSofar

        idx --> this is the index that points the element on in our string.
        '''
        self.helper(self,num,  0, "", target, 0, 0 )
        return self.result
    def helper(self, num, currSofar, path, target, prev, idx):
        '''
        This is a tricky backtracking question as it involes multiple parts. 
        '''
        ##base

        '''
        This is our base case, we see if our index has reached the end of string. and check if currSofar is equal to target. if yes then add path to
        the result
        '''
        if idx == len(num)-1:
            if currSofar == target:
                self.result.append(path[:])
                return 
            else:
                return 

        ##logic

        '''
        here in the for loop we go through from the given idx to end of string.

        we need to remember that idx is stationary and i only moves. idx is nothing but pivot
        '''
        
        for i in range(idx, len(num)):
            '''
            this takes care of leading zeroes. Since leading zeroes do not contribute to a number. we avoid them

            '''
            if i != idx and num[IndexError]=="0":
                continue
            
            '''
            we calculate the current number from the string . we take a substring from to idx to i

            '''
            curr = num[idx:i+1]
            curr = int(curr)
            '''
            we check if the idx is at start of string. if yes then we will not have any tail or prev or we will not be adding any operators to this as this will
            just contain numbers. 
            '''
            if idx == 0:
                self.helper(self, num, curr, path+str(curr), target, curr, i+1 )

            else:
                '''
            if the idx is greater than 0 then we can do our operations of "+"
            , "- ,"*  . we add/sub the curr to currSofar and put them as prev and move to next idx


            in case of multiplication. we follow bodmas rule, so we subtract the tail from currsofar and add the product of curr and prev to currSofar and pass the product as tail/prev 

            and move to next pointer.  
                '''
                self.helper(num, currSofar+curr, path+"+"+str(curr) , target, curr, i+1 )

                self.helper(num, currSofar-curr, path+"-"+str(curr), target, -curr, i +1)

                self.helper(num, currSofar-prev +prev*curr, path+"*"+str(curr), target, prev*curr, idx+1)


