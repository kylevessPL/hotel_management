package pl.piasta.hotel.dao.service;

import pl.piasta.hotel.dao.model.SpecialOffersEntity;

import java.util.List;

public interface SpecialOffersService {

	List<SpecialOffersEntity> findAll();
	SpecialOffersEntity findById(Integer id);
	long count();
	void delete(SpecialOffersEntity specialOffersEntity);
	void save(SpecialOffersEntity specialOffersEntity);

}
