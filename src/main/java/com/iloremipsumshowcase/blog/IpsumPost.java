package com.iloremipsumshowcase.blog;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class IpsumPost {
    @Id
    @GeneratedValue
    private long id;
    private String ipsumName;
    private String ipsumDescription;
    private String ipsumSample;
    private String ipsumSource;
    private String date;
    @ManyToOne
    private IpsumCategory ipsumCategory;
    @ManyToOne
    private Author author;
    @ManyToMany(mappedBy = "ipsumPosts")
    private Collection<Hashtag> hashtags;

    protected IpsumPost(){}





    public IpsumPost(String ipsumName, String ipsumDescription, String ipsumSample, String ipsumSource,
                     String date, IpsumCategory ipsumCategory, Author author, Hashtag...hashtags) {
        this.ipsumName = ipsumName;
        this.ipsumDescription = ipsumDescription;
        this.ipsumSample = ipsumSample;
        this.ipsumSource = ipsumSource;
        this.ipsumCategory = ipsumCategory;
        this.author = author;
        this.date = date;
        this.hashtags = new ArrayList<>(Arrays.asList(hashtags));

    }



    public String getIpsumName() {
        return ipsumName;
    }

    public String getIpsumDescription() {
        return ipsumDescription;
    }

    public String getIpsumSample() {
        return ipsumSample;
    }

    public String getIpsumSource() {
        return ipsumSource;
    }
    public String getDate() { return date;}
    public IpsumCategory getIpsumCategory() {
        return ipsumCategory;
    }
    public Author getAuthor(){
        return author;
    }
    public long getId() {
        return id;
    }
    public Collection<Hashtag> getHashtags() {
        return hashtags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IpsumPost ipsumPost = (IpsumPost) o;
        return id == ipsumPost.id &&
                Objects.equals(ipsumName, ipsumPost.ipsumName) &&
                Objects.equals(ipsumDescription, ipsumPost.ipsumDescription) &&
                Objects.equals(ipsumSample, ipsumPost.ipsumSample) &&
                Objects.equals(ipsumSource, ipsumPost.ipsumSource) &&
                Objects.equals(ipsumCategory, ipsumPost.ipsumCategory) &&
                Objects.equals(author, ipsumPost.author) &&
                Objects.equals(date, ipsumPost.date);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ipsumName, ipsumDescription, ipsumSample, ipsumSource, ipsumCategory, author, date);
    }

    @Override
    public String toString() {
        return "IpsumPost{" +
                "id=" + id +
                ", ipsumName='" + ipsumName + '\'' +
                ", ipsumDescription='" + ipsumDescription + '\'' +
                ", ipsumSample='" + ipsumSample + '\'' +
                ", ipsumSource='" + ipsumSource + '\'' +
                ", ipsumCategory=" + ipsumCategory +
                ", author=" + author +
                '}';
    }
}

