package app.qienuren.controller;

import app.qienuren.model.TijdelijkePersoon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TijdelijkePersoonRepository extends JpaRepository<TijdelijkePersoon, Long> {
}
