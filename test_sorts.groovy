import algorithms.insertion_sort
import algorithms.heap_sort
import algorithms.merge_sort
import algorithms.quick_sort
import algorithms.smooth_sort


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
sorting_algorithms = [new insertion_sort(), new heap_sort(), new merge_sort(), new quick_sort(), new smooth_sort()]
sorting_algorithms_names = ["insertion_sort", "heap_sort", "merge_sort", "quick_sort", "smooth_sort"]
[sorting_algorithms, arrayToSort.permutations()].eachCombination { assert it[0].&run(it[1]) == arrayToSort }
