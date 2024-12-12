package tn.esprit.e_boutique_spring.Service;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.e_boutique_spring.entity.*;
import tn.esprit.e_boutique_spring.repository.BoutiqueRepository;
import tn.esprit.e_boutique_spring.repository.CentreCommercialRepository;
import tn.esprit.e_boutique_spring.repository.ClientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Service
public class ServiceImpl implements ServiceInterface{

    private BoutiqueRepository boutiqueRepository;
    private ClientRepository clientRepository;
    private CentreCommercialRepository centreCommercialRepository ;

    public CentreCommercial ajoutCentre(CentreCommercial centre) {
        return centreCommercialRepository.save(centre);
    }


    public Boutique ajouterEtAffecterlisteBoutiques(List<Boutique> lb, Long idCentre) {

        CentreCommercial C = centreCommercialRepository.findById(idCentre).orElse(null);
        if (C != null) {
            if (C.getBoutiques () == null) {
                C.setBoutiques (new ArrayList<>());
            }
            C.getBoutiques ().addAll(lb);
        }
        centreCommercialRepository.save(C);
        return (Boutique) boutiqueRepository.saveAll ( lb );
    }

    public Boutique saveBoutique(Boutique boutique) {
        List<Boutique> list = boutiqueRepository.findAll();
        for (Boutique b : list){
            return boutiqueRepository.save(boutique);
        }
        return null;

    }

    public void ajouterEtAffecterClientBoutiques(Client client, List<Long> idBoutiques) {

        List<Boutique> list = boutiqueRepository.findAll();
        for (Boutique b : list){
            for (Long idBoutique : idBoutiques){
                if (Objects.equals ( idBoutique, b.getId () )){
                    b.getClients ().add(client);
                    clientRepository.save ( client );
                }
            }
        }

    }


    public List<Client> listeClients(Long idBoutique) {
        return clientRepository.findByBoutiqueList ( idBoutique );
    }



//    public List<Client> listeClients(Long idBoutique) {
//
//        Boutique b = boutiqueRepository.findById(idBoutique).orElse(null);
//        if (b != null) {
//            return b.getClients ();
//        }
//        else {
//            throw new IllegalArgumentException ("Boutique avec l'ID" + idBoutique + "n'existe pas");
//        }
//    }


    public List<Boutique> listeBoutiques(Long idCentre){
        CentreCommercial centre = centreCommercialRepository.findById(idCentre).orElse(null);
        return boutiqueRepository.findByCentreCommercial ( centre );
    }
    public List<Client> listeDeClientsParCategorie(Categorie categorie) {
        return clientRepository.findByBoutiquesCategorie(categorie);
    }

    @Scheduled(cron = "*/30 * * * * *")
    void nbreClientParGenre(){
        int nbrFeminin = clientRepository.getClientByGenre ( Genre.FEMININ);
        int nbrMasculin = clientRepository.getClientByGenre ( Genre.MASCULINE );
        System.out.println ( "Nbre de client F"+ nbrFeminin );
        System.out.println ( "Nbre de client M"+ nbrMasculin );
    }


}
