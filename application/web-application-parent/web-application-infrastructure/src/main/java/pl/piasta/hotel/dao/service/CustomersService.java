package pl.piasta.hotel.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piasta.hotel.dao.model.CustomersEntity;
import pl.piasta.hotel.dao.repository.CustomersRepository;

import java.util.List;

@Service
public class CustomersService {

	private final CustomersRepository customersRepository;

	@Autowired
	public CustomersService(CustomersRepository customersRepository) {
		this.customersRepository = customersRepository;
	}

	public List<CustomersEntity> findAll() {
		return customersRepository.findAll();
	}

	public long count() {
		return customersRepository.count();
	}

	public void delete(CustomersEntity customersEntity) {
		customersRepository.delete(customersEntity);
	}

	public void save(CustomersEntity customersEntity) {
		if (customersEntity == null) {
			return;
		}
		customersRepository.save(customersEntity);
	}

}
