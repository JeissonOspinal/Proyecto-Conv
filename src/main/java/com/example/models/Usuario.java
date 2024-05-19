/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

import com.sun.istack.NotNull;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Mauricio
 */
@Entity
public class Usuario {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "create_at", updatable = false)
    @Temporal(TemporalType.DATE)
    private Calendar createdAt;

    @NotNull
    @Column(name = "updated_at")
    @Temporal(TemporalType.DATE)
    private Calendar updatedAt;

    private String name;

    private String surname;

    private int age;

    private String telephone;

    private String address;

    private String addressJob;

    private int tipoUsua;

    public Usuario() {

    }

    public int getTipoUsua() {
        return tipoUsua;
    }

    public void setTipoUsua(int tipoUsua) {
        this.tipoUsua = tipoUsua;
    }
    
    
    public Usuario(String name, String surname, int age, String telephone, String address, String addressJob, int tipoUsua) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.telephone = telephone;
        this.address = address;
        this.addressJob = addressJob;
        this.tipoUsua = tipoUsua;
    }

    @PreUpdate
    private void updateTimestamp() {
        this.updatedAt = Calendar.getInstance();
    }

    @PrePersist
    private void creationTimestamp() {
        this.createdAt = this.updatedAt = Calendar.getInstance();
    }
/*    @OneToMany(cascade = ALL, mappedBy = "competitor")
    private Set<Producto> products;
*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public String getAddressJob() {
        return addressJob;
    }

    public void setAddressJob(String addressJob) {
        this.addressJob = addressJob;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
