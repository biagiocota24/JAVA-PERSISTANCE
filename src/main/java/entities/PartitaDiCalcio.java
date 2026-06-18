package entities;

import enums.TipoEvento;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@DiscriminatorValue("Partita")
public class PartitaDiCalcio extends Evento {

    private String squadraCasa;
    private String squadraOspite;
    private String squadraVincente;
    private int golCasa;
    private int golOspite;

    public PartitaDiCalcio() {
    }

    public PartitaDiCalcio(String titolo, LocalDate data, String descrizione, TipoEvento tipoEvento, Location location, String squadraCasa, String squadraOspite, int golCasa, int golOspite) {
        super(titolo, data, descrizione, tipoEvento, 22, location);
        this.squadraCasa = squadraCasa;
        this.squadraOspite = squadraOspite;
        this.golCasa = golCasa;
        this.golOspite = golOspite;
        if (golCasa > golOspite) this.squadraVincente = squadraCasa;
        if (golCasa < golOspite) this.squadraVincente = squadraOspite;
        if (golCasa == golOspite) this.squadraVincente = null;
    }


    public String getSquadraCasa() {
        return squadraCasa;
    }

    public void setSquadraCasa(String squadraCasa) {
        this.squadraCasa = squadraCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getGolCasa() {
        return golCasa;
    }

    public void setGolCasa(int golCasa) {
        this.golCasa = golCasa;
    }

    public int getGolOspite() {
        return golOspite;
    }

    public void setGolOspite(int golOspite) {
        this.golOspite = golOspite;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "squadraCasa='" + squadraCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraVincente='" + squadraVincente + '\'' +
                ", golCasa=" + golCasa +
                ", golOspite=" + golOspite +
                "} " + super.toString();
    }
}
