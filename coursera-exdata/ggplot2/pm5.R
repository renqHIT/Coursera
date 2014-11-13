library(ggplot2)
library(plyr)

NEI <- readRDS("summarySCC_PM25.rds")
SCC <- readRDS("Source_Classification_Code.rds")

## Emissions from motor vehicle sources include ONROAD motors:
## 1.Light Duty Vehicles 2.Light Duty Trucks 3.Heavy Duty Veh 2B thru 8B & Buses 
baltimore <- NEI[NEI$fips == "24510", ]
bal.onroad <- baltimore[baltimore$type == "ON-ROAD", ]

cc.code1 <- SCC$SCC[grep("Light Duty Vehicles", SCC$Short.Name)]
cc.code2 <- SCC$SCC[grep("Light Duty Trucks", SCC$Short.Name)]
cc.code3 <- SCC$SCC[grep("Heavy Duty Veh 2B thru 8B & Buses", SCC$Short.Name)]

s1 <- subset(bal.onroad, SCC %in% cc.code1)
s2 <- subset(bal.onroad, SCC %in% cc.code2)
s3 <- subset(bal.onroad, SCC %in% cc.code3)
s <- rbind(s1, s2, s3)

bal <- ddply(s, .(year), summarise, sum=sum(Emissions))

png(filename = "pm5.png", width = 500, height = 500, units = "px")

g <- ggplot(data = bal, aes(x=year, y=sum)) 
p <- g + geom_point() + geom_line() + labs(x = "Year") + labs(y = "Total Emissions") + labs(title = "Total Motor Vehicle Emissions in Baltimore City")
print(p)
dev.off()