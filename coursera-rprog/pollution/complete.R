complete <- function(directory, id = 1:332) {
    setwd("C:/Users/renq/Documents/pollutant")
    files_full <- list.files(directory, full.names = TRUE)
    dat <- data.frame()
    for (i in id){  
        files <- read.csv(files_full[i])
        nobs <- sum(complete.cases(files))
        dat <- rbind(dat, c(i, nobs))
    }
    headings <- c("id", "nobs")
    names(dat) <- headings
    dat
}