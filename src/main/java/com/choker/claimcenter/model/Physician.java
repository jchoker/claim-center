package com.choker.claimcenter.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "physician")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Physician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,length = 100, nullable = false)
    private String name;
}





