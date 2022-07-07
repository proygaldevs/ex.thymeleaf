package com.galdevs.thymeleaf.user.model;

import com.galdevs.thymeleaf.company.model.Company;
import com.galdevs.thymeleaf.core.model.BaseEntity;
import com.galdevs.thymeleaf.core.model.eunms.Gender;
import com.galdevs.thymeleaf.core.model.eunms.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "users")
@Where(clause = "deleted = false")
@SQLDelete(sql = "UPDATE users SET deleted = true WHERE id = ?")
public class User extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "last_name_one")
    private String lastNameOne;

    @Column(name = "last_name_two")
    private String lastNameTwo;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column(name = "id_number")
    private String idNumber;

    @Column(name = "id_type")
    private String idType;

    private String email;

    private String cellphone;

    private String username;

    private String password;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
}
