/**
 * Merges k ascending-sorted linked lists into a single sorted list.
 * @param {ListNode[]} lists - List of linked lists
 * @return {ListNode} - Merged sorted linked list
 */
function mergeKLists(lists) {
  if (!lists || lists.length === 0) {
    return null;
  }

  let activeListIndices = [];
  const size = lists.length;

  // Check which lists are active
  for (let i = 0; i < size; i++) {
    if (lists[i] && lists[i].val !== undefined) {
      activeListIndices.push(i);
    }
  }

  let head = new ListNode(0, null);
  let curr = head;
  // While there are active lists, grab the least and append to merged
  while (activeListIndices.length > 0) {
    let minIndex = 0; // minIndex is an index into activeIndexes 

    // Iterate over active list indices and find the index of the list with the
    // min val
    for (let i = 0; i < activeListIndices.length; i++) {
      const currIndex = activeListIndices[i];
      if (lists[currIndex].val < lists[activeListIndices[minIndex]].val) {
        minIndex = i;
      }
    }
    const currListIndex = activeListIndices[minIndex];

    // Set the next node as the min found and update curr
    curr.next = lists[currListIndex];
    curr = curr.next;
    
    // If we're at the end of a list, remove it from the active lists
    // Else, progress the current active list
    if (lists[currListIndex].next === null) {
      activeListIndices.splice(minIndex, 1);
    } else {
      lists[currListIndex] = lists[currListIndex].next;
    }
  }

  return head.next;
}

function ListNode(val, next) {
  this.val = (val === undefined ? 0 : val);
  this.next = (next === undefined ? null : next);
}

function createLL(nums) {
  if (!nums) {
    return null;
  }

  let head = null;
  let last = null;

  for (let i = nums.length - 1; i >= 0; i--) {
    head = new ListNode(nums[i], last);
    last = head;
  }

  return head;
}

(function run() {
  let tests = [
    {
      input: [
        createLL([1, 4, 5]),
        createLL([1, 3, 4]),
        createLL([2, 6])
      ],
      output: createLL([1, 1, 2, 3, 4, 4, 5, 6])
    },
    {
      input: [],
      output: createLL(null)
    },
    {
      input: [createLL(null)],
      output: createLL(null)
    },
    {
      input: [createLL(null), createLL([1])],
      output: createLL([1])
    },
    {
      input: [createLL([1, 2, 3]), createLL([4, 5, 6, 7])],
      output: createLL([1, 2, 3, 4, 5, 6, 7])
    }
  ];

  tests.forEach(test => {
    console.log('\nrunning test...');
    let result = mergeKLists(test.input);
    let expected = test.output;
    let passed = true;

    while (result) {
      if (result.val !== expected.val) {
        passed = false;
        break;
      }
      result = result.next;
      expected = expected.next;
    }

    console.log(`test passed: ${passed}`);
  });
})();