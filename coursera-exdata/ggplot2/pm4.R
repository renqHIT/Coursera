library(ggplot2)

NEI <- readRDS("summarySCC_PM25.rds")
SCC <- readRDS("Source_Classification_Code.rds")

## Emissions from coal combustion-related sources include:
## 1.Anthracite Coal 2.Bituminous Coal 3.Subbituminous Coal

coalCode1 <- SCC$SCC[grep("Anthracite Coal", SCC$Short.Name)]
coalCode2 <- SCC$SCC[grep("Bituminous Coal", SCC$Short.Name)]
coalCode3 <- SCC$SCC[grep("Subbituminous Coal", SCC$Short.Name)]

s1 <- subset(NEI, SCC %in% coalCode1)
s2 <- subset(NEI, SCC %in% coalCode2)
s3 <- subset(NEI, SCC %in% coalCode3)
s <- rbind(s1, s2, s3)
us <- ddply(s, .(year), summarise, sum=sum(Emissions))

png(filename = "pm4.png", width = 500, height = 500, units = "px")

g <- ggplot(data = us, aes(x=year, y=sum)) 
p <- g + geom_point() + geom_line() + labs(x = "Year") + labs(y = "Emissions from coal combustion-related sources")
print(p)
dev.off()