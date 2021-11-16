package com.example.orderservice.entity;

import com.example.orderservice.enums.OrderStatus;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private long customerId;

    @Column(nullable = false)
    private String customerFirstName;

    @Column(nullable = false)
    private long customerPhoneNumber;

    @Column
    private long driverId;

    @Column
    private LocalDateTime orderTime;

    @Column
    private String addressFrom;

    @Column
    private String addressTo;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @PrePersist
    protected void onCreate() {
        orderTime = LocalDateTime.now();
        orderStatus = OrderStatus.CREATED;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrderEntity that = (OrderEntity) o;
        return id != 0 && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
