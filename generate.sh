#!/bin/bash

gnuplot -p -e "files='$(ls *Sort.txt)'" utils/plot.gnu > output.svg
gnuplot -p -e "files='$(ls quickSort-*)'" utils/plot.gnu > outputQuickSort.svg
gnuplot -p -e "files='$(ls threshold-*)'" utils/plot.gnu > outputThreshold.svg