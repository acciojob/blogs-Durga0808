package com.driver.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int blogId;
    private String title;
    private String content;
    @CreationTimestamp
    private Date publicationDate;

    @ManyToOne
    @JoinColumn
    private User user;


    @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL)
    @JoinColumn
    private List<Image> imageList;

    public Blog() {
    }

    public Blog(User user, String title, String content) {
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    public Blog(int blogId, String title, String content, Date publicationDate, User user, List<Image> imageList) {
        this.blogId = blogId;
        this.title = title;
        this.content = content;
        this.publicationDate = publicationDate;
        this.user = user;
        this.imageList = imageList;
    }
}