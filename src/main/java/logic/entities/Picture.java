package logic.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "pictures")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;


    private String caption;

    @ManyToMany
    private Set<Album> albums;

    public Picture() {
    }

    public Picture(String title, String caption) {

        this.title = title;
        this.caption = caption;
        this.albums = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }
}