package com.galdevs.thymeleaf.contacts.model;

import com.galdevs.thymeleaf.company.model.Company;
import com.galdevs.thymeleaf.core.model.BaseEntity;
import com.galdevs.thymeleaf.core.model.eunms.Gender;
import com.galdevs.thymeleaf.core.model.eunms.Status;
import com.galdevs.thymeleaf.user.model.User;
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
@Table(name = "contacts")
@Where(clause = "deleted = false")
@SQLDelete(sql = "UPDATE contacts SET deleted = true WHERE id = ?")
public class Contact extends BaseEntity {

    private String name;

    private String email;

    private String phone;

    private String address;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
