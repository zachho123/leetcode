/*
https://leetcode.com/problems/majority-element/

Given an array of size n, find the majority element. The majority element is
the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always
exist in the array.
*/

let majorityElement = function(nums) {
  let majorityNum = Math.floor(nums.length / 2);
  let map = new Map();
  let result;

  for (let i = 0; i < nums.length; i++) {
    let curr = nums[i];
    let count = map.get(curr) !== undefined ? map.get(curr) + 1 : 1;

    if (count > majorityNum) {
      result = curr;
      break;
    }

    map.set(curr, count);
  }

  return result;
};

console.log(majorityElement([3, 2, 3])); // 3
console.log(majorityElement([2, 2, 1, 1, 1, 2 , 2])); // 2
console.log(majorityElement([1])); // 1


// Elegant solution, just sort the array and take the num at n/2 index.
// Bc the majority must show up more than n/2 times in the array, n/2 index
// is guaranteed to be the answer.

/*
let majorityElement = function(nums) {
  nums.sort((a,b) => a-b);
  return nums[Math.floor(nums.length/2)];
}
*/