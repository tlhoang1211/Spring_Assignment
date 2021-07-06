package com.example.springassignment.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private long founding;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "district_id")
    private District district;
    private String description;
    private int status; //1 - using // 2 - working // 3 - repairing
    @Column(updatable = false,insertable = false)
    private int district_id;

    public Street(String name, long founding, District district, String description, int status) {
        this.name = name;
        this.founding = founding;
        this.district = district;
        this.description = description;
        this.status = status;
    }
}
