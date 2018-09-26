package algorithms

class merge_sort {
    def run_merge_sort(List<Integer> values){
        if (values.size() <= 1){
            return values
        }
        return fusion(run_merge_sort(values.subList(0, values.size().intdiv(2))), run_merge_sort(values.subList(values.size().intdiv(2), values.size())))
    }

    def fusion(List<Integer> A, List<Integer> B){
        if (A.empty) {
            return B
        }
        if (B.empty){
            return A
        }
        if (A.get(0) <= B.get(0)){
            return [A.get(0)] + fusion(A.subList(1,A.size()), B)
        }else {
            return [B.get(0)] + fusion(A, B.subList(1, B.size()))
        }
    }
}
