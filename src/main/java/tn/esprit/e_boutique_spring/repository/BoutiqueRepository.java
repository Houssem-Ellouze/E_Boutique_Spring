package tn.esprit.e_boutique_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.e_boutique_spring.entity.Boutique;
import tn.esprit.e_boutique_spring.entity.CentreCommercial;
import tn.esprit.e_boutique_spring.entity.Client;

import java.util.List;

@Repository
public interface BoutiqueRepository extends JpaRepository<Boutique, Long> {

    List<Boutique> findByCentreCommercial(CentreCommercial centreCommercial);


}
