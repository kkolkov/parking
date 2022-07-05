package ru.kolkov.parking.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Place {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private Integer place;

    @ManyToMany(mappedBy = "places")
    protected Set<Customer> customers = new HashSet<>();
    @ManyToMany(mappedBy = "places")
    protected Set<Timeprice> timeprices = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Place place = (Place) o;
        return id != null && Objects.equals(id, place.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
