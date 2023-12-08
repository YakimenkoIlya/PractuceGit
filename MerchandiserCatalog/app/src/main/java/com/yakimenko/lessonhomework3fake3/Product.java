package com.yakimenko.lessonhomework3fake3;

public class Product {

    private int id;
    private String name;
    private String type;
    private String provider;
    private String store;

    public Product(String name, String type, String provider, String store) {
        this.name = name;
        this.type = type;
        this.provider = provider;
        this.store = store;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }
}
