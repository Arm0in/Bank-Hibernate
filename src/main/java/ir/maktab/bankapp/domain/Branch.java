package ir.maktab.bankapp.domain;

import ir.maktab.bankapp.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Branch extends BaseEntity<Long> {

    private String branchName;

    @OneToOne(mappedBy = "branch", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private ManagerEmployee manager;

}
