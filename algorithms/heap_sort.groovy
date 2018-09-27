package algorithms

class heap_sort {
    def run(List<Integer> values) {
        heapify(values, values.size())
        int end = values.size() - 1
        while (end > 0) {
            swapValues(end, 0, values)
            end--
            siftDown(values, 0, end)
        }
        return values
    }

    private def heapify(List<Integer> values, int count) {
        int start = getParent(count - 1)
        while (start >= 0) {
            siftDown(values, start, count - 1)
            start--
        }
    }

    private def siftDown(List<Integer> values, int start, int end) {
        int root = start
        while (getLeftChild(root) <= end) {
            int child = getLeftChild(root)
            int swap = root
            if (values[swap] < values[child]) {
                swap = child
            }
            if (child + 1 <= end && values[swap] < values[child + 1]) {
                swap = child + 1
            }
            if (swap == root) {
                return
            } else {
                swapValues(root, swap, values)
                root = swap
            }
        }
    }

    private def swapValues(int a, int b, List<Integer> values) {
        int tmp = values[a]
        values[a] = values[b]
        values[b] = tmp
    }

    private def getParent(int index) {
        (int) Math.floor((index - 1) / 2)
    }

    private def getLeftChild(int index) {
        2 * index + 1
    }

    private def getRightChild(int index) {
        2 * index + 2
    }

    static void main(String[] args) {
        println new heap_sort().run([10, 9, 8, 7, 6])
    }
}
