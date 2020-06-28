package com.iloremipsumshowcase.blog;

import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    Author findAuthorById(Long id);
    Author findByAuthorName(String authorName);
}
