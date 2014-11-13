#Read data
names =  c("Date", "Time", "Global_active_power", "Global_reactive_power", "Voltage", "Global_intensity", 
           "Sub_metering_1", "Sub_metering_2", "Sub_metering_3")
classes = c("character","character", "numeric", "numeric", "numeric", "numeric", "numeric", "numeric", "numeric")
data <- read.table("household_power_consumption.txt", header = TRUE, sep = ";",nrows = 210000, 
                   na.strings = "?", col.names = names, colClasses = classes)

sub_data <- data[data$Date == "1/2/2007" | data$Date == "2/2/2007",] 

#Plot
png(filename = "plot1.png", width = 480, height = 480, units = "px")
hist(sub_data$Global_active_power, col = "red", main = "Global Active Power", xlab = "Global Active Power (kilowatts)")
dev.off()
