package com.example.demo.store;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Store.findAll", query = "SELECT s FROM Store s"),
        @NamedQuery(name = "Store.findById", query = "SELECT s FROM Store s WHERE s.id = :id")
})
public class Store {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String branch;
    private String location;

    public Store() {
    }

    public Store(Long id, String name, String branch, String location) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
