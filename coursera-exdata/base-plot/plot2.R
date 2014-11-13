#Read data
names =  c("Date", "Time", "Global_active_power", "Global_reactive_power", "Voltage", "Global_intensity", 
           "Sub_metering_1", "Sub_metering_2", "Sub_metering_3")
classes = c("character","character", "numeric", "numeric", "numeric", "numeric", "numeric", "numeric", "numeric")
data <- read.table("household_power_consumption.txt", header = TRUE, sep = ";",nrows = 210000, 
                   na.strings = "?", col.names = names, colClasses = classes)

sub_data <- data[data$Date == "1/2/2007" | data$Date == "2/2/2007",] 

#combine Date and Time, called datetime
#strptime converts character strings to class "POSIXlt"
datetime <- paste(sub_data$Date, sub_data$Time)
times <- strptime(datetime, "%d/%m/%Y %H:%M:%S")

# To avoid Chinese character for weekdays
Sys.setlocale("LC_TIME","US")

## Plot
png(filename = "plot2.png", width = 480, height = 480, units = "px")
with(sub_data, plot(times, Global_active_power, type = "l", xlab = "", ylab = "Global Active Power (kilowatts)"))
dev.off()
