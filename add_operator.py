class Solution:
    result = ""
    def addOperators(self, num: str, target: int) -> List[str]:

        if len(num) == 0 or num == None:
            return result

        self.result = []
        self.helper(num , 0 , target , 0,0,"")

        return self.result
    
    def helper(self , num , index , target , calc , tail , path):

        #base
        if index == len(num):
            if calc == target:
                self.result.append(path)
            
            return

        #logic
        for i in range(index,len(num)):
            if num[index] == '0' and index != i:
                continue
            current = num[index:i+1]
            curr = int(current)
            if index == 0:
                self.helper(num , i + 1 , target , curr , curr ,path + str(curr) )
            
            else:
                # + case
                self.helper(num , i + 1 , target , calc + curr , +curr , path + "+" + str(curr))

                # - case
                self.helper(num , i + 1 , target , calc - curr , -curr , path + "-" + str(curr))

                # * case

                self.helper(num , i+1 , target , calc - tail + tail * curr , tail * curr , path +"*"+str(curr))
            
            #backtracking step

           
            

