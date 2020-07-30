/**
 * ============
 * Problem:
 * ============
 * Find sum of unique characters for every substring of a given input
 * string. Unique characters are defined as those which only appear once for 
 * any given substring.
 * 
 * ============
 * Answer:
 * ============
 * The trick here is instead of thinking individually about the # of unique
 * characters in each substring, let's think about how much each letter position
 * in the input string contributes to the end sum.
 * --------------
 * For Example:
 * --------------
 * Say we had string 'AXAXXAX'
 * Let's focus on the 2nd 'A' that appears (at index 2) and see how we can 
 * create substrings which have that 'A' as unique.
 * 
 * We can take 'A(XA)XXAX' and between '()' is our substring
 * 
 * We can see, to have the 2nd 'A' counted as a unique letter:
 * 1. we need to insert '(' somewhere between the 1st and 2nd 'A'
 * 2. we need to insert ')' somewhere between the 2nd and 3rd 'A'
 * 
 * For restriction 1, we have 2 possibilities
 * For restriction 2, we have 3 possibilities
 * 
 * Therefore, we have 2 * 3 = 6 ways to make a substring where the 2nd 'A' is 
 * a unique character, ie: the 2nd 'A' (index 2) contributes +6 uniqueness 
 * count to the final sum.
 * 
 * Following this, we can perform this at each position in the input string,
 * and sum the individual contributions to get the desired final sum.
 */

/**
 * Finds the sum of unique characters for every substring of the input string.
 * @param {string} s - The input string.
 * @returns {number} The sum of unique characters per substring % (10 ^ 9 + 7);
 */
function uniqueLetterString(s) {
    const moduloNumber = Math.pow(10, 7) + 7;
    let sum = 0;

    // Populate a map with keys = chars that appear in input string, and
    // values = arrays containing the indices where that char appears
    let charPosMap = new Map();
    for (let i = 0; i < s.length; i++) {
        const currChar = s.charAt(i);
        if (charPosMap.has(currChar)) {
            charPosMap.get(currChar).push(i);
        } else {
            charPosMap.set(currChar, [i]);
        }
    }

    // For every character, at each position it appears, calc the unique char
    // contribution.
    charPosMap.forEach( (charPosArr) => {
        for (let i = 0; i < charPosArr.length; i++) {
            // Left is the last occurence of the current char, or -1 if
            // there is none
            let left = i > 0 ? charPosArr[i-1] : -1;
            // Right is the next occurence of the current char, or the input
            // string length if there is none
            let right = i < charPosArr.length - 1 ? charPosArr[i+1] : s.length;
            sum += ((charPosArr[i] - left) * (right - charPosArr[i])) % moduloNumber;
        }
    });

    return sum;
}

(function runTests() {
    const tests = [
        { s: 'A', expected: 1 },
        { s: 'AB', expected: 4 },
        { s: 'ABC', expected: 10 },
        { s: 'AAAB', expected: 8 },
        { s: 'ABA', expected: 8 },
        { s: 'LEETCODE', expected: 92 },
    ];

    console.log('RUNNING uniqueLetterString() TESTS...');

    tests.forEach( (test) => {
        console.log(`Running test: ${test.s}...`);

        let result = uniqueLetterString(test.s);
        let testPassed = result === test.expected ? 'Passed' : 'False';

        console.log(`\t${testPassed} - Expected: ${test.expected}, Got: ${result}`);
    });

    console.log();
})();