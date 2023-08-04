#Time:
#Space:
#did the code run successfully? yes
#issues faced: when the starting digit of the substring is 0, issue is faced with leading zeroes
# dont form substrings with leading zero
#Approach:
#using 2 for loops, one for substring of digits starting with 1st digit as candidates
#another for the 3 operators as candidates, through recursion, compute the value when the end is reached an compare it with the target
# backtrack when a candidate solution is obtained

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        result = []
        def backtrack(num, candidate):
            idx = 2 if int(num[0])==0 else len(num)+1
            for end in range(1, idx):
                candidate.append(num[:end]) #place candidate
                if end < len(num):
                    for op in ["+", "-", "*"]:
                        candidate.append(op) #place candidate
                        backtrack(num[end:], candidate) #backtrack
                        candidate.pop() #remove candidate
                else:
                    if eval("".join(candidate)) == target:
                        result.append("".join(candidate))
                candidate.pop() #remove candidate

        backtrack(num, [])
        return result