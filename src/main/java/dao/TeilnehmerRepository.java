package dao;

import model.classes.Teilnehmer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data Repository fuer den Teilnehmer.
 */
@Repository
public interface TeilnehmerRepository extends CrudRepository<Teilnehmer, Integer> {

    //TODO
}
