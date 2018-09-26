package algorithms

class insertion_sort {
    def run_insertion_sort(List<Integer> values){
        for (int i = 1; i < values.size(); i++) {
            def index = i
            while (index > 0 && values.get(index-1) > values.get(index)){
                def temp = values.get(index)
                values.set(index, values.get(index-1))
                values.set(index-1, temp)
                index --
            }
        }
        return values
    }
}