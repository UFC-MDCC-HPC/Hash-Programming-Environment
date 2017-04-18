tempfile="${1##*/}"
mcrl22lps $1 "${tempfile%.*}".lps 
lps2lts "${tempfile%.*}".lps "${tempfile%.*}".lts 
#ltsgraph "${tempfile%.*}".lts &
tempfile2="${2##*/}"
lps2pbes "${tempfile%.*}".lps -f $2 "${tempfile2%.*}".pbes
pbes2bool "${tempfile2%.*}".pbes

