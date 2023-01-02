package com.first;

import org.springframework.data.repository.CrudRepository;

/*
 * CrudRepository is an interface provided by spring framework.
 * It provide several methods for interacting with database.
 * CrudRepository contains methods for CRUD operations.
 */
public interface ProductRepository extends CrudRepository<Product,Integer>
{

}
