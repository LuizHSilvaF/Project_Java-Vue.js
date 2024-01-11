package back.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import back.project.entities.TypeProduct;
import back.project.service.TypeProductService;

@RestController
@RequestMapping(value = "/tipos")
@CrossOrigin(origins = "http://localhost:8081")
public class TypeProductController {

	@Autowired
	private TypeProductService service;

	@GetMapping(value = "/getTipos")
	public List<TypeProduct> getTipos(){
		return service.getTipos();
	}
}
