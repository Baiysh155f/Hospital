package myproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import myproject.enunms.Gender;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "patients")
@NoArgsConstructor
@Getter
@Setter
public class Patient{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "patients_id_gen")
    @SequenceGenerator(name = "patients_id_gen",sequenceName = "patients_id_seq",allocationSize = 1)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String images;
    private Gender gender;
    @Column(unique = true)
    private String email;
    @ManyToOne(cascade = {REFRESH, DETACH, MERGE, PERSIST})
    private Hospital hospital;
    @OneToMany(mappedBy = "patient", cascade = ALL, fetch = FetchType.EAGER)
    private List<Appointment> appointments;
    public void addAppointment(Appointment appointment) {
        if (appointments == null) {
            appointments = new ArrayList<>();
        }
        appointments.add(appointment);
    }
}
