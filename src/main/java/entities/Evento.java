package entities;

import enums.TipoEvento;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;


@Entity
@Table(name = "events")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Tema evento")
public abstract class Evento {

    @Id
    @GeneratedValue
    @Column
    private UUID id;

    @Column(name = "titoloEvento", length = 200, nullable = false)
    private String titolo;

    @Column(name = "Data_evento", nullable = false)
    private LocalDate data;

    @Column(name = "Descrizione", length = 500, nullable = false)
    private String descrizione;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_Evento", length = 20, nullable = false)
    private TipoEvento tipoEvento;

    @Column
    private int maxPartecipantiNum;

    @ManyToOne
    @JoinColumn(name = "Location_id")
    private Location location;

    public Evento() {
    }


    public Evento(String titolo, LocalDate data, String descrizione, TipoEvento tipoEvento, int maxPartecipantiNum, Location location) {
        this.titolo = titolo;
        this.data = LocalDate.now();
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.maxPartecipantiNum = maxPartecipantiNum;
        this.location = location;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getMaxPartecipantiNum() {
        return maxPartecipantiNum;
    }

    public void setMaxPartecipantiNum(int maxPartecipantiNum) {
        this.maxPartecipantiNum = maxPartecipantiNum;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", data=" + data +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", maxPartecipantiNum=" + maxPartecipantiNum +
                '}';
    }
}
