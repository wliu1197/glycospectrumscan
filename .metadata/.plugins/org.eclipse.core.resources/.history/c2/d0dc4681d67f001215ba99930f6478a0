### R code from vignette source 'mzR.Rnw'

###################################################
### code chunk number 1: open the file
###################################################
library(mzR)
library(msdata)

mzxml <- system.file("threonine/threonine_i2_e35_pH_tree.mzXML", 
                     package = "msdata")
aa <- openMSfile(mzxml)


###################################################
### code chunk number 2: get header information
###################################################
runInfo(aa)
instrumentInfo(aa)
header(aa,1)


###################################################
### code chunk number 3: plotspectrum
###################################################
pl <- peaks(aa,10)
peaksCount(aa,10)
head(pl)
plot(pl[,1], pl[,2], type="h", lwd=1)


###################################################
### code chunk number 4: close the file
###################################################
close(aa)


###################################################
### code chunk number 5: sessioninfo
###################################################
  toLatex(sessionInfo())


