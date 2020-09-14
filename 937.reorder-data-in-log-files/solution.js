/**
 * Reorders logs such that letter-logs come before digit-logs.
 * @param {string[]} logs - Array of logs (space delimited string of words).
 * @return {string[]} - Returns ordered logs.
 */
function reorderLogFiles(logs) {
  let ordered = [];
  let digitLogs = [];

  for (let i = 0; i < logs.length; i++) {
    const curr = logs[i];
    const idIndex = curr.indexOf(' ');
    const contentStart = curr.charAt(idIndex + 1);

    if (contentStart >= '0' && contentStart <= '9') {
      digitLogs.push(curr);
    } else {
      ordered.push(curr);
    }
  }

  ordered.sort(compareLetterLogs);
  digitLogs.forEach(log => {
    ordered.push(log);
  });

  return ordered;
}

/**
 * Compares two tokenized letter logs
 * @param {string[]} l1 - Tokenized letter log array
 * @param {string[]} l2 - Tokenized letter log array
 * @return {number} - Returns -1 if the first log is lexographically less than 
 * the second log. Returns 1 if the first log is greater, else return 0 if they
 * are equal.
 */
function compareLetterLogs(l1, l2) {
  const idIndex1 = l1.indexOf(' ');
  const idIndex2 = l2.indexOf(' ');
  // Log 1 identifier and content
  const id1 = l1.substring(0, idIndex1);
  const content1 = l1.substring(idIndex1+1);
  // Log 2 identifier and content
  const id2 = l2.substring(0, idIndex2);
  const content2 = l2.substring(idIndex2+1);

  // If the content is equal, compare identifers
  if (content1 === content2) {
    if (id1 === id2) {
      return 0;
    } else {
      return id1 < id2 ? -1 : 1;
    }
  } else {
    return content1 < content2 ? -1 : 1;
  }
}

(function run() {
  let tests = [
    {
      input: [
        'dig1 8 1 5 1',
        'let1 art can',
        'dig2 3 6',
        'let2 own kit dig',
        'let3 art zero'
      ],
      output: [
        'let1 art can',
        'let3 art zero',
        'let2 own kit dig',
        'dig1 8 1 5 1',
        'dig2 3 6'
      ]
    }
  ];

  tests.forEach(test => {
    console.log('running test...');
    const results = reorderLogFiles(test.input);
    const passed = test.output.every((val, index) => {
      return val === results[index];
    });
    console.log(`test passed: ${passed}`);
  });
})();