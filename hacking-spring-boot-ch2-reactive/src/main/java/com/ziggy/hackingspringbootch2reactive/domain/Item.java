package com.ziggy.hackingspringbootch2reactive.domain;

import java.util.Date;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;

public class Item {
    private @Id String id;
    private String name;
    private double price;
    private String description;
    private String distributorRegion;
    private Date releaseDate;
    private int availableUnits;
    private Point location;
    private boolean active;


    private Item() {
    }

    public Item(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDistributorRegion() {
        return distributorRegion;
    }

    public void setDistributorRegion(String distributorRegion) {
        this.distributorRegion = distributorRegion;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getAvailableUnits() {
        return availableUnits;
    }

    public void setAvailableUnits(int availableUnits) {
        this.availableUnits = availableUnits;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return Double.compare(price, item.price) == 0 && availableUnits == item.availableUnits
                && active == item.active && Objects.equals(id, item.id) && Objects.equals(name,
                item.name) && Objects.equals(description, item.description) && Objects.equals(
                distributorRegion, item.distributorRegion) && Objects.equals(releaseDate, item.releaseDate)
                && Objects.equals(location, item.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, description, distributorRegion, releaseDate, availableUnits, location,
                active);
    }
}
