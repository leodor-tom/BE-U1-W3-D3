package TommasoEleodori.entities;

import TommasoEleodori.entities.enums.Stato;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne(cascade = {CascadeType.REMOVE})
    @JoinColumn(name = "persona_id")
    private Persona persona;
    @ManyToOne(cascade = {CascadeType.REMOVE})
    @JoinColumn(name = "evento_id")
    private Evento evento;
    private Stato stato;
    @OneToMany(mappedBy = "evento")
    private List<Partecipazione> partecipazioni = new ArrayList<>();


    public Partecipazione() {
    }

    public Partecipazione(Persona persona, Evento evento, Stato stato) {
        this.persona = persona;
        this.evento = evento;
        this.stato = stato;
    }

    public List<Partecipazione> getPartecipazioni() {
        return partecipazioni;
    }

    public void setPartecipazioni(List<Partecipazione> partecipazioni) {
        this.partecipazioni = partecipazioni;
    }

    public long getId() {
        return id;
    }


    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona=" + persona +
                ", evento=" + evento +
                ", stato=" + stato +
                '}';
    }
}
