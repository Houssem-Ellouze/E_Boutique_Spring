package tn.esprit.e_boutique_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.e_boutique_spring.entity.Categorie;
import tn.esprit.e_boutique_spring.entity.Client;
import tn.esprit.e_boutique_spring.entity.Genre;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findByBoutiqueList(Long idBoutique);
    List<Client> findByBoutiquesCategorie(Categorie categorie);

    @Query("SELECT count (c) from Client c where c.genre =: genre")
    int getClientByGenre(@Param ( "genre" ) Genre genre);




}
