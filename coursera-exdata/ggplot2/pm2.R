NEI <- readRDS("summarySCC_PM25.rds")
SCC <- readRDS("Source_Classification_Code.rds")

baltimore <- NEI[NEI$fips == "24510", ]

em99 <- baltimore[baltimore$year == 1999, ]
em02 <- baltimore[baltimore$year == 2002, ]
em05 <- baltimore[baltimore$year == 2005, ]
em08 <- baltimore[baltimore$year == 2008, ]

total_em99 <- sum(em99$Emissions)
total_em02 <- sum(em02$Emissions)
total_em05 <- sum(em05$Emissions)
total_em08 <- sum(em08$Emissions)

total_em <- c(total_em99, total_em02, total_em05, total_em08)

png(filename = "pm2.png", width = 500, height = 500, units = "px")
plot(c(1999, 2002, 2005, 2008), total_em, type = "l", col = "red", xlab = "Year", ylab = "Total PM2 Emissions")
dev.off()