package app.qienuren.controller;

import app.qienuren.model.Bedrijf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BedrijfRepository extends JpaRepository<Bedrijf, Long> {
}
