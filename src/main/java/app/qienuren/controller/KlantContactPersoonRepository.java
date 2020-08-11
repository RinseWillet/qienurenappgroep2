package app.qienuren.controller;

import app.qienuren.model.KlantContactPersoon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KlantContactPersoonRepository extends JpaRepository<KlantContactPersoon, Long> {
}
