package TommasoEleodori;

import TommasoEleodori.entities.Evento;
import TommasoEleodori.entities.Location;
import TommasoEleodori.entities.Partecipazione;
import TommasoEleodori.entities.Persona;
import TommasoEleodori.entities.dao.EventoDAO;
import TommasoEleodori.entities.dao.LocationDAO;
import TommasoEleodori.entities.dao.PartecipazioneDAO;
import TommasoEleodori.entities.dao.PersonaDAO;
import TommasoEleodori.entities.enums.Sesso;
import TommasoEleodori.entities.enums.Stato;
import TommasoEleodori.entities.enums.Tipologia;

import javax.persistence.EntityManager;
import java.time.LocalDate;

import static TommasoEleodori.utils.JpaUtil.emf;

public class Application {

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        PersonaDAO pd = new PersonaDAO(em);
        EventoDAO ed = new EventoDAO(em);
        LocationDAO ld = new LocationDAO(em);
        PartecipazioneDAO pzd = new PartecipazioneDAO(em);


        Persona pers1 = new Persona("Aldo", "Baglio", "baglioaldo@outlook.it", LocalDate.of(1968, 6, 15), Sesso.MASCHIO);
        Evento event1 = new Evento("Vasco Tour", LocalDate.of(2023, 11, 11), "Italian Rock", Tipologia.PUBBLICO, 100000);
        Location loc1 = new Location("Stadio Olimpico", "Roma");
        Partecipazione part1 = new Partecipazione(pers1, event1, Stato.CONFERMA);

        pd.save(pers1);
        ed.save(event1);
        ld.save(loc1);
        pzd.save(part1);

        
        em.close();
        emf.close();
    }
}
