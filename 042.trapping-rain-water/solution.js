/**
 * Determines the amount of water trapped.
 * @param {number[]} height - List of heights
 * @return {number} - The number of water units trapped.
 */
function trap(height) {
  for (let i = 2; i < height.length; i++) {
    
  }
}

(function run() {
  let tests = [
    {
      input: [0,1,0,2,1,0,1,3,2,1,2,1],
      output: 6
    }
  ];

  tests.forEach(test => {
    console.log('running test...');
    const result = trap(test.input);
    const passed = result === test.output;
    console.log(`test passed: ${passed}`);
  });
})();