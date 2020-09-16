/**
 * A string S of lowercase English letters is given. We want to
 * partition this string into as many parts as possible so that each letter
 * appears in at most one part, and return a list of integers representing the
 * size of these parts.
 * @param {string} S - string of lowercase English letters
 * @return {number[]} - size of the partitions
 */
var partitionLabels = function(S) {
  let output = [];
  let n = S.length;
  let map = new Map();

  // Get last occurence for each character that appears
  for (let i = 0; i < n; i++) {
    const currChar = S.charAt(i);
    map.set(currChar, i);
  }

  // Find partition points based on last occurences
  let startIdx = 0;
  let endIdx = 0;

  for (let i = 0; i < n; i++) {
    const currChar = S.charAt(i);
    endIdx = Math.max(endIdx, map.get(currChar));

    if (i === endIdx) {
      output.push(endIdx - startIdx + 1);
      startIdx = endIdx + 1;
    }
  }

  return output;
};