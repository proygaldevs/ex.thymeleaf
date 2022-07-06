package com.galdevs.thymeleaf.company.model;

import com.galdevs.thymeleaf.core.model.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "companies")
@Where(clause = "deleted = false")
@EqualsAndHashCode(callSuper = true)
@SQLDelete(sql = "UPDATE companies SET deleted = true WHERE id = ?")
public class Company extends BaseEntity {

    private String name;

    private String phone;

    private String address;
}

