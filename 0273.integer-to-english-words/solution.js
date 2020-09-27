/**
 * Converts a non-negative integer to its english word(s) representation.
 * @param {number} num
 * @return {string}
 */
function numberToWords(num) {
  const LESS_THAN_20 = ['', 'One', 'Two', 'Three', 'Four', 'Five', 'Six',
    'Seven', 'Eight', 'Nine', 'Ten', 'Eleven', 'Twelve', 'Thirteen', 'Fourteen',
    'Fifteen', 'Sixteen', 'Seventeen', 'Eighteen', 'Nineteen'];
  const TENS = ['', 'Ten', 'Twenty', 'Thirty', 'Forty', 'Fifty', 'Sixty',
    'Seventy', 'Eighty', 'Ninety'];
  const THOUSANDS = ['', 'Thousand', 'Million', 'Billion'];

  if (num === 0) {
    return 'Zero';
  }

  let output = '';
  let i = 0; // keeps track of how many magnitudes above 1000 we are

  while (num > 0) {
    if (num % 1000 !== 0) {
      let prefix = helper(num % 1000, LESS_THAN_20, TENS);
      output = `${prefix}${THOUSANDS[i]} ${output}`;
    }
    num = Math.floor(num / 1000);
    i++;
  }
  
  // my initial solution
  // if (num < 100) {
  //   if (num < 20) {
  //     return numWords[num - 1];
  //   } else {
  //     output = `${tens[Math.floor(num / 10) - 2]} ${numberToWords(num % 10)}`;
  //   }
  // } else if (num < 1000) {
  //   output = `${numWords[Math.floor(num / 100) - 1]} Hundred ${numberToWords(num % 100)}`;
  // } else if (num < 1000000) {
  //   output = `${numberToWords(Math.floor(num / 1000))} Thousand ${numberToWords(num % 1000)}`;
  // } else if (num < 1000000000) {
  //   output = `${numberToWords(Math.floor(num / 1000000))} Million ${numberToWords(num % 1000000)}`;
  // } else if (num < 1000000000000) {
  //   output = `${numberToWords(Math.floor(num / 1000000000))} Billion ${numberToWords(num % 1000000000)}`;
  // }

  return output.trim();
}

function helper(num, LESS_THAN_20, TENS) {
  if (num === 0) {
    return '';
  } else if (num < 20) {
    return LESS_THAN_20[num] + " ";
  } else if (num < 100) {
    let suffix = helper(num % 10, LESS_THAN_20, TENS);
    return `${TENS[Math.floor(num / 10)]} ${suffix}`;
  } else {
    let suffix = helper(num % 100, LESS_THAN_20, TENS);
    return `${LESS_THAN_20[Math.floor(num / 100)]} Hundred ${suffix}`;
  }
}

(function run() {
  const tests = [
    {
      input: 0,
      output: 'Zero'
    },
    {
      input: 1,
      output: 'One'
    },
    {
      input: 22,
      output: 'Twenty Two'
    },
    {
      input: 100,
      output: 'One Hundred'
    },
    {
      input: 123,
      output: 'One Hundred Twenty Three'
    },
    {
      input: 12345,
      output: 'Twelve Thousand Three Hundred Forty Five'
    },
    {
      input: 50868,
      output: 'Fifty Thousand Eight Hundred Sixty Eight'
    },
    {
      input: 1234567,
      output: 'One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven'
    },
    {
      input: 1234567891,
      output: 'One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One'
    }
  ];

  tests.forEach(test => {
    console.log('\nrunning test...');
    const result = numberToWords(test.input);
    console.log(result);
    const passed = result.length === test.output.length && result === test.output;
    console.log('test passed: ' + passed);
  });
})();