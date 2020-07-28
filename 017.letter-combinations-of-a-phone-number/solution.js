/***
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 
 * Given a string containing digits from 2-9 inclusive, return all possible 
 * letter combinations that the number could represent.
 * 
 * Mappings given:
 * 2: a, b, c
 * 3: d, e, f
 * 4: g, h, i
 * 5: j, k, l
 * 6: m, n, o
 * 7: p, q, r, s
 * 8: t, u, v
 * 9: w, x, y, z
 */

/**
 * Returns all possible letter combinations based on input digits.
 * @param {string} digits String containing digits 2-9 inclusive (no spaces).
 * @return {string[]} All possible letter combinations the numbers could 
 *     represent.
 */
let letterCombinations = function(digits) {
    // Digit to letter mappings
    const letterMappings = {
        '2': 'abc'.split(''),
        '3': 'def'.split(''),
        '4': 'ghi'.split(''),
        '5': 'jkl'.split(''),
        '6': 'mno'.split(''),
        '7': 'pqrs'.split(''),
        '8': 'tuv'.split(''),
        '9': 'wxyz'.split('')
    };

    let result = [];

    if (digits === null || digits === undefined || digits.length < 1) {
        return result;
    } else if (digits.length === 1) {
        return letterMappings[digits.charAt(0)];
    } else {
        // Generate letter combinations for digit string minus the last digit
        let prefixes = letterCombinations(digits.substring(0, digits.length - 1));
        // Grab reference to digit -> letter mapping for "next" digit
        let nextLetterMap = letterMappings[digits.charAt(digits.length - 1)];
        for (let i = 0; i < prefixes.length; i++) {
            for (let j = 0; j < nextLetterMap.length; j++) {
                result.push(prefixes[i].concat(nextLetterMap[j]));
            }
        }
    }

    return result;
};

/**
 * Runs all test cases for letterCombinations() and prints the results to 
 * console.
 */
let runTests = () => {
    let testCases = [
        "2",
        "23",
        "27",
        "78",
        "234",
        "2345"
    ];

    testCases.forEach(testCase => {
        console.log(`Running test for input: "${testCase}"`);
        console.log(`Output: ${letterCombinations(testCase)}\n`);
    });
};

runTests();