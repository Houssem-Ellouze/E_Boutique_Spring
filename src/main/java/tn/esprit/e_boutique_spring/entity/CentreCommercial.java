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
public class CentreCommercial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String adresse;
    private String login;
    private String password;
    @OneToMany(mappedBy = "centreCommercial")
    List<Boutique> boutiques;
}
