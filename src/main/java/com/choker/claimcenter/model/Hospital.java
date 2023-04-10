package com.choker.claimcenter.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "hospital")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true,length = 100, nullable = false)
    private String name;
}





