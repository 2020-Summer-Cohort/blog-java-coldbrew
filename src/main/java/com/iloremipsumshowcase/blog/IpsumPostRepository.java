package com.iloremipsumshowcase.blog;

import org.springframework.data.repository.CrudRepository;

public interface IpsumPostRepository extends CrudRepository<IpsumPost,Long>{
    IpsumPost findByIpsumName(String ipsumName);
}
