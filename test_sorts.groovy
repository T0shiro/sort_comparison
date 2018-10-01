def test_sort(List<Integer> start_array, List<Integer> sorted_array){
    start_array.sort()
    for (int i = 0; i < start_array.size(); i++) {
        if (start_array[i] != sorted_array[i]){
            return false
        }
    }
    return true
}
