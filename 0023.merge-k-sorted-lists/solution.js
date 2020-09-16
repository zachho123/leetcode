/**
 * Merges k ascending-sorted linked lists into a single sorted list.
 * @param {ListNode[]} lists - List of linked lists
 * @return {ListNode} - Merged sorted linked list
 */
function mergeKLists(lists) {
  if (!lists || lists.length === 0) {
    return null;
  }

  while (lists.length > 1) {
    const l1 = lists.shift();
    const l2 = lists.shift();
    const merged = mergeTwoLists(l1, l2);
    lists.push(merged);
  }

  return lists[0];
}

function mergeTwoLists(l1, l2) {
  let dummy = new ListNode(0);
  let curr = dummy;

  // While l1 and l2 have nodes left, take the smaller of the two
  while (l1 && l2) {
    if (l2.val < l1.val) {
      curr.next = l2;
      l2 = l2.next;
    } else {
      curr.next = l1;
      l1 = l1.next;
    }
    curr = curr.next;
  }

  // If only l1 or l2 have nodes left, take from there
  curr.next = !l1 ? l2 : l1;

  return dummy.next;
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