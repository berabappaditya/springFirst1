package com.example.springFirst1;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springFirst1.models.Category;
import com.example.springFirst1.models.Product;
import com.example.springFirst1.repositories.CategoryRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
class SpringFirst1ApplicationTests {

	@Autowired
	private CategoryRepository categoryRepository;

	@Test
	void contextLoads() {
	}

	@Test
	@Transactional
	void testCategoryRepository() {
		Optional<Category> category = categoryRepository.findById(1L);
		 
		Category category1 = (Category) category.get();
		System.out.println("Fetching product related to category");
		List<Product> products= category1.getProducts();
	}

}
