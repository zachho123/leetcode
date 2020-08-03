/**
 * Returns the index of the target.
 * @description This version does not account for duplicates in the array.
 * @param {number[]} nums - Potentially rotated sorted array to search.
 * @param {number} target - Value to search for.
 */
function search(nums, target) {
    let start = 0;
    let end = nums.length - 1;

    if (nums.length === 0) {
        return -1;
    }

    while (start <= end) {
        let mid = Math.floor((start + end) / 2);

        if (nums[mid] === target) {
            return mid;
        }

        // If front half is sorted
        if (nums[start] <= nums[mid]) {
            if (target >= nums[start] && target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        } else {
            if (target > nums[mid] && target <= nums[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }

    return -1;
}

(function runTests() {
    let tests = [
        {
            input: {
                nums: [4, 5, 6, 7, 0, 1, 2], // size 7
                target: 0
            },
            output: 4
        },
        {
            input: {
                nums: [7, 8, 1, 2, 3, 4, 5, 6], // size 8
                target: 2
            },
            output: 3
        },
        {
            input: {
                nums: [4, 5, 6, 7, 0, 1, 2],
                target: 3
            },
            output: -1
        },
        {
            input: {
                nums: [2, 3, 4, 5, 6, 7, 0, 1], // size 8
                target: 3
            },
            output: 1
        },
        {
            input: {
                nums: [2, 0, 1], // size 3
                target: 2
            },
            output: 0
        },
        {
            input: {
                nums: [1, 2],
                target: 1
            },
            output: 0
        },
        {
            input: {
                nums: [3, 1],
                target: 1
            },
            output: 1
        }
    ];

    tests.forEach(test => {
        const result = search(test.input.nums, test.input.target);
        const passed = result === test.output;

        console.log(`Ran test... test passed : ${passed}`);
        console.log(`Expected: ${test.output}, Got: ${result}\n`);
    });
})();