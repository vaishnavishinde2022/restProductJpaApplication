package com.first;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/*
 * bellow Model class acts as a model class and interact with database.
 */
@Component
public class ProductModel
{
  @Autowired
  //repo is an reference variable of ProductRepository.
  //with the help of repo we can call CRUD Methods to interact with database.
  
  ProductRepository repo;
  
  /*
   * createProduct() this method is for to create new Product i.e. to store new record/tuple in table. 
   */
	public Product createProduct(Product proObj)
	{
		Product result=repo.save(proObj);
		
		return result;
		
	}//createProduct
	
	/*
	 * getAllProducts() this method is to retrive all records(products) from the database table.
	 */
	
	public ArrayList<Product> getAllProducts()
	{
		ArrayList<Product> list;
		
		/*
		 * Iterable interface allows an object to be the target of for-each-loop
		 */
		Iterable<Product> itr=repo.findAll();
		
		list=(ArrayList<Product>) itr;
		
		return list;
		
		
	}//getAllProducts
	
	/*
	 * updateProduct() this method is used to update the product
	 */
	public Product updateProduct(int id,Product pro)
	{
		Product proObj1;
		Optional<Product> optinal=repo.findById(id);
		
		proObj1=optinal.get();
		
		proObj1.setProductname(pro.getProductname());
		proObj1.setProductPrice(pro.getProductPrice());
		proObj1.setProductDescription(pro.getProductDescription());
		
		Product result=repo.save(proObj1);
		
		return result;
		
	}//updateProduct
	
	/*
	 * deleteProduct() this method is for to delete the product
	 */
	public String deleteProduct(int id)
	{
		repo.deleteById(id);
		
		return "deleted";
		
		
	}//deleteProduct
}
