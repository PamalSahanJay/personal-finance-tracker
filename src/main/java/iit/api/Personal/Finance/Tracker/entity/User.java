package iit.api.Personal.Finance.Tracker.entity;


import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    public void setPassword(String encode) {
    }

    public CharSequence getPassword() {
        return null;
    }

    // Getters and Setters
}

