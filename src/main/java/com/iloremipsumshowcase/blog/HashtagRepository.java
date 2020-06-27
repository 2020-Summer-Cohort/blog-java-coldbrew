package com.iloremipsumshowcase.blog;

import org.springframework.data.repository.CrudRepository;

public interface HashtagRepository extends CrudRepository<Hashtag, Long> {
    Hashtag findHashtagById(Long id);
}


