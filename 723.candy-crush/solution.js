/**
 * Problem: Implement a basic elimination algorithm for candy crush.
 * 
 * - Given 2-D integer array representing board.
 * - Diff positive integers represent diff types of candy.
 * - Value of 0 indicates empty cell.
 * - Given board represents board state following a player's move.
 * 
 * Restore the board to a stable state by:
 * 1. Crush candy clusters of size 3+ (adjacent either vertically or
 *    horizontally, ie: 3+ in a column vertically, or 3+ in a row horizontally)
 * 2. After crushing, drop candy from above to fill in empty space
 * 3. If new candy clusters formed, repeats steps 1 & 2
 * 4. Return stable board (no many candy clusters to crush)
 * 
 * Constraints:
 * Board - # rows in range 3-50.
 * Board - # cols in range 3-50.
 * Candy integers range from 1-2000.
*/

/**
 * Returns the board to a stable state.
 * @param {number[][]} board - The board state following a player's move.
 * @returns {number[][]} The stable board state.
*/
function stabilize(board) {
    const CLUSTER_SIZE = 3; // the minimum size a cluster must be to explode

    // Initial pass to see if there are candy clusters to crush
    let toDestroy = searchForClusters(board, CLUSTER_SIZE);
    let clustersToDestroy = toDestroy.size > 0;

    while (clustersToDestroy) {
        crush(board, toDestroy);
        collapse(board);
        toDestroy = searchForClusters(board, CLUSTER_SIZE);
        clustersToDestroy = toDestroy.size > 0;
    }

    return board;
}

/**
 * Searches for candy clusters of CLUSTER_SIZE to crush.
 * @param {number[][]} board - The game board.
 * @param {number} CLUSTER_SIZE - Min size of cluster to crush.
 * @returns {Map} - Map of cells to destroy, key = row, value = set of cols.
 */
function searchForClusters(board, CLUSTER_SIZE) {
    const numRows = board.length;
    const numCols = board[0].length;
    // Map of cells to crush, key = row, value = set of cols
    const toDestroy = new Map();
    
    // For every cell, check for cluster horizontally and vertically
    for (let row = 0; row < numRows; row++) {
        for (let col = 0; col < numCols; col++) {
            const candyNum = board[row][col];

            // Only check for valid candy
            if (candyNum > 0) {
                // Only check row if large enough cluster is possible
                if (col <= numCols - CLUSTER_SIZE) {
                    const rowCluster = checkRow(board, row, col, candyNum);
                    checkCluster(rowCluster, toDestroy, CLUSTER_SIZE);
                }

                // Only check col if large enough cluster is possible
                if (row <= numRows - CLUSTER_SIZE) {
                    const colCluster = checkCol(board, row, col, candyNum);
                    checkCluster(colCluster, toDestroy, CLUSTER_SIZE);
                }
            }
        }
    }

    return toDestroy;
}

/**
 * Checks the current row for a candy cluster.
 * @param {number[][]} board - The game board.
 * @param {number} row - The current cell row.
 * @param {number} col - The current cell col.
 * @param {number} candyNum - The id of the current candy type.
 * @returns {Object} Returns a candy cluster with size and list of cells.
 */
function checkRow(board, row, col, candyNum) {
    let size = 0;
    const cells = [];

    while (col < board[0].length && board[row][col] === candyNum) {
        size++;
        cells.push({row: row, col: col});
        col++;
    }
    
    return {size, cells};
}

function checkCol(board, row, col, candyNum) {
    let size = 0;
    const cells = [];

    while (row < board.length && board[row][col] === candyNum) {
        size++;
        cells.push({row: row, col: col});
        row++;
    }

    return {size, cells};
}

function checkCluster(cluster, toDestroy, CLUSTER_SIZE) {
    if (cluster.size >= CLUSTER_SIZE) {
        cluster.cells.forEach(cell => {
            const row = cell.row;
            const col = cell.col;

            if (toDestroy.has(row)) {
                toDestroy.get(row).add(col);
            } else {
                toDestroy.set(row, new Set().add(col));
            }
        });
    }
}

function crush(board, toDestroy) {
    toDestroy.forEach((value, key) => {
        const row = key;
        value.forEach(col => {
            board[row][col] = 0;
        });
    });
}

function collapse(board) {
    // for (let col = 0; col < board[0].length; col++) {
    //     let collapseCol = findZeros(board, col);
    // }
}

function findZeroes(board, col) {
    for (row = board.length - 1; row >= 0; row++) {
        
    }
}

function printBoard(board) {
    console.log('Board:');
    board.forEach(row =>{
        console.log(row);
    });
    console.log();
}

(function runTests() {
    let tests = [
        {
            input: [
                [110,5,112,113,114],
                [210,211,5,213,214],
                [310,311,3,313,314],
                [410,411,412,5,414],
                [5,1,512,3,3],
                [610,4,1,613,614],
                [710,1,2,713,714],
                [810,1,2,1,1],
                [1,1,2,2,2],
                [4,1,4,4,1014]
            ],
            output: [
                [0,0,0,0,0],
                [0,0,0,0,0],
                [110,0,0,0,114],
                [210,0,0,0,214],
                [310,0,0,113,314],
                [410,0,0,213,414],
                [610,211,112,313,614],
                [710,311,412,613,714],
                [810,411,512,713,1014]
            ]
        }
    ];

    tests.forEach( (test) => {
        const result = stabilize(test.input);

        const passed = result.length === test.output.length &&
            result[0].length === test.output[0].length &&
            result.every( (row, rowIndex) => {
                const expectedRow = test.output[rowIndex];

                row.every( (value, colIndex) => {
                    value === expectedRow[colIndex];
                });
            });

        console.log(`Test passed? : ${passed}`);
    });
})();