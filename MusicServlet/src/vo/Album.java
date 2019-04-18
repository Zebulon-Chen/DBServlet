package vo;

import java.sql.Blob;
import java.sql.Date;

public class Album {
    private int id;
    private Blob img;
    private String name;
    private double price;
    private int al_si_id;
    private Date release_date;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Blob getImg() {
        return img;
    }

    public void setImg(Blob img) {
        this.img = img;
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

    public int getAl_si_id() {
        return al_si_id;
    }

    public void setAl_si_id(int al_si_id) {
        this.al_si_id = al_si_id;
    }
    
    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }
}