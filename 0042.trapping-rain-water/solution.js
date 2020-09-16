/**
 * Determines the amount of water trapped.
 * @param {number[]} height - List of heights
 * @return {number} - The number of water units trapped.
 */
function trap(height) {
  let water = 0;
  let left = 0;
  let leftMax = 0;
  let right = height.length - 1;
  let rightMax = 0;

  while (left < right) {
    const leftHeight = height[left];
    const rightHeight = height[right];

    /* 
    We know a "bucket" will be formed when there is a left wall, a right
    wall, and the current point we're looking at is less than
    min(leftWall, rightWall). To search for these "buckets", we work from the
    outside in. We use two pointers which we swap between (left, right), to
    keep track of the current index we're looking at. We also keep track of
    the maxLeft seen, and maxRight seen (representing the walls). When we have
    found a "bucket" scenario, we know that the current columns water
    contribution will be limited by min(leftWall, rightWall) because water
    cannot be trapped if it overflows over the wall. The contribution will be
    the max possible it could fill (up to min(leftWall, rightWall)), minus the
    "filled" portion (current height) of the current position.
    */

    // The water area depends on min(leftHeight, rightHeight).
    if (leftHeight < rightHeight) {
      if (leftHeight > leftMax) {
        leftMax = leftHeight;
      } else {
        water += leftMax - leftHeight;
      }
      left++;
    } else {
      if (rightHeight > rightMax) {
        rightMax = rightHeight;
      } else {
        water += rightMax - rightHeight;
      }
      right--;
    }
  }

  return water;
}

(function run() {
  let tests = [
    {
      input: [0,1,0,2,1,0,1,3,2,1,2,1],
      output: 6
    },
    {
      input: [3, 2, 0, 0, 1, 2, 3],
      output: 10
    },
    {
      input: [3, 2, 0, 0, 5, 0, 0, 2, 3],
      output: 14
    },
    {
      input: [4, 3, 3, 9, 3, 0, 9, 2, 8, 3],
      output: 23
    },
    {
      input: [9, 6, 8, 8, 5, 6, 3],
      output: 3
    }
  ];

  tests.forEach(test => {
    console.log('running test...');
    const result = trap(test.input);
    const passed = result === test.output;
    console.log(`result: ${result}`);
    console.log(`test passed: ${passed}\n`);
  });
})();