package Restaurant;

import java.time.LocalDateTime;

public class Reservation {
    private final int tableNumber;
    private final String customerName;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;

    public Reservation(int tableNumber, String customerName,
                       LocalDateTime startTime, LocalDateTime endTime) {
        this.tableNumber = tableNumber;
        this.customerName = customerName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "tableNumber=" + tableNumber +
                ", customerName='" + customerName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}

