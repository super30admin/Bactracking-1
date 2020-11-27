var addOperators = function(num, target) {
    let paths = [];

    let generatePaths = (curr, num, pos, runningEval, prevEval) => {
        if(curr == num.length){
            if(runningEval == target){
                paths.push(curr);
            }
            return;
        }
        let currNum = 0;
        for(let i = pos; i < num.length; i++){
            if(i !==  pos && num[pos]) break;
            num = num * 10 + parseInt(num[i]);

            if(pos === 0){
                generatePaths(curr + currNum, num, i + 1, currNum, currNum);
            } else {
                generatePaths(curr + "+" + currNum, num, i + 1, runningEval + currNum, currNum)
                generatePaths(curr + "-" + currNum, num, i + 1, runningEval + currNum, currNum)

                generatePaths(curr + "*" + currNum, num, i + 1, runningEval - prevEval + prevEval * currNum, prevEval * currNum)
            }
        }
        
    }

    if(num === null || num.length === 0) return paths;
    generatePaths("", num, 0, 0, 0);
    return paths;
};