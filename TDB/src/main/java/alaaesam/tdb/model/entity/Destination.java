package alaaesam.tdb.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "destination")
public class Destination {
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

    @Basic
    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "capitals", columnDefinition = "json")
    @JdbcTypeCode(SqlTypes.JSON)
    private List<String> capitals;

    @Column(name = "currencies", columnDefinition = "json")
    @JdbcTypeCode(SqlTypes.JSON)
    private List<String> currencies;
}
