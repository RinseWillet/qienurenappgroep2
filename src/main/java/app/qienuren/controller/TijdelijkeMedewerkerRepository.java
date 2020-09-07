package app.qienuren.controller;

import app.qienuren.model.TijdelijkeMedewerker;
import app.qienuren.model.TijdelijkeTrainee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TijdelijkeMedewerkerRepository extends JpaRepository<TijdelijkeMedewerker, Long> {
}
