package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "Locations")
public class Location {

    @Id
    @GeneratedValue
    private UUID id;

    private String nome;
    private String citta;

    public Location() {
    }

    ;

    public Location(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", citta='" + citta + '\'' +
                '}';
    }
}
