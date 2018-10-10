import algorithms.insertion_sort
import algorithms.heap_sort
import algorithms.merge_sort
import algorithms.quick_sort
import algorithms.smooth_sort

/**
 * Runs all algorithms on all permutations of a sorted array, and checks if each output is
 * @param start_array
 * @param sorted_array
 * @return
 */

def test_sort(List<Integer> start_array, List<Integer> sorted_array) {
    start_array.sort()
    for (int i = 0; i < start_array.size(); i++) {
        if (start_array[i] != sorted_array[i]) {
            return false
        }
    }
    return true
}

arrayToSort = 1..5
sorting_algorithms = [new insertion_sort(),
                      new heap_sort(),
                      new merge_sort(),
                      new quick_sort(algorithms.quick_sort.Pivot.FIRST),
                      new quick_sort(algorithms.quick_sort.Pivot.RANDOM),
                      new quick_sort(algorithms.quick_sort.Pivot.MEDIAN3),
                      new quick_sort(algorithms.quick_sort.Pivot.MEDIAN5),
                      new smooth_sort()]

[sorting_algorithms, arrayToSort.permutations()].eachCombination { assert it[0].&run(it[1]) == arrayToSort }
