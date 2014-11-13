library(ggplot2)
library(plyr)

NEI <- readRDS("summarySCC_PM25.rds")
SCC <- readRDS("Source_Classification_Code.rds")

## Emissions from motor vehicles include ONROAD motors:
## 1.Light Duty Vehicles 2.Light Duty Trucks 3.Heavy Duty Veh 2B thru 8B & Buses 
baltimore <- NEI[NEI$fips == "24510", ]
california <- NEI[NEI$fips == "06037", ]
bal.onroad <- baltimore[baltimore$type == "ON-ROAD", ]
cal.onroad <- california[california$type == "ON-ROAD", ]

cc.code1 <- SCC$SCC[grep("Light Duty Vehicles", SCC$Short.Name)]
cc.code2 <- SCC$SCC[grep("Light Duty Trucks", SCC$Short.Name)]
cc.code3 <- SCC$SCC[grep("Heavy Duty Veh 2B thru 8B & Buses", SCC$Short.Name)]

b1 <- subset(bal.onroad, SCC %in% cc.code1)
b2 <- subset(bal.onroad, SCC %in% cc.code2)
b3 <- subset(bal.onroad, SCC %in% cc.code3)
b <- rbind(b1, b2, b3)

c1 <- subset(cal.onroad, SCC %in% cc.code1)
c2 <- subset(cal.onroad, SCC %in% cc.code2)
c3 <- subset(cal.onroad, SCC %in% cc.code3)
c <- rbind(c1, c2, c3)

bal <- ddply(b, .(year, fips), summarise, sum=sum(Emissions))
cal <- ddply(c, .(year, fips), summarise, sum=sum(Emissions))

s <- rbind(bal, cal)
png(filename = "pm6.png", width = 500, height = 500, units = "px")

g <- ggplot(data = s, aes(x=year, y=sum, type = fips, color = fips)) 
p <- g + geom_point() + geom_line() + labs(x = "Year") + labs(y = "Total Emissions") + labs(title = "Total Motor Vehicle Emissions Change: Baltimore V.S. LosAngeles")
print(p)
dev.off()