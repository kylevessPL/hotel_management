package pl.piasta.hotel.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piasta.hotel.dao.model.CustomersEntity;
import pl.piasta.hotel.dao.repository.CustomersRepository;
import pl.piasta.hotel.dao.service.CustomersService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CustomersServiceImpl implements CustomersService {

	private final CustomersRepository customersRepository;

	@Autowired
	public CustomersServiceImpl(CustomersRepository customersRepository) {
		this.customersRepository = customersRepository;
	}

	@Override
	public List<CustomersEntity> findAll() {
		return customersRepository.findAll();
	}

	@Override
	public CustomersEntity findById(Integer id) {
		return customersRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public long count() {
		return customersRepository.count();
	}

	@Override
	public void delete(CustomersEntity customersEntity) {
		customersRepository.delete(customersEntity);
	}

	@Override
	public void save(CustomersEntity customersEntity) {
		if (customersEntity == null) {
			return;
		}
		customersRepository.save(customersEntity);
	}

}
