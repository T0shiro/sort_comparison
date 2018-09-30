import algorithms.insertion_sort
import algorithms.heap_sort
import algorithms.merge_sort
import algorithms.quick_sort


MAX_TWO_POW = 10
ALGO_ITERATIONS = 1000

def run_one_sort(Closure c, iterations, max_pow){
    Random rand = new Random()
    def means = new HashMap()
    for (int i = 1; i <= max_pow; i++) {
        sz = 2**i
        def results = []
        for (int j = 0; j < iterations; j++) {
            def table = []
            (1..sz).each {
                table << rand.nextInt(2*sz)
            }
            def start = System.currentTimeMillis()
            c(table)
            def now = System.currentTimeMillis()
            results << now - start
        }
        def mean = results.sum()/results.size()
        means.put(sz, mean)
    }
    return means
}

def run_all_sorts(){
    def insertionSort = new insertion_sort()
    def mergeSort = new merge_sort()
    def heapSort = new heap_sort()
    def quickSort = new quick_sort()
    run_one_sort(insertionSort.&run, ALGO_ITERATIONS, MAX_TWO_POW)
    run_one_sort(mergeSort.&run, ALGO_ITERATIONS, MAX_TWO_POW)
    run_one_sort(heapSort.&run, ALGO_ITERATIONS, MAX_TWO_POW)
    run_one_sort(quickSort.&run, ALGO_ITERATIONS, MAX_TWO_POW)
}

def insertionSort = new insertion_sort()
println(run_one_sort(insertionSort.&run, ALGO_ITERATIONS, MAX_TWO_POW))

