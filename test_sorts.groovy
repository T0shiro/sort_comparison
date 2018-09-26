import algorithms.insertion_sort
import algorithms.heap_sort
import algorithms.merge_sort
import java.util.Random




def insertionSort = new insertion_sort()
def mergeSort = new merge_sort()
def heapSort = new heap_sort()

//print(insertionSort.run([34,24,12]))

Random rand = new Random()

for (int i = 1; i < 16; i++) {
    def means = new HashMap()
    sz = 2**i
    def results = []
    for (int j = 0; j < 1000; j++) {
        def table = []
        (1..sz).each {
            table << rand.nextInt(2*sz)
        }
        def start = System.currentTimeMillis()
        insertionSort.run(table)
        def now = System.currentTimeMillis()
        results << now - start
    }
    def mean = results.sum()/results.size()
    means.put(sz, mean)
}

