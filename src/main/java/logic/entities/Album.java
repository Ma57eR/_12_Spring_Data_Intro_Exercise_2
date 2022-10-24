package logic.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "albums")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String color;

    @ManyToOne
    private User user;

    @Column(nullable = false, name = "public_album")
    private boolean publicAlbum;


    @ManyToMany
    private Set<Picture> pictures = new java.util.LinkedHashSet<>();


    public Album(String name, String color, User user) {

        this.name = name;
        this.color = color;
        this.user = user;
        this.publicAlbum = true;
        this.pictures = new HashSet<>();
    }

    public Album() {
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isPublicAlbum() {
        return publicAlbum;
    }

    public void setPublicAlbum(boolean publicAlbum) {
        this.publicAlbum = publicAlbum;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }
}