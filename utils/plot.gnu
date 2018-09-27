set grid lw 3
set logscale xy 2
set xlabel "Number of elements"
set ylabel "Execution time"
set terminal svg
plot for [file in files] file using 1:2 title file[:strstrt(file, '.txt')-1] with lines smooth unique