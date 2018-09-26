def run(List<Integer> values){
    for (int i = 1; i < values.size(); i++) {
        index = i
        while (index > 0 && values.get(index-1) > values.get(index)){
            temp = values.get(index)
            values.set(index, values.get(index-1))
            values.set(index-1, temp)
            index --
        }
    }
    print(values)
}