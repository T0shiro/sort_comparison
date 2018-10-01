package algorithms

class smooth_sort {
    private int q = 1
    private int r = 0
    private int p = 1
    private int b = 1
    private int c = 1
    private int b1 = 0
    private int c1 = 0
    private int r1 = 0
    private int p1 = 0
    private List<Integer> tab

    def run(List<Integer> values) {
        this.tab = values
        int N = values.size()
        while (q != N) {
            r1 = r
            if (p % 8 == 3) {
                b1 = b
                c1 = c
                sift()
                p = (int) ((p + 1) / 4)
                up()
                up()
            } else if (p % 4 == 1) {
                if (q + c < N) {
                    b1 = b
                    c1 = c
                    sift()
                } else {
                    trinkle()
                }
                down()
                p = 2 * p
                while (b != 1) {
                    down()
                    p = 2 * p
                }
                p += 1
            }
            q += 1
            r += 1
        }
        r1 = r
        trinkle()
        while (q != 1) {
            q -= 1
            if (b == 1) {
                r -= 1
                p -= 1
                while (p % 2 == 0) {
                    p = p / 2
                    up()
                }
            } else if (b >= 3) {
                p -= 1
                r = r - b + c
                if (p > 0) {
                    semitrinkle()
                }
                down()
                p = 2 * p + 1
                r = r + c
                semitrinkle()
                down()
                p = 2 * p + 1
            }
        }
        return tab
    }

    private up() {
        int temp = b
        b += c + 1
        c = temp
    }

    private down() {
        int temp = c
        c = b - c - 1
        b = temp
    }

    private swap(int i, int j) {
        int temp = tab[i]
        tab[i] = tab[j]
        tab[j] = temp
    }

    private down1() {
        int temp = c1
        c1 = b1 - c1 - 1
        b1 = temp
    }

    private up1() {
        int temp = b1
        b1 += c1 + 1
        c1 = temp
    }

    private sift() {
        while (b1 >= 3) {
            int r2 = r1 - b1 + c1
            if (tab[r2] <= tab[r1 - 1]) {
                r2 = r1 - 1
                down1()
            }
            if (tab[r1] >= tab[r2]) {
                b1 = 1
            } else {
                swap(r1, r2)
                r1 = r2
                down1()
            }
        }
    }

    private semitrinkle() {
        r1 = r - c
        if (tab[r1] > tab[r]) {
            swap(r, r1)
            trinkle()
        }
    }

    private trinkle() {
        p1 = p
        b1 = b
        c1 = c
        while (p1 > 0) {
            while (p1 % 2 == 0) {
                p1 = p1 / 2
                up1()
            }
            int r3 = r1 - b1
            if (p1 == 1 || tab[r3] <= tab[r1]) {
                p1 = 0
            } else if (p1 > 1 && tab[r3] > tab[r1]) {
                p1 -= 1
                if (b1 == 1) {
                    swap(r1, r3)
                    r1 = r3
                } else if (b1 >= 3) {
                    int r2 = r1 - b1 + c1
                    if (tab[r2] <= tab[r1 - 1]) {
                        r2 = r1 - 1
                        down1()
                        p1 = 2 * p1
                    }
                    if (tab[r3] >= tab[r2]) {
                        swap(r1, r3)
                        r1 = r3
                    } else {
                        swap(r1, r2)
                        r1 = r2
                        down1()
                        p1 = 0
                    }
                }
            }
        }
        sift()
    }
}
