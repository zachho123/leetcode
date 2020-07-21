/*
https://leetcode.com/problems/3sum/

Given an array nums of n integers, are there elements a, b, c in nums such that
a + b + c = 0? Find all unique triplets in the array which gives the sum
of zero.

The solution set must not contain duplicate triplets.
*/

/**
 * Finds all unique triplets in nums which sum to 0.
 * @param {number[]} nums
 * @return {number[][]}
 */
let threeSum = function(nums) {
    let seen = [];
    let sets = [];

    for (let i = 0; i < nums.length; i++) {
        let twosums = twoSum(seen, 0 - nums[i]);
        if (twosums.length > 0) {
            twosums.forEach(twoset => {
                let tempset = [nums[i], twoset[0], twoset[1]];
                tempset.sort();
                if (isUnique(sets, tempset)) {
                    sets.push(tempset);
                }
            });
        }

        seen.push(nums[i]);
    }

    return sets;
};

let twoSum = function(nums, target) {
    let seen = [];
    let sets = [];

    for (let i = 0; i < nums.length; i++) {
        if (seen.includes(target - nums[i])) {
            sets.push([nums[i], target - nums[i]]);
        }
        
        seen.push(nums[i]);        
    }

    return sets;
};

let isUnique = function(set, toAdd) {
    for (let i = 0; i < set.length; i++) {
        let arr = set[i];
        for (let j = 0; j <= arr.length; j++) {
            if (j === arr.length) {
                return false;
            }
            if (toAdd[j] !== arr[j]) {
                break;
            }
        }
    }

    return true;
};

// three sum test
let test2 = [
    [-1, 0, 1, 2, -1, -4] // [-1, 0, 1], [-1, -1, 2]
];

test2.forEach(nums => {
    console.log('input: ' + nums);
    let result = threeSum(nums);
    console.log('output: ');
    result.forEach(set => {
        console.log(set);
    });
});