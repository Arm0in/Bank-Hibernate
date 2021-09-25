package ir.maktab.bankapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SimpleEmployee extends Employee {

    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    private SimpleEmployee supervisor;

    @OneToMany
    @JoinColumn(name = "supervisor_id")
    private Set<SimpleEmployee> underlings = new HashSet<>();

    @ManyToOne
    private Branch branch;
}
