/**
 * Returns the maximum possible profit of buying/selling stock given stock
 * prices over an interval (Each day you can only perform 1 action, buy or sell
 * one share of the stock).
 * @param {number[]} prices 
 * @return {number}
 */
function maxProfit(prices) {
  let min = prices[0];
  let maxProfit = 0;

  for (let i = 1; i < prices.length; i++) {
    if (prices[i] < min) {
      min = prices[i];
    } else if (prices[i] - min > maxProfit) {
      maxProfit = prices[i] - min;
    }
  }

  return maxProfit;
}

(function run() {
  const tests = [
    {
      input: [7, 1, 5, 3, 6, 4],
      output: 5
    },
    {
      input: [7, 6, 4, 3, 1],
      output: 0
    }
  ];

  tests.forEach(test => {
    console.log('\nrunning test');
    const result = maxProfit(test.input);
    const passed = result === test.output;
    console.log(`test passed : ${passed}`);
  });
})();