set grid lw 3
set logscale xy 2
set xlabel "Number of elements"
set ylabel "Execution time"
set terminal svg
plot for [file in files] file with lines