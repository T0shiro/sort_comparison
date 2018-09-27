package algorithms

class quick_sort {

    def run(List<Integer> values) {
        quicksort(values, 0, values.size() - 1)
        return values
    }

    private def quicksort(List<Integer> values, int start, int end) {
        if (start < end) {
            def pivot = partition(values, start, end)
            quicksort(values, start, pivot - 1)
            quicksort(values, pivot + 1, end)
        }
    }

    private def partition(List<Integer> values, int start, int end) {
        def pivot = values[end]
        def i = start
        for (def j = start; j <= end - 1; j++) {
            if (values[j] < pivot) {
                swapValues(i, j, values)
                i++
            }
        }
        swapValues(i, end, values)
        return i
    }

    private def swapValues(int a, int b, List<Integer> values) {
        int tmp = values[a]
        values[a] = values[b]
        values[b] = tmp
    }

}
