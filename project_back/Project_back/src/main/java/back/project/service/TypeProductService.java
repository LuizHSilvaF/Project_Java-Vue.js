package back.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import back.project.entities.TypeProduct;
import back.project.repositories.TypeProductRepository;

@Service
public class TypeProductService {

	@Autowired
	private TypeProductRepository repo;
	
	public List<TypeProduct> getTipos(){
		return repo.findAll();
	}
}
