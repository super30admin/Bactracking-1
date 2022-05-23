# O(n x 4^n) time: .join operators takes O(n), where n is length of expression, and at each step we consider 4 recursive paths so O(4^n)
# O(n) space, O(n) for intermediate and list and O(n) for recursion stack

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        N = len(num)
        answers = []
        
        def recurse(index, prevOp, currOp, value, string):
            # done processing all digits in num
            if index == N:
                if value == target and currOp == 0: # if final value == target expected AND no op is left unprocessed
                    answers.append("".join(string[1:]))
                return
            
            # extending current op by one digit
            currOp = currOp * 10 + int(num[index])
            strOp = str(currOp)
            
            # to avoid cases where we have 1 + 01 or 1 *01 since 01 won't be valid operand
            if currOp > 0:
                recurse(index + 1, prevOp, currOp, value, string)
            
            # ADD
            string.append('+'); string.append(strOp)
            recurse(index + 1, currOp, 0, value + currOp, string)
            string.pop();string.pop()
            
            # subtract or multiplay - only if prev operands
            if string:
                # SUB
                string.append('-'); string.append(strOp)
                recurse(index + 1, -currOp, 0, value - currOp, string)
                string.pop();string.pop()
                
                # MULT
                string.append('*'); string.append(strOp)
                recurse(index + 1, currOp * prevOp, 0, value - prevOp + (currOp * prevOp), string)
                string.pop();string.pop()
                
        recurse(0, 0, 0, 0, [])
        return answers