package com.iloremipsumshowcase.blog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Objects;

@Entity
public class IpsumCategory {
    @Id
    @GeneratedValue
    private long id;
    private String categoryName;
    private String description;
    @OneToMany(mappedBy = "ipsumCategory" )
    private Collection<IpsumPost> ipsumPosts;

    protected IpsumCategory(){}
    public IpsumCategory(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getDescription() {
        return description;
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
        IpsumCategory that = (IpsumCategory) o;
        return id == that.id &&
                Objects.equals(categoryName, that.categoryName) &&
                Objects.equals(description, that.description) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryName, description);
    }

    @Override
    public String toString() {
        return "IpsumCategory{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
