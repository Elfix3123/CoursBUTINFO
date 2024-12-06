set title "Programme tableau1d-auto"

set xlabel "Taille du tableau en octets"
set logscale x 2
set format x "2^{%L}"
set xtics 2**10, 2**2, 2**36
set ylabel "Nb d'accès par seconde"
set grid
plot [:1e+11][:] "resu.data" using 1:2 title "resu.data" with lines

pause -1  "Appuyer sur Entrée ..."
