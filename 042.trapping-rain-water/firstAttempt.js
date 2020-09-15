/**
 * Determines the amount of water trapped.
 * @param {number[]} height - List of heights
 * @return {number} - The number of water units trapped.
 */
function trap(height) {
  let water = 0;
  // let left = 0;
  let sums = [];

  for (let right = 0; right < height.length; right++) {
    let left = right - 2;
    let leftHeight = height[left];
    const prevHeight = height[right - 1];
    const currHeight = height[right];
    let currSum = 0;

    // Potential "buckets" can only occur starting at position 1
    if (right > 1) {
      // If the previous height is lower than the current height, we have a
      // potential "bucket".
      if (prevHeight < currHeight) {
        // The left wall of the "bucket" should be the first height that is
        // >= currHeight, else max previous height seen.
        let runner = left;
        while (leftHeight < currHeight) {
          if (runner - 1 >= 0) {
            if (height[runner - 1] > leftHeight) {
              left = runner - 1;
            }
            runner--;
            leftHeight = height[left];
            continue;
          }
          break;
        }
        leftHeight = height[left];

        const currSumHeight = Math.min(currHeight, leftHeight);
        const currSumWidth = right - left - 1;
        const filled = sumHeights(height, left + 1, right, currSumHeight);
        const prevCounted = addPrevSums(sums, left + 1, right);

        // console.log('currsumheight ' + currSumHeight);
        // console.log('currsumwidth ' + currSumWidth);
        // console.log('filled ' + filled);
        // console.log('prevcounted ' + prevCounted);

        currSum = (currSumHeight * currSumWidth) - filled - prevCounted;
        // console.log('adding ' + currSum);
        water += currSum;
      }
    }

    sums.push(currSum);
    left = currHeight >= leftHeight ? right : left;
  }

  return water;
}

function sumHeights(height, start, end, limit) {
  let sum = 0;

  for (let i = start; i < end; i++) {
    sum += Math.min(height[i], limit);
  }

  return sum;
}

function addPrevSums(sums, start, end) {
  let sum = 0;

  for (let i = start; i < end; i++) {
    sum += sums[i];
  }

  return sum;
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