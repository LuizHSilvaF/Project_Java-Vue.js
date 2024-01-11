package back.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import back.project.entities.Product;
import back.project.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;
	
	public List<Product> findAll() {
		return repo.findAll();
	}
	
	public List<Product> findByName(String name){
		return repo.findByName(name);
	}
	
	public Product Create(Product entity) {
		return repo.save(entity);
	}
	
	public void Delete(Long id) {
		repo.deleteById(id);
	}
	
	public Product Update(Long id, Product body) {
		Product old = repo.findById(id).get();
		old.setName(body.getName());
		old.setPrice(body.getPrice());
		old.setTipo(body.getTipo());
		old.setQuantity(body.getQuantity());
		return repo.save(old);
	}
}
