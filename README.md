# Data Structures & Algorithms (Java)

A collection of classic DSA implementations in Java, built with Maven and targeting Java 21.

## Project Structure

```
src/main/java/com/rpk/dsa/   # Algorithm implementations
src/test/java/com/rpk/        # Unit tests
```

## Topics Covered

### Sorting
| File | Description |
|---|---|
| `BubbleSort.java` | Bubble sort algorithm |
| `SelectionSort.java` | Selection sort algorithm |
| `InsertionSort.java` | Insertion sort algorithm |
| `MergeSort.java` | Merge sort algorithm |

### Searching
| File | Description |
|---|---|
| `BinarySearch.java` | Binary search on a sorted array |
| `BinarySearchMatrix.java` | Binary search on a 2D matrix |

### Two Pointers / Sliding Window
| File | Description |
|---|---|
| `TwoPointers.java` | Two-pointer technique |
| `SlowFastPointer.java` | Slow & fast pointer (Floyd's cycle) |
| `SlidingWindowPointers.java` | Sliding window pattern |

### Stack
| File | Description |
|---|---|
| `ValidParenthesisStack.java` | Valid parentheses using a stack |
| `SimplifyPath.java` | Simplify Unix file path using a stack |

### Hash Map
| File | Description |
|---|---|
| `HashMapPractice.java` | General HashMap usage |
| `HashMapAnagram.java` | Anagram check using HashMap |
| `HashMapWordPattern.java` | Word pattern matching |
| `GroupAnagram.java` | Group anagrams together |

### Heap / Priority Queue
| File | Description |
|---|---|
| `KthLargestElement.java` | Kth largest element using a min-heap |
| `KthSmallestElement.java` | Kth smallest element using a max-heap |
| `TopKFrequencyElements.java` | Top K frequent elements |
| `MergekSortedList.java` | Merge K sorted lists (naive) |
| `MergeKSortedListPQ.java` | Merge K sorted lists using a priority queue |
| `FindkPairsWithSmallestSum.java` | Find K pairs with smallest sum |

### Binary Tree
| File | Description |
|---|---|
| `BinaryTreeOrderTraversal.java` | Level-order (BFS) traversal |
| `InOrderTraversalDFS.java` | In-order DFS traversal |
| `PreOrderTraversalDFS.java` | Pre-order DFS traversal |
| `PostOrderTraversalDFS.java` | Post-order DFS traversal |
| `InvertBinaryTree.java` | Invert a binary tree (O(n) time, O(h) space) |

## Prerequisites

- Java 21+
- Maven 3.x

## Build & Run

**Compile:**
```bash
mvn compile
```

**Run tests:**
```bash
mvn test
```

**Run a specific class** (Windows):
```bat
run.bat
```

**Run a specific class** (Linux/macOS):
```bash
./run.sh
```
