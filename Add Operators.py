class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        output = []
        def helper(value, prev, curr, path, index):
            if index == len(num):
                if value == target and curr == 0:
                    output.append("".join(path[1:]))
            else:
                #for all operations except NOOP, curr = 0, so only current value at index considered
                curr = curr*10 + int(num[index])
                currString = str(curr)
                
                #edge case where you do not do NOOP if it is zero
                if curr>0:
                    helper(value,prev ,curr, path, index+1)
                
                #addition
                path.append("+")
                path.append(currString)
                helper(value+curr, +curr, 0, path, index+1)
                path.pop()
                path.pop()
            
                #you need something to be there to do these ops
                if path:
                    path.append("-")
                    path.append(currString)
                    helper(value-curr, -curr, 0, path, index+1)
                    path.pop()
                    path.pop()
                    
                    path.append("*")
                    path.append(currString)
                    #catch -> prev is prev*curr and not -prev+prev*curr cus if another * comes after this, prev => prev*curr
                    helper(value-prev + prev*curr, prev*curr, 0, path, index+1)
                    path.pop()
                    path.pop()
            return output
        return helper(0, 0, 0, [], 0)

    #Time = 4^N possible paths, each path if valid we join in O(N) time => (4^N)*N
    #Space =  O(N)

                
                
            