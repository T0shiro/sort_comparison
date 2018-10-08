import algorithms.insertion_sort
import algorithms.heap_sort
import algorithms.merge_sort
import algorithms.merge_in_place_sort
import algorithms.quick_sort
import algorithms.smooth_sort
import algorithms.api_sort
import utils.CSVMaker


MAX_TWO_POW = 15
ALGO_ITERATIONS = 1000

def create_unsorted_array(int size, Random rand) {
    def table = []
    (1..size).each {
        table << rand.nextInt(3 * size)
    }
    return table
}

def run_one_sort(Closure c, iterations, max_pow) {
    Random rand = new Random()
    def means = new HashMap()
    for (int i = 1; i <= max_pow; i++) {
        sz = 2**i
        println("Run algorithms for arrays of size 2^" + i)
        def results = []
        for (int j = 0; j < iterations; j++) {
            def table = create_unsorted_array(sz, rand)
            def start = System.currentTimeMillis()
            c(table)
            def now = System.currentTimeMillis()
            results << now - start
        }
        def mean = results.sum() / results.size()
        means.put(sz, mean)
    }
    return means
}


def run_sorts(List<Closure> closures, iterations, max_pow) {
    Random rand = new Random()
    List<Map<Integer, Integer>> meansList = new ArrayList<>()
    List<List<Integer>> resultsList = new ArrayList<>()
    for (int i = 0; i < closures.size(); i++) {
        meansList.add(new HashMap<Integer, Integer>())
        resultsList.add([])
    }
    for (int i = 1; i <= max_pow; i++) {
        sz = 2**i
        println("Run algorithms for arrays of size 2^" + i)
        for (int j = 0; j < iterations; j++) {
            def table = create_unsorted_array(sz, rand)
            for (int k = 0; k < closures.size(); k++) {
                def c = closures.get(k)
                def start = System.currentTimeMillis()
                c(table)
                def now = System.currentTimeMillis()
                def results = resultsList.get(k)
                results << now - start
            }
        }
        for (int j = 0; j < closures.size(); j++) {
            def results = resultsList.get(j)
            def mean = results.sum() / results.size()
            meansList.get(j).put(sz, mean)
        }
    }
    return meansList
}

sorting_algorithms = [new insertion_sort().&run,
                      new heap_sort().&run,
                      new merge_in_place_sort().&run,
                      new smooth_sort().&run,
                      new api_sort().&run,
                      new quick_sort(algorithms.quick_sort.Pivot.RANDOM).&run]

sorting_algorithms_names = ["insertionSort.txt",
                            "heapSort.txt",
                            "mergeSort.txt",
                            "smoothSort.txt",
                            "apiSort.txt",
                            "quickSort.txt"]


sorting_algorithms_quicksort = [new quick_sort(algorithms.quick_sort.Pivot.FIRST).&run,
                      new quick_sort(algorithms.quick_sort.Pivot.RANDOM).&run,
                      new quick_sort(algorithms.quick_sort.Pivot.MEDIAN3).&run,
                      new quick_sort(algorithms.quick_sort.Pivot.MEDIAN5).&run]

sorting_algorithms_names_quicksort = ["quickSort-First.txt",
                            "quickSort-Random.txt",
                            "quickSort-Median-3.txt",
                            "quickSort-Median-5.txt"]


create_output_files(sorting_algorithms, sorting_algorithms_names)
create_output_files(sorting_algorithms_quicksort, sorting_algorithms_names_quicksort)

private void create_output_files(List<Closure<List<? extends Object>>> sorting_algorithms, List<String> sorting_algorithms_names) {
    List<Map<Integer, Integer>> results = run_sorts(sorting_algorithms, ALGO_ITERATIONS, MAX_TWO_POW)
    for (int i = 0; i < sorting_algorithms_names.size(); i++) {
        new CSVMaker(results[i]).generateResultsFile(sorting_algorithms_names[i])
    }
}