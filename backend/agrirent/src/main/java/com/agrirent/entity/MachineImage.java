package com.agrirent.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "machine_images")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MachineImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "machine_id")
    private Machine machine;
}
