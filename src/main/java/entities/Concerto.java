package entities;

import enums.GeneriMusica;
import enums.TipoEvento;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("Concerto")
public class Concerto extends Evento {
    private GeneriMusica genere;
    private boolean inStreaming;

    public Concerto() {
    }

    ;

    public Concerto(String titolo, LocalDate data, String descrizione, TipoEvento tipoEvento, int maxPartecipantiNum, Location location, GeneriMusica genere, boolean inStreaming) {
        super(titolo, data, descrizione, tipoEvento, maxPartecipantiNum, location);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }


    public GeneriMusica getGenere() {
        return genere;
    }

    public void setGenere(GeneriMusica genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }
}
