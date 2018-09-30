package algorithms

class quick_sort {

    private Random random = new Random()

    def run(List<Integer> values) {
        quicksort(values, 0, values.size() - 1, this.&median_random)
        return values
    }

    private def quicksort(List<Integer> values, int start, int end, Closure median) {
        if (start < end) {
            def p = partition(values, start, end, median)
            quicksort(values, start, p, median)
            quicksort(values, p + 1, end, median)
        }
    }

    private def partition(List<Integer> values, int start, int end, Closure median) {
        //def pivot = values[end]
        def pivot = median(values, start, end)
        def i = start
        def j = end
        while (true) {
            while (values[i] < pivot) i++
            while (values[j] > pivot) j--
            if (i >= j) return j
            swapValues(i, j, values)
        }
    }

    private def median_of_three(List<Integer> values, int start, int end) {
        int mid = (int) ((start + end) / 2)
        if (values[mid] < values[start]) swapValues(start, mid, values)
        if (values[end] < values[start]) swapValues(start, end, values)
        if (values[mid] < values[end]) swapValues(mid, end, values)
        return values[end]
    }

    private def median_random(List<Integer> values, int start, int end) {
        return values[random.nextInt(end - start + 1) + start]
    }

    private def median_first(List<Integer> values, int start, int end) {
        return values[start]
    }

    private def swapValues(int a, int b, List<Integer> values) {
        int tmp = values[a]
        values[a] = values[b]
        values[b] = tmp
    }

    static void main(String[] args) {
        println new quick_sort().run([4, 2, 9, 5, 7])
    }

}
