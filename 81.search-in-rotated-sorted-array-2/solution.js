/**
 * Checks for value in array.
 * @param {number[]} nums - Array of integers which may include duplicates.
 * @param {number} target - Integer to search for.
 * @returns {boolean} Returns true if target is found, otherwise returns false.
 */
function search(nums, target) {
    let start = 0;
    let end = nums.length - 1;

    while (start <= end) {
        // Use this form to calc mid to avoid overflow
        let mid = Math.floor((start + (end - start) / 2);

        if (target === nums[mid]) {
            return true;
        }

        if (nums[start] < nums[mid]) { // left part sorted
            if (target >= nums[start] && target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        } else if (nums[start] > nums[mid]) { // right part sorted
            if (target > nums[mid] && target <= nums[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        } else {
            end--;
        }
    }

    return false;
}

(function runTests() {
    let tests = [
        {
            input: {
                nums: [],
                target: 0
            },
            output: false
        },
        {
            input: {
                nums: [1],
                target: 1
            },
            output: true
        },
        {
            input: {
                nums: [1, 2],
                target: 2
            },
            output: true
        },
        {
            input: {
                nums: [2,5,6,0,0,1,2],
                target: 0
            },
            output: true
        },
        {
            input: {
                nums: [2,5,6,0,0,1,2],
                target: 3
            },
            output: false
        },
        {
            input: {
                nums: [1,3,1,1,1],
                target: 3
            },
            output: true
        }
    ];

    tests.forEach(test => {
        const result = search(test.input.nums, test.input.target);
        const passed = test.output === result ? 'PASSED' : 'FAILED';
        console.log(`${passed} - Expected: ${test.output}, Got: ${result}\n`);
    })
})();