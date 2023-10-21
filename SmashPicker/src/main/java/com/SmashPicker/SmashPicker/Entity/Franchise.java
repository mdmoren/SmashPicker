package com.SmashPicker.SmashPicker.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "franchises")
@NoArgsConstructor
@AllArgsConstructor
public class Franchise {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "franchise")
    private String franchise;

    @Column(name = "yearFounded")
    private int yearFounded;

    @Column(name = "genre")
    private String genre;

}
