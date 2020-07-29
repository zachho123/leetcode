/**
 * Finds the biggest island and returns its area.
 * @description An island is a group of 1's (representing land) connected
 * 4-directionally (horizontal/vertical).
 * @param {number[][]} grid - Non-empty 2D array of 0's and 1's
 * @returns {number} The area of the maximum area island.
 */
function maxAreaOfIsland(grid) {
    let maxArea = 0;

    for (let row = 0; row < grid.length; row++) {
        for (let col = 0; col < grid[0].length; col++) {
            maxArea = Math.max(maxArea, dfs(grid, row, col));
        }
    }

    return maxArea;
}

function dfs(grid, row, col) {
    let maxArea = 0;

    // If node is island (1), mark node as visited (0 - ocean)
    if (grid[row][col] === 1) {
        maxArea++;
        grid[row][col] = 0;

        // Check up
        if (row > 0) {
            maxArea += dfs(grid, row-1, col);
        }
        
        // Check down
        if (row < grid.length - 1) {
            maxArea += dfs(grid, row+1, col);
        }

        // Check left
        if (col > 0) {
            maxArea += dfs(grid, row, col-1);
        }

        // Check right
        if (col < grid[0].length - 1) {
            maxArea += dfs(grid, row, col+1);
        }
    }

    return maxArea;
}

(function runTests() {
    const tests = [
        { gridString: '0', expected: 0 },
        { gridString: '01,10', expected: 1 },
        { gridString: '0101,0101,0011', expected: 4 }
    ];

    const leetcodeTest = [
        [0,0,1,0,0,0,0,1,0,0,0,0,0],
        [0,0,0,0,0,0,0,1,1,1,0,0,0],
        [0,1,1,0,1,0,0,0,0,0,0,0,0],
        [0,1,0,0,1,1,0,0,1,0,1,0,0],
        [0,1,0,0,1,1,0,0,1,1,1,0,0],
        [0,0,0,0,0,0,0,0,0,0,1,0,0],
        [0,0,0,0,0,0,0,1,1,1,0,0,0],
        [0,0,0,0,0,0,0,1,1,0,0,0,0]
    ];

    // Run my test cases
    tests.forEach((test) => {
        const rowStrings = test.gridString.split(',');
        const grid = [];

        rowStrings.forEach( (rowString) => {
            const newRow = [];
            for (let i = 0; i < rowString.length; i++) {
                newRow.push(Number(rowString.charAt(i)));
            }
            grid.push(newRow);
        });

        const result = maxAreaOfIsland(grid);
        const testPassed = result === test.expected ? 'Passed' : 'Failed';

        console.log(`Running test... ${grid} - ${testPassed}`);
        console.log(`\tExpected: ${test.expected}, Got: ${result}\n`);
    });

    // Run leetcode provided test case
    console.log(`Running leetcode testcase...`);
    console.log(`Expected: 6, Got: ${maxAreaOfIsland(leetcodeTest)}`);
})();