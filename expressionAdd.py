#Recursive solution
#Complexities: exponential
result = list()
targ = 0
def addOperators(num,target):

    if len(num) == 0 or num is None:
        return result
    targ = target
    helper(num,"",0,0,0)
    return result

def helper(num,path,calc,tail,index):
    if(index==len(num)):
        if calc == targ:
            result.add(path)
        return
    for i in range(index,len(num)):
        curr = num[index:i+1]
        if i == 0:
            helper(num,path+curr,curr,curr,i+1)
        else:
            helper(num,path+"+"+curr,calc+curr,curr,i+1)
            helper(num,path+"-"+curr,calc+curr,int(curr),i+1)
            helper(num,path+"*"+curr,calc-tail+tail*curr,tail*curr,i+1)
st = "123"
targ = 6
addOperators(st,targ)