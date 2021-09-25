package ir.maktab.bankapp.domain;

import ir.maktab.bankapp.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = Client.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Client extends BaseEntity<Long> {

    public static final String TABLE_NAME = "client_table";

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "created_date")
    private LocalDate createdDate;



}
