/**
 * Counts the number of distinct islands.
 * @description An island is surrounded by ocean, and is formed by connecting
 * adjacent (vertical/horizontal) lands. It is assumed all four edged of the
 * input grid are surrounded by water.
 * @param {string[][]} grid - Input grid of 1's (land) and 0's (ocean).
 * @returns {number} The number of islands in the grid.
 */
function numIslands(grid) {
    let numIslands = 0;

    for (let row = 0; row < grid.length; row++) {
        for (let col = 0; col < grid[0].length; col++) {
            if (grid[row][col] === '1') {
                numIslands++;
                clearIsland(grid, row, col);
            }
        }
    }

    return numIslands;
}

function clearIsland(grid, row, col) {
    if (row >= 0 && row < grid.length &&
        col >= 0 && col < grid[0].length) {
        if (grid[row][col] === '1') {
            grid[row][col] = '0';
            clearIsland(grid, row-1, col); // check up
            clearIsland(grid, row, col-1); // check left
            clearIsland(grid, row, col+1); // check right
            clearIsland(grid, row+1, col); // check down
        }
    }
}

(function runTests() {
    let tests = [
        {
            grid: [
                '11110'.split(''),
                '11010'.split(''),
                '11000'.split(''),
                '00000'.split(''),
            ],
            expected: 1
        },
        {
            grid: [
                '11000'.split(''),
                '11000'.split(''),
                '00100'.split(''),
                '00011'.split(''),
            ],
            expected: 3
        }
    ];

    tests.forEach( (test) => {
        let result = numIslands(test.grid);
        let testPassed = result === test.expected ? 'Passed' : 'Failed';

        console.log(`Running test... - ${testPassed}`);
        console.log(`Expected: ${test.expected}, Got: ${result}`);
    });
})();