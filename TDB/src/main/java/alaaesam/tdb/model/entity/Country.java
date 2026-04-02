package alaaesam.tdb.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "country")
public class Country {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "region")
    private String region;

    @Basic
    @Column(name = "flag")
    private String flag;

    @Basic
    @Column(name = "population")
    private Long population;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Capital> capitals;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Currency> currencies;
}
