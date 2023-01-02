package com.first;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
public class ProductController
{
 
	@Autowired
	ProductModel productObj;
			
	@PostMapping("/add")
	/*
	 * ResponseEntity is an class present in org.springframework.http package.
	 * It represents the whole responses: http status code,header and body.
	 */
	public ResponseEntity<Product> createProduct(@RequestBody Product proObj)
	{
		Product proObj1=null;
		
		try
		{
			proObj1=productObj.createProduct(proObj);
			
			return ResponseEntity.of(Optional.of(proObj1));
			
		}//try
		
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}//catch
		
	}//createProduct
	

	@GetMapping("/products")
	public ResponseEntity<ArrayList<Product>> getAllProducts()
	{
		ArrayList<Product> arrayList;
		
		try
		{
			arrayList=productObj.getAllProducts();
			
			return ResponseEntity.of(Optional.of(arrayList));
			
			
		}//try
		
		catch(Exception e)
		{
		  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}//ProductController
	
	@PutMapping("/update/{id}")
	/*
	 * @RequestBody this annotation indicates that spring should deserialize a request body
	 * into an object
	 */
	 public ResponseEntity<Product> updateProduct(@RequestBody Product proObj,@PathVariable("id")int id)
	 {
		 Product pro1;
		 
		 try
		 {
			 pro1=productObj.updateProduct(id,proObj);
			 
			 return ResponseEntity.of(Optional.of(pro1));
			 
		 }//try
		 
		 catch(Exception e)
		 {
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		 }//catch
	 }//updateProduct
	
	@DeleteMapping("/delete/{id}")
	
	public ResponseEntity<Optional> deleteProduct(@PathVariable("id")int id)
	{
		String msg=productObj.deleteProduct(id);
		if(msg.equals("deleted"))
		{
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		
		else
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}//clas ProductController

 
