package tn.esprit.e_boutique_spring.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Boutique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Categorie categorie;
    @ManyToOne
    private CentreCommercial centreCommercial;
    @ManyToMany
    List<Client> clients;
}
