/**
 * Checks if letters can be rearranged such that 2 adjacent letters are not
 * the same.
 * @description Input string will consist of lowercase letters and have length
 * in range [1, 500].
 * @param {string} s - The input string.
 * @returns {string} - Possible rearranged string or empty string if none exist.
 */
function reorganizeString(s) {
    if (s.length === 0) {
        return '';
    }

    // Create an array of objects for chars a-z, and counts for each
    let charCounts = new Array(26).fill(0);

    // Go through input array and increment character count
    // If one character appears more than half the length of the string
    // rearrangement is not possible
    for (let char = 0; char < s.length; char++) {
        let index = convert(s.charAt(char));
        charCounts[index]++;
        if (charCounts[index] > Math.floor((s.length + 1) / 2)) {
            return '';
        }
    }

    // Create max heap and insert chars w/ counts in
    const heap = new MaxHeap((a, b) => { 
        if (a.count === b.count) {
            return 0;
        }
        return a.count < b.count ? -1 : 1;
     });

    for (let char = 0; char < charCounts.length; char++) {
        const currCount = charCounts[char];
        if (currCount > 0) {
            heap.insert({ 
                char: String.fromCharCode(char + 'a'.charCodeAt(0)),
                count: currCount
            });
        }
    }

    let output = '';
    while (heap.size >= 2) {
        let max1 = heap.removeMax();
        let max2 = heap.removeMax();
        output += max1.char;
        output += max2.char;
        max1.count--;
        max2.count--;

        if (max1.count > 0) {
            heap.insert(max1);
        }

        if (max2.count > 0) {
            heap.insert(max2);
        }
    }

    if (heap.size > 0) {
        output += heap.removeMax().char;
    }

    return output;
}

class MaxHeap {
    constructor(customCompare) {
        this.heap = [];
        this.size = 0;
        // Function to compare nodes of the heap
        this.compare = customCompare ? customCompare : MaxHeap.defaultCompare;
    }

    insert(node) {
        // Place at end of heap
        this.heap.push(node);
        this.size++;

        // If length > 1, check parents to satisfy max heap
        if (this.size > 1) {
            let current = this.heap.length - 1;
            let parent = Math.floor((current - 1) / 2);

            // While current is bigger than parent, swap up
            while (
                current > 0 && 
                this.compare(this.heap[current], this.heap[parent]) > 0
            ) {
                this.swap(current, parent);
                current = parent;
                parent = Math.floor((current - 1) / 2);
            }
        }
    }

    removeMax() {
        if (this.size === 0) {
            return null;
        }

        // Remove max, and replace with last item in the heap
        const max = this.heap[0];
        this.heap[0] = this.heap[this.size - 1];
        this.heap.pop();
        this.size--;

        let current = 0;
        let leftChild = current * 2 + 1;
        let rightChild = leftChild + 1;
        let largest = current;

        // Only check until the last parent in the heap
        while (current <= Math.floor(this.size / 2) - 1) {
            // If left child is bigger
            if (this.compare(this.heap[largest], this.heap[leftChild]) < 0) {
                largest = leftChild;
            }

            // If right child is bigger
            // Right child is not guaranteed so we check against length
            if (
                rightChild < this.size && 
                this.compare(this.heap[largest], this.heap[rightChild]) < 0
            ) {
                largest = rightChild;
            }

            // If we found something bigger, swap down, then check new children
            if (largest !== current) {
                this.swap(current, largest);
                current = largest;
                leftChild = current * 2 + 1;
                rightChild = leftChild + 1;
            } else {
                break;
            }
        }
        
        return max;
    }

    swap(a, b) {
        [this.heap[a], this.heap[b]] = [this.heap[b], this.heap[a]];
    }

    static defaultCompare(a, b) {
        if (a === b) {
            return 0;
        }

        return a < b ? -1 : 1;
    }
}

/**
 * Converts a character to an index.
 * @param {string} s - Single character string.
 * @returns {number} Index value.
 */
function convert(s) {
    return s.charCodeAt(0) - 'a'.charCodeAt(0);
}

(function runTests() {
    let tests = [
        { input: 'a', output: 'a'},
        { input: 'aa', output: '' },
        { input: 'aabb', output: 'abab' },
        { input: 'abcbdefffaad', output: 'afafbdafbde' },
        { input: 'aaaabcdef', output: 'abacadaef' }
    ];

    tests.forEach(test => {
        console.log(`RUNNING TEST...`);
        const result = reorganizeString(test.input);

        console.log(`Result: ${result}\n`);
    });
})();