package com.iloremipsumshowcase.blog;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IpsumCategoryRepository extends CrudRepository<IpsumCategory,Long> {
    IpsumCategory findByCategoryName(String categoryName);

}
