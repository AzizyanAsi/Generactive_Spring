package com.example.webik.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "item_details")
public class ItemDetails {

    @Id
    private Long id;

    @Column(name = "description")
    private String description;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "id")
    @MapsId
    private Item item;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDetails that = (ItemDetails) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ItemDetails{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
