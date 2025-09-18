import unittest
from algorithms import insertion_sort, merge_sort, binary_search, find_max

class TestAlgorithms(unittest.TestCase):
    def test_insertion_sort(self):
        self.assertEqual(insertion_sort([5, 2, 9, 1]), [1, 2, 5, 9])

    def test_merge_sort(self):
        self.assertEqual(merge_sort([5, 2, 9, 1]), [1, 2, 5, 9])

    def test_binary_search(self):
        arr = [1, 2, 3, 4, 5]
        self.assertEqual(binary_search(arr, 3), 2)
        self.assertEqual(binary_search(arr, 6), -1)

    def test_find_max(self):
        arr = [3, 9, 2, 7, 5]
        self.assertEqual(find_max(arr), 9)

if __name__ == "__main__":
    unittest.main()
