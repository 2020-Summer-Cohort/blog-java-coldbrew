package com.iloremipsumshowcase.blog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Author {
    @Id
    @GeneratedValue
    private long id;
    private String authorName;


    @OneToMany (mappedBy = "author")
    private Collection<IpsumPost> ipsumPosts;

    protected Author(){}

    public String getAuthorName() {
        return authorName;
    }

    public Author(String authorName) {
        this.authorName = authorName;


    }


    public Collection<IpsumPost> getIpsumPosts() {
        return ipsumPosts;
    }
    public long getId() {
        return id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id &&
                Objects.equals(authorName, author.authorName) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, authorName);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", authorName='" + authorName  +
                '}';
    }
}
