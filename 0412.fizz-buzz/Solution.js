/*
https://leetcode.com/problems/fizz-buzz/

Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output “Fizz” instead of the number and
for the multiples of five output “Buzz”. For numbers which are multiples of
both three and five output “FizzBuzz”.
*/

let fizzBuzz = function(n) {
  let result = [];
  for (let i = 1; i <= n; i++) {
    let three = isMultiple(i, 3);
    let five = isMultiple(i, 5);

    if (five && three) {
      result.push('FizzBuzz');
    } else if (three) {
      result.push('Fizz');
    } else if (five) {
      result.push('Buzz');
    } else {
      result.push(String(i));
    }
  }

  return result;
};

let isMultiple = function(num, multipleOf) {
  if (num >= multipleOf && num % multipleOf === 0) {
    return true;
  }

  return false;
};

fizzBuzz(15).forEach((s) => {
  console.log(s);
});
