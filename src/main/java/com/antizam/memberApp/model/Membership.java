package com.antizam.memberApp.model;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Min(value = 0, message = "The value must be positive")
    @NotNull(message = "Amount can not be null")
    private BigDecimal amount;

    @Size(min = 2, max = 50, message = "Description size must be between 2 and 50")
    private String description;

    @Column(name = "date_paid")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate datePaid;

    @Column(name = "is_paid")
    @NotNull
    private boolean paid;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    private Member member;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDatePaid() {
        return datePaid;
    }

    public void setDatePaid(LocalDate datePaid) {
        this.datePaid = datePaid;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
