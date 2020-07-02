package com.iloremipsumshowcase.blog;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface IpsumPostRepository extends CrudRepository<IpsumPost,Long>{
    IpsumPost findByIpsumName(String ipsumName);
    IpsumPost findAllByAuthor(Long id);
}
