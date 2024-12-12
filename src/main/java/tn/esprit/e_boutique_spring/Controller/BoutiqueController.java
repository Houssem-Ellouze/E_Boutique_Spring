package tn.esprit.e_boutique_spring.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.e_boutique_spring.Service.ServiceImpl;
import tn.esprit.e_boutique_spring.entity.Boutique;
import tn.esprit.e_boutique_spring.entity.Categorie;
import tn.esprit.e_boutique_spring.entity.CentreCommercial;
import tn.esprit.e_boutique_spring.entity.Client;

import java.util.List;

@RestController
@RequestMapping("/controller")
@AllArgsConstructor
public class BoutiqueController {
    private ServiceImpl service;

    @PostMapping("/ajoutCentre")
    public CentreCommercial ajoutCentre(@RequestBody CentreCommercial centre) {
        return service.ajoutCentre(centre);
    }
    @PostMapping("/ajouterEtAffecterlisteBoutiques")
    public Boutique ajouterEtAffecterlisteBoutiques( @RequestBody List<Boutique> boutiques,
                                                     @PathVariable Long idCentre) {
        return service.ajouterEtAffecterlisteBoutiques ( boutiques,idCentre );
    }
    @PostMapping("/saveBoutique")
    public Boutique saveBoutique(Boutique boutique){
        return service.saveBoutique(boutique);
    }

    @PostMapping("/ajouterEtAffecterClientBoutiques/{idC}/{idB}")
    void ajouterEtAffecterClientBoutiques(@PathVariable Client idC, @PathVariable Boutique idB){
        service.ajouterEtAffecterClientBoutiques (idC, (List<Long>) idB );
    }

    @GetMapping("/listeBoutiques/{idC}")
    public List<Boutique> listeBoutiques(@PathVariable Long idC){
        return service.listeBoutiques(idC);
    }

    @GetMapping("/listeBoutiques/{idB}")
    public  List<Client> listeClients(@PathVariable Long idB){
        return service.listeClients(idB);
    }

    @GetMapping("/listeBoutiques/{cat}")
    public List<Client> listeDeClientsParCategorie(@PathVariable Categorie cat){
        return service.listeDeClientsParCategorie(cat);
    }




}
