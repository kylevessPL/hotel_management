package pl.piasta.hotel.application.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piasta.hotel.dao.model.CustomersEntity;
import pl.piasta.hotel.dao.repository.CustomersRepository;

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
	public List<CustomersEntity> findByFirstName(String firstName) {
		return customersRepository.findByFirstName(firstName).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public List<CustomersEntity> findByLastName(String lastName) {
		return customersRepository.findByLastName(lastName).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public List<CustomersEntity> findByFirstAndLastName(String firstName, String lastName) {
		return customersRepository.findByFirstAndLastName(firstName, lastName).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public List<CustomersEntity> findByStreetName(String streetName) {
		return customersRepository.findByStreetName(streetName).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public List<CustomersEntity> findByHouseNumber(Integer houseNumber) {
		return customersRepository.findByHouseNumber(houseNumber).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public List<CustomersEntity> findByZipCode(String zipCode) {
		return customersRepository.findByZipCode(zipCode).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public List<CustomersEntity> findByCity(String city) {
		return customersRepository.findByCity(city).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public List<CustomersEntity> findByDocumentType(String documentType) {
		return customersRepository.findByDocumentType(documentType).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public List<CustomersEntity> findByDocumentId(String documentId) {
		return customersRepository.findByDocumentId(documentId).orElseThrow(EntityNotFoundException::new);
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
