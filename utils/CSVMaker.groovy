results = [:]

/**
 * Add an execution result
 * @param nbValues number of values sorted
 * @param execTime execution time
 */
def addResult(int nbValues, double execTime) {
    results[nbValues] = execTime
}

/**
 * Generates the file containing the results to be analyzed.
 * Each line represents an execution and contains two values separated by a space :
 * the number of values sorted and the execution time
 * @param filename
 * @return
 */
def generateResultsFile(String filename) {
    def file = new File(filename)
    if (file.exists()) {
        file.delete()
    }
    results.each { k, v -> file << k + " " + v + '\n' }
}

addResult(1, 4d)
addResult(2, 8d)
addResult(15, 57d)
generateResultsFile("results.txt")