package pl.piasta.hotel.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import pl.piasta.hotel.dao.model.BookingsEntity;

@Repository
public interface BookingsRepository extends JpaRepository<BookingsEntity, Integer>, JpaSpecificationExecutor<BookingsEntity>, QuerydslPredicateExecutor<BookingsEntity> {

}
