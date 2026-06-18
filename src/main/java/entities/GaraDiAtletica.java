package entities;

import enums.TipoEvento;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@DiscriminatorValue("Gara_atletica")
public class GaraDiAtletica extends Evento {

    @ManyToMany
    @JoinTable(
            name = "Atleti_gara",
            joinColumns = @JoinColumn(name = "gara_Atletica_id"),
            inverseJoinColumns = @JoinColumn(name = "persona_id")
    )
    private Set<Persona> setAtleti;

    @ManyToOne
    @JoinColumn(name = "Vincitore_id")
    private Persona vincitore;

    public GaraDiAtletica() {
    }

    ;

    public GaraDiAtletica(String titolo, LocalDate data, String descrizione, TipoEvento tipoEvento, Location location, Set<Persona> atleti, Persona vincitore) {
        super(titolo, data, descrizione, tipoEvento, 5, location);
        this.setAtleti = atleti;
        this.vincitore = vincitore;
    }
}
