/*
https://leetcode.com/problems/power-of-three/

Given an integer, write a function to determine if it is a power of three.
*/

let isPowerOfThree = function(n) {
    if (n < 1) {
        return false;
    }

    while (n % 3 === 0) {
        n /= 3;
    }

    return n === 1;
};

let test = [27, 0, 9, 45, 1];
test.forEach(num => {
    console.log(isPowerOfThree(num));
});