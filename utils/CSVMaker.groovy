package utils

class CSVMaker {

    private def results

    /**
     * The map contains the results of a series of executions of an algorithm.
     * Key : number of values to sort
     * Value : execution time
     */
    CSVMaker(Map results) {
        this.results = results
    }

    /**
     * Generates the file containing the results to be analyzed.
     * Each line represents an execution and contains two values separated by a space :
     * the number of values sorted and the execution time
     * @param filename name of the file which will be read to generate the graph
     */
    def generateResultsFile(String filename) {
        def file = new File(filename)
        if (file.exists()) {
            file.delete()
        }
        results.each { k, v -> file << k + " " + v + '\n' }
    }

}