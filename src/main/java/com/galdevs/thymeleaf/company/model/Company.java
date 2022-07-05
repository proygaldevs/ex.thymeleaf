package com.galdevs.thymeleaf.company.model;

import com.galdevs.thymeleaf.model.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@SQLDelete(sql = "UPDATE companies SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
@Table(name = "companies")
public class Company extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -4036660832922611392L;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;
}
