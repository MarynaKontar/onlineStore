package com.app.model;

import java.util.Date;

/**
 * Created by User on 04.06.2017.
 */
public class Order {

    long id;
    Product product;
    Date date;
    long userId;
    int amount;

    public Order() {
    }

    public Order(Product product, Date date, long userId, int amount) {
        this.product = product;
        this.date = date;
        this.userId = userId;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return getId() == order.getId();
    }

    @Override
    public int hashCode() {
        return (int) (getId() ^ (getId() >>> 32));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("id=").append(id);
        sb.append(", product=").append(product);
        sb.append(", date=").append(date);
        sb.append(", userId=").append(userId);
        sb.append(", amount=").append(amount);
        sb.append('}');
        return sb.toString();
    }
}
