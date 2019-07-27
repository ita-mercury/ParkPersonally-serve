package com.parkpersonally.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;
import java.util.List;

@Entity
public class ParkingOrder {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    @NotNull
    private int status;

    @Column(nullable = false)
    @NotNull
    private int type;

    @Column(nullable = false)
    @NotNull
    private int positionNnumer;

    @Column(nullable = false)
    @NotNull
    private String comments;

    @Column(nullable = false)
    @NotNull
    private String fetchCarAddress;

    @Column(nullable = false)
    @NotNull
    private long creatTime = System.currentTimeMillis();

    @ManyToOne(fetch = FetchType.EAGER)
    private ParkingBoy parkingBoy;

    @OneToOne(fetch = FetchType.EAGER)
    private ParkingLot parkingLot;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Tag> tags;

    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPositionNnumer() {
        return positionNnumer;
    }

    public void setPositionNnumer(int positionNnumer) {
        this.positionNnumer = positionNnumer;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getFetchCarAddress() {
        return fetchCarAddress;
    }

    public void setFetchCarAddress(String fetchCarAddress) {
        this.fetchCarAddress = fetchCarAddress;
    }

    public long getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(long creatTime) {
        this.creatTime = creatTime;
    }

    public ParkingBoy getParkingBoy() {
        return parkingBoy;
    }

    public void setParkingBoy(ParkingBoy parkingBoy) {
        this.parkingBoy = parkingBoy;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
}
