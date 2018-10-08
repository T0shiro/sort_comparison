package algorithms

class merge_sort {
    def run(List<Integer> values){
        if (values.size() <= 1){
            return values
        }
        return fusion(run(values.subList(0, values.size().intdiv(2))), run(values.subList(values.size().intdiv(2), values.size())))
    }

    def fusion(List<Integer> A, List<Integer> B){
        if (A.empty) {
            return B
        }
        if (B.empty){
            return A
        }
        if (A.get(0) <= B.get(0)){
            return addElement(A.get(0), fusion(A.subList(1,A.size()), B))
        }else {
            return addElement(B.get(0), fusion(A, B.subList(1, B.size())))
        }
    }

    private List<Integer> addElement(int i, List<Integer> list){
        def l = [i]
        l.addAll(list)
        return l
    }
}
