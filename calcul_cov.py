import numpy


def getCoeffFor(sortName):
    file = open(sortName + ".txt", "r")
    lines = file.readlines()
    file.close()
    x = []
    y = []
    for line in lines:
        tab = line.split()
        if int(tab[0]) > 256:
            x.append(int(tab[0]))
            y.append(float(tab[1]))
    covariance = numpy.cov(numpy.log(x), numpy.log(y))
    return covariance[1][0] / covariance[0][0]


sorts = ["quickSort", "quickSort-First", "quickSort-Median-3", "quickSort-Median-5", "quickSort-Random"]
for sort in sorts:
    print(sort + " : " + str(getCoeffFor(sort)))

	
sorts = ["apiSort", "heapSort", "insertionSort", "mergeSort", "quickSort", "smoothSort"]
for sort in sorts:
    print(sort + " : " + str(getCoeffFor(sort)))