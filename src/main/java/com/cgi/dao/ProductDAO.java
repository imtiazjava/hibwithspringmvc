package com.cgi.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cgi.model.Product;

@Component
public class ProductDAO {

	
	@Autowired
	private HibernateTemplate template;
		
	public ProductDAO() {
		
	}

	@Transactional
	public void addProduct(Product product) {
		this.template.save(product);
		
	}

	public List<Product> getAllProducts() {
		return this.template.loadAll(Product.class);
	}
	
	@Transactional
	public void deleteById(int id) {
		Product pr=template.load(Product.class, id);//searching  the product based on id once it get 
		if(pr!=null)
		template.delete(pr);
		
	}

}
