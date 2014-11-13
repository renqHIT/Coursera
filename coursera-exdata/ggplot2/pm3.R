library(ggplot2)
library(plyr)

NEI <- readRDS("summarySCC_PM25.rds")
SCC <- readRDS("Source_Classification_Code.rds")

baltimore <- NEI[NEI$fips == "24510", ]
bal <- ddply(baltimore, .(type,year), summarise, sum=sum(Emissions))

png(filename = "pm3.png", width = 500, height = 500, units = "px")

g <- ggplot(data = bal, aes(x=year, y=sum, group=type, colour=type, shape=type)) 
p <- g + geom_point() + geom_line()
print(p)
dev.off()