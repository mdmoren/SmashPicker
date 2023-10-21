package com.SmashPicker.SmashPicker.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "smash_characters")
@NoArgsConstructor
@AllArgsConstructor
public class SmashCharacter {
    @Id
    @Column(name = "id")
    private int id;

    @Getter
    @Column(name = "characterName")
    private String characterName;

    @Getter
    @Column(name = "franchise")
    private String franchise;

}