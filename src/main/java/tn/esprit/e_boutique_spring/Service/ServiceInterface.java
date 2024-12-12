package tn.esprit.e_boutique_spring.Service;

import tn.esprit.e_boutique_spring.entity.Boutique;
import tn.esprit.e_boutique_spring.entity.Categorie;
import tn.esprit.e_boutique_spring.entity.CentreCommercial;
import tn.esprit.e_boutique_spring.entity.Client;

import java.util.List;

public interface ServiceInterface {
    CentreCommercial ajoutCentre(CentreCommercial centre);
    Boutique ajouterEtAffecterlisteBoutiques (List<Boutique> lb, Long idCentre);
    Boutique saveBoutique(Boutique boutique);
    void ajouterEtAffecterClientBoutiques(Client client, List<Long> idBoutiques);
    List<Client> listeClients(Long idBoutique);
    List<Boutique> listeBoutiques(Long idCentre);
    public List<Client> listeDeClientsParCategorie(Categorie categorie);

}
