#!/bin/bash

gnuplot -p -e "files='$(ls *Sort.txt)'" utils/plot.gnu > output.svg