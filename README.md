# NeetCode 150 – All Topics with Solutions

This document contains all 150 LeetCode problems from the NeetCode list, organized by topic, with clickable links and brief solution notes.

---

## 📘 1. Arrays & Hashing (15)
1. [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/) – Use a hash set to detect duplicates. **Time:** O(n), **Space:** O(n)  
2. [Valid Anagram](https://leetcode.com/problems/valid-anagram/) – Character frequency count or sorting. **Time:** O(n) or O(n log n), **Space:** O(1) or O(n)  
3. [Two Sum](https://leetcode.com/problems/two-sum/) – Hash map lookup of complement. **Time:** O(n), **Space:** O(n)  
4. [Group Anagrams](https://leetcode.com/problems/group-anagrams/) – Sort each string or use char-count tuple as key. **Time:** O(n·k log k), **Space:** O(n·k)  
5. [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/) – Frequency map + bucket/h​eap sort. **Time:** O(n log k) or O(n), **Space:** O(n)  
6. [Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/) – Use prefix and suffix products. **Time:** O(n), **Space:** O(1) (excluding output)  
7. [Valid Sudoku](https://leetcode.com/problems/valid-sudoku/) – Use sets per row, column, subgrid. **Time:** O(1), **Space:** O(1)  
8. [Encode and Decode Strings](https://leetcode.com/problems/encode-and-decode-strings/) – Prefix each string with length and delimiter. **Time:** O(n), **Space:** O(n)  
9. [Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/) – Use set and only start at sequence beginnings. **Time:** O(n), **Space:** O(n)  

10. [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/) – Kadane’s algorithm. **Time:** O(n), **Space:** O(1)  
11. [Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/) – Track both max and min product due to negatives. **Time:** O(n), **Space:** O(1)  
12. [Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/) – Binary search for pivot. **Time:** O(log n), **Space:** O(1)  
13. [Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/) – Modified binary search accounting for rotation. **Time:** O(log n), **Space:** O(1)  
14. [3Sum](https://leetcode.com/problems/3sum/) – Sort + two-pointer search. **Time:** O(n²), **Space:** O(n)  
15. [Container With Most Water](https://leetcode.com/problems/container-with-most-water/) – Two-pointer inward movement. **Time:** O(n), **Space:** O(1)  

---

## 📘 2. Two Pointers (5)
1. [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/) – Two pointers skipping non-alphanumeric. **Time:** O(n), **Space:** O(1)  
2. [Two Sum II – Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/) – Two-pointer on sorted array. **Time:** O(n), **Space:** O(1)  
3. [3Sum](https://leetcode.com/problems/3sum/) – As above. **Time:** O(n²), **Space:** O(n)  
4. [Container With Most Water](https://leetcode.com/problems/container-with-most-water/) – Repeat. **Time:** O(n), **Space:** O(1)  
5. [Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/) – Two-pointer maintaining left/right max levels. **Time:** O(n), **Space:** O(1)  

---

## 📘 3. Sliding Window (6)
1. [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) – Track min price and max profit. **Time:** O(n), **Space:** O(1)  
2. [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) – Sliding window + char map. **Time:** O(n), **Space:** O(min(n, charset))  
3. [Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/) – Sliding window with max-frequency tracking. **Time:** O(n), **Space:** O(1)  
4. [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/) – Use two-pointer window + frequency counts. **Time:** O(n + m), **Space:** O(m)  
5. [Permutation in String](https://leetcode.com/problems/permutation-in-string/) – Fixed-size window comparing counts. **Time:** O(n + m), **Space:** O(1)  
6. [Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/) – Deque for max in sliding window. **Time:** O(n), **Space:** O(k)  

---

## 📘 4. Stack (6)
1. [Valid Parentheses](https://leetcode.com/problems/valid-parentheses/) – Use stack to check matching. **Time:** O(n), **Space:** O(n)  
2. [Min Stack](https://leetcode.com/problems/min-stack/) – Stack with supplemental min tracking. **Time:** O(1) ops, **Space:** O(n)  
3. [Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/) – Stack eval of tokens. **Time:** O(n), **Space:** O(n)  
4. [Generate Parentheses](https://leetcode.com/problems/generate-parentheses/) – DFS/backtracking with pruning. **Time:** Catalan, **Space:** O(n)  
5. [Daily Temperatures](https://leetcode.com/problems/daily-temperatures/) – Stack tracking indices for resolution. **Time:** O(n), **Space:** O(n)  
6. [Car Fleet](https://leetcode.com/problems/car-fleet/) – Sort + compute time to target, stack simulate fleets. **Time:** O(n log n), **Space:** O(n)  

---

## 📘 5. Binary Search (8)
1. [Binary Search](https://leetcode.com/problems/binary-search/) – Standard. **Time:** O(log n), **Space:** O(1)  
2. [Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix/) – Flat indexing + binary search. **Time:** O(log(m·n)), **Space:** O(1)  
3. [Koko Eating Bananas](https://leetcode.com/problems/koko-eating-bananas/) – Binary search optimal speed. **Time:** O(n log W), **Space:** O(1)  
4. [Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/) – See above. **Time:** O(log n), **Space:** O(1)  
5. [Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/) – See above. **Time:** O(log n), **Space:** O(1)  
6. [Time-Based Key-Value Store](https://leetcode.com/problems/time-based-key-value-store/) – Use map + binary search on timestamps. **Time:** O(1) set, O(log n) get, **Space:** O(n)  
7. [Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/) – Partition-based binary search. **Time:** O(log(min(m,n))), **Space:** O(1)  
8. [Find K Closest Elements](https://leetcode.com/problems/find-k-closest-elements/) – Binary search window. **Time:** O(log(n−k) + k), **Space:** O(k)  

---

## 📘 6. Linked List (10)
1. [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/) – Iterative pointer reversal. **Time:** O(n), **Space:** O(1)  
2. [Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/) – One-pass merge. **Time:** O(n1+n2), **Space:** O(1)  
3. [Reorder List](https://leetcode.com/problems/reorder-list/) – Split, reverse, interleave. **Time:** O(n), **Space:** O(1)  
4. [Remove N-th Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/) – Two-pointer gap. **Time:** O(n), **Space:** O(1)  
5. [Copy List with Random Pointer](https://leetcode.com/problems/copy-list-with-random-pointer/) – With interleaving or hash map. **Time:** O(n), **Space:** O(1) or O(n)  
6. [Add Two Numbers](https://leetcode.com/problems/add-two-numbers/) – Digit-by-digit plus carry. **Time:** O(max len), **Space:** O(max len)  
7. [LRU Cache](https://leetcode.com/problems/lru-cache/) – Doubly-linked list + hashmap. **Time:** O(1), **Space:** O(capacity)  
8. [Merge K Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/) – Use heap or divide-and-conquer. **Time:** O(N log k), **Space:** O(k)  
9. [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/) – Floyd’s algorithm. **Time:** O(n), **Space:** O(1)  
10. [Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/) – Cycle detection in array. **Time:** O(n), **Space:** O(1)  

---

## 📘 7. Trees (13)
1. [Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/) – DFS/BFS. **Time:** O(n), **Space:** O(h)  
2. [Same Tree](https://leetcode.com/problems/same-tree/) – Compare recursively. **Time:** O(n), **Space:** O(h)  
3. [Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree/) – DFS swap children. **Time:** O(n), **Space:** O(h)  
4. [Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/) – DFS + track max path sum. **Time:** O(n), **Space:** O(h)  
5. [Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/) – BFS with queue. **Time:** O(n), **Space:** O(n)  
6. [Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/) – Preorder with markers or BFS. **Time:** O(n), **Space:** O(n)  
7. [Subtree of Another Tree](https://leetcode.com/problems/subtree-of-another-tree/) – DFS + comparison. **Time:** O(n·m), **Space:** O(h)  
8. [Construct Binary Tree from Preorder and Inorder](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder/) – Use index maps. **Time:** O(n), **Space:** O(n)  
9. [Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/) – DFS with min/max bounds. **Time:** O(n), **Space:** O(h)  
10. [Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/) – Inorder traversal. **Time:** O(h + k), **Space:** O(h)  
11. [Lowest Common Ancestor of BST](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/) – Use BST properties. **Time:** O(h), **Space:** O(1)  
12. [Binary Tree Right Side View](https://leetcode.com/problems/binary-tree-right-side-view/) – BFS track rightmost nodes. **Time:** O(n), **Space:** O(n)  
13. [Count Good Nodes in Binary Tree](https://leetcode.com/problems/count-good-nodes-in-binary-tree/) – DFS carry max-so-far. **Time:** O(n), **Space:** O(h)  

---

## 📘 8. Tries (3)
1. [Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree/) – Node children + end-of-word flag. **Time:** O(len), **Space:** O(sum len)  
2. [Add and Search Word – Data structure design](https://leetcode.com/problems/add-and-search-word-data-structure-design/) – DFS support for wildcard '.'. **Time:** O(n·alphabet), **Space:** O(N·alphabet)  
3. [Word Search II](https://leetcode.com/problems/word-search-ii/) – Trie + DFS backtracking pruning. **Time:** O(m·4·3^(L−1)), **Space:** O(sum lengths)  

---

## 📘 9. Heap / Priority Queue (4)
1. [Kth Largest Element in a Stream](https://leetcode.com/problems/kth-largest-element-in-a-stream/) – Maintain min-heap of size k. **Ops:** O(log k), **Space:** O(k)  
2. [Last Stone Weight](https://leetcode.com/problems/last-stone-weight/) – Max-heap repeatedly reduce stones. **Time:** O(n log n), **Space:** O(n)  
3. [K Closest Points to Origin](https://leetcode.com/problems/k-closest-points-to-origin/) – Heap or quickselect. **Time:** O(n log k) or O(n), **Space:** O(k)  
4. [Task Scheduler](https://leetcode.com/problems/task-scheduler/) – Greedy counts + idle slot logic. **Time:** O(n), **Space:** O(1)  

---

## 📘 10. Backtracking (5)
1. [Subsets](https://leetcode.com/problems/subsets/) – DFS generate power set. **Time:** O(n·2ⁿ), **Space:** O(n)  
2. [Combination Sum](https://leetcode.com/problems/combination-sum/) – DFS + sum pruning. **Time:** O(n·#combos), **Space:** O(n)  
3. [Permutations](https://leetcode.com/problems/permutations/) – Generate via DFS swapping. **Time:** O(n·n!), **Space:** O(n)  
4. [Word Search](https://leetcode.com/problems/word-search/) – Grid DFS + backtracking. **Time:** O(m·n·4^L), **Space:** O(L)  
5. [Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning/) – DFS + palindrome checks. **Time:** O(n·2ⁿ), **Space:** O(n)  

---

## 📘 11. Graphs (10)
1. [Clone Graph](https://leetcode.com/problems/clone-graph/) – DFS/BFS + visited map. **Time:** O(n + e), **Space:** O(n)  
2. [Course Schedule](https://leetcode.com/problems/course-schedule/) – Detect cycle in directed graph. **Time:** O(n + e), **Space:** O(n)  
3. [Pacific Atlantic Water Flow](https://leetcode.com/problems/pacific-atlantic-water-flow/) – Multi-source DFS/BFS from borders. **Time:** O(m·n), **Space:** O(m·n)  
4. [Number of Islands](https://leetcode.com/problems/number-of-islands/) – Grid DFS flood-fill. **Time:** O(m·n), **Space:** O(m·n)  
5. [Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/) – Set-based graph-like jumps (same as #9 above). **Time:** O(n), **Space:** O(n)  
6. [Alien Dictionary](https://leetcode.com/problems/alien-dictionary/) – Topological sort on unknown char order. **Time:** O(n + e), **Space:** O(n + e)  
7. [Network Delay Time](https://leetcode.com/problems/network-delay-time/) – Dijkstra or bellman-ford. **Time:** O(e + n log n), **Space:** O(n)  
8. [Minimum Height Trees](https://leetcode.com/problems/minimum-height-trees/) – Trim centers iteratively (BFS). **Time:** O(n), **Space:** O(n)  
9. [Reconstruct Itinerary](https://leetcode.com/problems/reconstruct-itinerary/) – Hierholzer’s algorithm (Eulerian path). **Time:** O(e log e), **Space:** O(e)  
10. [Word Ladder](https://leetcode.com/problems/word-ladder/) – Bidirectional BFS. **Time:** O(n · wordLen · 26), **Space:** O(n)  

---

## 📘 12. Advanced Graphs (5)
1. [Redundant Connection](https://leetcode.com/problems/redundant-connection/) – Union-Find cycle detection. **Time:** O(e α(n)), **Space:** O(n)  
2. [Number of Connected Components in an Undirected Graph](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/) – DFS/bfs count. **Time:** O(n + e), **Space:** O(n)  
3. [Critical Connections in a Network](https://leetcode.com/problems/critical-connections-in-a-network/) – Tarjan’s Bridges (DFS with discovery/low). **Time:** O(n + e), **Space:** O(n)  
4. [Graph Valid Tree](https://leetcode.com/problems/graph-valid-tree/) – Check connectivity + edge count = n−1. **Time:** O(n + e), **Space:** O(n)  
5. [Swim in Rising Water](https://leetcode.com/problems/swim-in-rising-water/) – Binary search on time + BFS/DFS. **Time:** O(n² log C), **Space:** O(n²)  

---

## 📘 13. One‑Dimensional Dynamic Programming (10)
1. [Climbing Stairs](https://leetcode.com/problems/climbing-stairs/) – Fibonacci DP. **Time:** O(n), **Space:** O(1)  
2. [House Robber](https://leetcode.com/problems/house-robber/) – DP with prev two houses. **Time:** O(n), **Space:** O(1)  
3. [House Robber II](https://leetcode.com/problems/house-robber-ii/) – Circular variant: pick max of two linear runs. **Time:** O(n), **Space:** O(1)  
4. [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/) – Expand-around-center. **Time:** O(n²), **Space:** O(1)  
5. [Palindromic Substrings](https://leetcode.com/problems/palindromic-substrings/) – Expand from every center. **Time:** O(n²), **Space:** O(1)  
6. [Decode Ways](https://leetcode.com/problems/decode-ways/) – DP on counts of valid decodings. **Time:** O(n), **Space:** O(1)  
7. [Coin Change](https://leetcode.com/problems/coin-change/) – Classic unbounded knapsack DP. **Time:** O(amount·n), **Space:** O(amount)  
8. [Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/) – Already above in arrays.  
9. [Word Break](https://leetcode.com/problems/word-break/) – DP or BFS on prefixes. **Time:** O(n²·k), **Space:** O(n)  
10. [Jump Game](https://leetcode.com/problems/jump-game/) – Greedy or DP. **Time:** O(n), **Space:** O(1)  

---

## 📘 14. Two‑Dimensional Dynamic Programming (5)
1. [Unique Paths](https://leetcode.com/problems/unique-paths/) – Combinational DP table. **Time:** O(m·n), **Space:** O(n)  
2. [Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence/) – 2D DP table. **Time:** O(m·n), **Space:** O(m·n)  
3. [Interleaving String](https://leetcode.com/problems/interleaving-string/) – 2D DP check. **Time:** O(m·n), **Space:** O(m·n)  
4. [Maximum Profit in Job Scheduling](https://leetcode.com/problems/maximum-profit-in-job-scheduling/) – Sort + binary search + DP. **Time:** O(n log n), **Space:** O(n)  
5. [Distinct Subsequences](https://leetcode.com/problems/distinct-subsequences/) – DP on sequences. **Time:** O(m·n), **Space:** O(n)  

---

## 📘 15. Greedy (5)
1. [Gas Station](https://leetcode.com/problems/gas-station/) – One-pass with accumulated sum. **Time:** O(n), **Space:** O(1)  
2. [Jump Game](https://leetcode.com/problems/jump-game/) – Greedy farthest reach. **Time:** O(n), **Space:** O(1)  
3. [Merge Intervals](https://leetcode.com/problems/merge-intervals/) – Sort + merge scan. **Time:** O(n log n), **Space:** O(n)  
4. [Insert Interval](https://leetcode.com/problems/insert-interval/) – Handle overlap insertion in sorted list. **Time:** O(n), **Space:** O(n)  
5. [Non-overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/) – Select intervals with earliest end. **Time:** O(n log n), **Space:** O(1)  

---

## 📘 16. Intervals (5)
1. [Merge Intervals](https://leetcode.com/problems/merge-intervals/) – See above  
2. [Insert Interval](https://leetcode.com/problems/insert-interval/) – See above  
3. [Non-overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/) – See above  
4. [Meeting Rooms](https://leetcode.com/problems/meeting-rooms/) – Sort by start and check overlap. **Time:** O(n log n), **Space:** O(1)  
5. [Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii/) – Min-heap tracking end times. **Time:** O(n log n), **Space:** O(n)  

---

## 📘 17. Bit Manipulation (4)
1. [Single Number](https://leetcode.com/problems/single-number/) – XOR all to find unique. **Time:** O(n), **Space:** O(1)  
2. [Number of 1 Bits](https://leetcode.com/problems/number-of-1-bits/) – Bit count trick. **Time:** O(1), **Space:** O(1)  
3. [Counting Bits](https://leetcode.com/problems/counting-bits/) – DP bit patterns. **Time:** O(n), **Space:** O(n)  
4. [Missing Number](https://leetcode.com/problems/missing-number/) – XOR or sum formula. **Time:** O(n), **Space:** O(1)  

---

## 📘 18. Math & Geometry (3)
1. [Rotate Image](https://leetcode.com/problems/rotate-image/) – Transpose + reverse rows. **Time:** O(n²), **Space:** O(1)  
2. [Spiral Matrix](https://leetcode.com/problems/spiral-matrix/) – Layer-by-layer traversal. **Time:** O(n·m), **Space:** O(1)  
3. [Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes/) – Use first row/column as flag. **Time:** O(n·m), **Space:** O(1)  

---

## 📘 19. Design (5)
1. [Min Stack](https://leetcode.com/problems/min-stack/) – Include min tracking. **Time:** O(1), **Space:** O(n)  
2. [LRU Cache](https://leetcode.com/problems/lru-cache/) – Doubly-linked + hashmap. **Time:** O(1), **Space:** O(capacity)  
3. [Time-Based Key-Value Store](https://leetcode.com/problems/time-based-key-value-store/) – Timestamp binary search. **Time:** O(1)/O(log n), **Space:** O(n)  
4. [Encode and Decode Strings](https://leetcode.com/problems/encode-and-decode-strings/) – Length-prefix method. **Time:** O(n), **Space:** O(n)  
5. [Design Tic-Tac-Toe](https://leetcode.com/problems/design-tic-tac-toe/) – Track rows/cols/diagonals counts. **Time:** O(1), **Space:** O(n)  



Array Notes https://gist.github.com/saurrabhagarwal/e72aaa400dcf816d132c2d555bb9ad2d
1. static void insertAtIndex(int index, int value) // insert at any index - right shift
2. static void deleteIndex(int index) // delete any index - left shift
3. static void reverse() // reverse array
4. static void leftShift() // left shift - 0th element lost, last element = 0
5. static void rotate() // rotate - 0th element will go to last element
6. static void insertInSortedArray1(int[] arr, int el) // insert in sorted array (method 1)
7. static void insertInSortedArray2(int[] arr, int el) // insert in sorted array (method 2)
8. static void checkIfSorted(int[] arr) // check if array is sorted
9. static void arrangeNegative(int[] arr) // arrange negative numbers to the left and positive numbers to the right (method 1)
10. static void arrangeNegative2(int[] arr) // arrange negative numbers to the left and positive numbers to the right (method 2)
11. static void mergeSortedArrays(int[] arr1, int[] arr2) // merge two sorted arrays
12. static void findMissingElementsInSortedArray(int[] arr) // find missing elements in a sorted array
13. static void findDuplicatesInSortedArray(int[] arr) // find duplicates in a sorted array
14. static void findCountOfDuplicatesInSortedArray(int[] arr) // find count of duplicates in a sorted array (method 1)
15. static void findCountOfDuplicatesInSortedArray2(int[] arr) // find count of duplicates in a sorted array (method 2)
16. static void findDuplicates(int[] arr) // find duplicates in an unsorted array
17. public static void findPairInUnSortedArray(int[] arr, int k) // find pair in an unsorted array with a given sum
18. public static void findPairInSortedArray(int[] arr, int k) // find pair in a sorted array with a given sum
19. public static void findMinMax(int[] arr) // find minimum and maximum in an array
