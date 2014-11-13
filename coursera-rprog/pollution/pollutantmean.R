pollutantmean <- function(directory, pollutant, id = 1:332) {
    setwd("C:/Users/renq/Documents/pollutant")
    files_full <- list.files(directory, full.names = TRUE)
    dat <- data.frame()
    for (i in id){  
        dat <- rbind(dat, read.csv(files_full[i]))
    }
    sulfate <- dat$sulfate
    nempty_sulf <- sulfate[!is.na(sulfate)]
    nitrate <- dat$nitrate
    nempty_nitr <- nitrate[!is.na(nitrate)]
    if(pollutant == "sulfate"){
        print(mean(nempty_sulf))
    }
    else{
        print(mean(nempty_nitr))
    }
}