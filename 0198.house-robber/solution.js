/*
https://leetcode.com/problems/house-robber/

You are a professional robber planning to rob houses along a street. Each house
has a certain amount of money stashed, the only constraint stopping you from
robbing each of them is that adjacent house have security system connected and
it will automatically contact the police if two adjacent houses were broken into
in the same night.

Given a list of non-negative integers representing the amount of money of each
house, determine the maximum amount of money you can rob tonight without
alerting the police.
*/

/**
 * 
 * @param {number[]} nums
 * @return {number} 
 */
let rob = function(nums) {
    let max = 0;

    for (let i = 0; i < nums.length; i++) {
        if (i === 0 || i === 1) {
            max = Math.max(max, nums[i]);
        } else {
            max = Math.max(nums[i-2] + nums[i], nums[i-1]);
        }

        nums[i] = max;
    }
    
    return max;
}

let test = [
    [1], // 1
    [1, 2], // 2
    [2, 1], // 2
    [2, 1, 2, 1, 2], // 6
    [1, 2, 1, 2, 1], // 4
    [1, 2, 5, 1], // 6
    [1, 2, 5, 7, 8], // 14
    [2, 1, 1, 2], // 4
    [2, 1, 1, 1, 2] // 5
];

test.forEach(nums => {
    console.log(rob(nums));
});