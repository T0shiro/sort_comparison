package algorithms

class insertion_sort {
    def run(list){
        def size = list.size()
        (1..<size).each { i ->
            def value = list[i]
            def j = i - 1
            for (; j >= 0 && list[j] > value; j--) {
                list[j+1] = list[j]
            }
            list[j+1] = value
        }
        return list
    }
}