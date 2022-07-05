package ru.kolkov.parking.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Timeprice {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private Timestamp time;
    private Integer price;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "place_timeprice",
            joinColumns = @JoinColumn(name = "timeprice_id"),
            inverseJoinColumns = @JoinColumn(name = "place_id"))
    protected Set<Place> places = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Timeprice timeprice = (Timeprice) o;
        return id != null && Objects.equals(id, timeprice.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
