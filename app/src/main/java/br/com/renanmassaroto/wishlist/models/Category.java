package br.com.renanmassaroto.wishlist.models;

/**
 * Created by renan on 02/12/15.
 */
public class Category {

    private long id;
    private String name;
    private String primaryColor;
    private String lighterColor;

    public Category() {

    }

    public Category(String name, String primaryColor, String lighterColor) {
        this.name = name;
        this.primaryColor = primaryColor;
        this.lighterColor = lighterColor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(String primaryColor) {
        this.primaryColor = primaryColor;
    }

    public String getLighterColor() {
        return lighterColor;
    }

    public void setLighterColor(String lighterColor) {
        this.lighterColor = lighterColor;
    }
}
