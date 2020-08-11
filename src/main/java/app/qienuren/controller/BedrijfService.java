package app.qienuren.controller;

import app.qienuren.model.Bedrijf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional

public class BedrijfService {

    @Autowired
    BedrijfRepository bedrijfRepository;

    public Bedrijf addBedrijf(Bedrijf bedrijf) {
        System.out.println("Bedrijf aangemaakt");
        return bedrijfRepository.save(bedrijf);
    }

    public Iterable<Bedrijf> getAllBedrijf() {
        System.out.println("alle bedrijven opgevraagd");
        return bedrijfRepository.findAll();
    }
}