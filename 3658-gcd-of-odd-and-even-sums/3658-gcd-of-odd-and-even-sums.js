/**
 * @param {number} n
 * @return {number}
 */
 function gcd(num1,num2){
    while(num2>0){
        let temp=num2;
        num2=num1%num2;
        num1=temp;
    }
    return num1;
 }
var gcdOfOddEvenSums = function(n) {
    let sumOdd=0;
    let sumEven=0;
    let k=1;
    for(let i=0;i<n;i++){
        sumOdd=sumOdd+k;
        k=k+2;
    }
    k=2;
    for(let i=0;i<n;i++){
        sumEven=sumEven+k;
        k=k+2;
    }
    return gcd(sumOdd,sumEven);
};