package com.iloremipsumshowcase.blog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Hashtag {
    @Id
    @GeneratedValue
    private long id;
    private String hashtagName;
//    @ManyToMany
    @ManyToMany(mappedBy = "hashtags")
    private Collection<IpsumPost> ipsumPosts;

    protected Hashtag(){}

    public Hashtag(String hashtagName, IpsumPost...ipsumPosts) {
        this.hashtagName = hashtagName;
        this.ipsumPosts = new ArrayList<>(Arrays.asList(ipsumPosts));
    }
    public Long getId() {
        return id;
    }

    public String getHashtagName() {
        return hashtagName;
    }

    public Collection<IpsumPost> getIpsumPosts() {
        return ipsumPosts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hashtag hashtag = (Hashtag) o;
        return id == hashtag.id &&
                Objects.equals(hashtagName, hashtag.hashtagName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hashtagName);
    }

    @Override
    public String toString() {
        return "Hashtag{" +
                "id=" + id +
                ", hashtagName='" + hashtagName + '\'' +
                '}';
    }
}
