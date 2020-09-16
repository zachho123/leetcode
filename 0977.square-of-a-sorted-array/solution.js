/**
 * Returns an array of the squares of each number in A, in increasing order.
 * @param {number[]} A - Array of integers in increasing order.
 * @returns {number[]} Array of squares in increasing order.
 */
function sortedSquares(A) {
    // Easy solution O(N log N)
    // return A.map( (n) => Math.pow(n, 2)).sort( (a, b) => a - b);

    // Better O(N) solution using 2 pointers
    let ans = [];
    // Create two pointers, one will iterate over positive numbers, one will
    // iterate over negative numbers
    let pos = 0;
    while (pos < A.length && A[pos] < 0) {
        pos++;
    }
    let neg = pos - 1;

    // While there are both positive and negative numbers left, we must compare
    // which square is smaller to add to our sorted output array
    while (pos < A.length && neg >= 0) {
        if (A[pos] * A[pos] < A[neg] * A[neg]) {
            ans.push(A[pos] * A[pos]);
            pos++;
        } else {
            ans.push(A[neg] * A[neg]);
            neg--;
        }
    }

    // Once we know only positive or negative numbers are left, one of these
    // while loops will run and finish out the input array.
    while (neg >= 0) {
        ans.push(A[neg] * A[neg]);
        neg--;
    }

    while (pos < A.length) {
        ans.push(A[pos] * A[pos]);
        pos++;
    }

    return ans;
}

function runTests() {
    const tests = [
        [-4, -1, 0, 3, 10],
        [0, 1, 9, 16, 100]
    ];

    tests.forEach(test => {
        console.log(sortedSquares(test));
    });
}

runTests();