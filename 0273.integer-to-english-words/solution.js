/**
 * Converts a non-negative integer to its english word(s) representation.
 * @param {number} num
 * @return {string}
 */
function numberToWords(num) {
  const numWords = ['One', 'Two', 'Three', 'Four', 'Five', 'Six', 'Seven',
    'Eight', 'Nine', 'Ten', 'Eleven', 'Twelve', 'Thirteen', 'Fourteen',
    'Fifteen', 'Sixteen', 'Seventeen', 'Eighteen', 'Nineteen'];
  const tens = ['Twenty', 'Thirty', 'Forty', 'Fifty', 'Sixty', 'Seventy',
  'Eighty', 'Ninety'];
  let output = '';

  if (num === 0) {
    return '';
  }
  
  if (num < 100) {
    if (num < 20) {
      return numWords[num - 1];
    } else {
      output = `${tens[Math.floor(num / 10) - 2]} ${numberToWords(num % 10)}`;
    }
  } else if (num < 1000) {
    output = `${numWords[Math.floor(num / 100) - 1]} Hundred ${numberToWords(num % 100)}`;
  } else if (num < 1000000) {
    output = `${numberToWords(Math.floor(num / 1000))} Thousand ${numberToWords(num % 1000)}`;
  } else if (num < 1000000000) {
    output = `${numberToWords(Math.floor(num / 1000000))} Million ${numberToWords(num % 1000000)}`;
  } else if (num < 1000000000000) {
    output = `${numberToWords(Math.floor(num / 1000000000))} Billion ${numberToWords(num % 1000000000)}`;
  }

  return output.trim();
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
    const passed = result === test.output;
    console.log('test passed: ' + passed);
  });
})();