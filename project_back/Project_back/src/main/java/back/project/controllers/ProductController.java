package back.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import back.project.entities.Product;
import back.project.service.ProductService;

@RestController
@RequestMapping(value = "/products")
@CrossOrigin(origins = "http://localhost:8081")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping(value = "/findAll")
	public List<Product> findAll(){
		return service.findAll();
	}
	
	@GetMapping(value = "/findByName")
	public List<Product> findByName(@RequestParam String name){
		return service.findByName(name);
	}
	
	@PostMapping(value = "/create")
	public Product Create(@RequestBody Product entity) {
		return service.Create(entity);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void Delete(@PathVariable Long id) {
		service.Delete(id);
	}
	
	@PutMapping(value = "/update/{id}")
	public Product Update(@PathVariable Long id,@RequestBody Product body) {
		return service.Update(id, body);
	}
}
