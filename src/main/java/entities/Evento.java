package entities;

import enums.TipoEvento;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;


@Entity

@Table(name = "events")
public class Evento {

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
