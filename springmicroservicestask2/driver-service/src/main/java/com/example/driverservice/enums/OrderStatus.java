package com.example.driverservice.enums;

public enum OrderStatus {
    CREATED, ASSIGNED, INPROGRESS, CLOSED;

    public static OrderStatus update(OrderStatus orderStatus) {
        if (orderStatus == OrderStatus.CREATED) {
            return OrderStatus.ASSIGNED;
        }
        if (orderStatus == OrderStatus.ASSIGNED) {
            return OrderStatus.INPROGRESS;
        }
        if (orderStatus == OrderStatus.INPROGRESS) {
            return OrderStatus.CLOSED;
        } else {
            return OrderStatus.CLOSED;
        }
    }
}
