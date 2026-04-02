package alaaesam.tdb.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @Basic
    private String firstName;

    @Column(name = "last_name")
    @Basic
    private String lastName;

    @Basic
    @Column(name = "username")
    private String userName;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "password")
    private String password;

    @Column(name="mobile_number")
    @Basic
    private String mobileNumber;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
