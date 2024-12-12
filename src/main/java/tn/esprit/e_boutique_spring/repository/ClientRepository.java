package tn.esprit.e_boutique_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.e_boutique_spring.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
