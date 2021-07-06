package com.example.springassignment.dto;

import com.example.springassignment.entity.District;
import com.example.springassignment.entity.Street;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Collections;
import java.util.HashSet;

@ToString
@NoArgsConstructor
@Getter
@Setter
public class StreetDTO {
    private int id;
    private String name;
    private long founding;
    private String description;
    private int status;
    public StreetDTO(Street street){
        this.id = street.getId();
        this.name = street.getName();
        this.founding = street.getFounding();
        this.description = street.getDescription();
        this.status = street.getStatus();
        this.districtId = street.getDistrict().getId();
        this.districtName = street.getDistrict().getName();
    }

    private int districtId;
    private String districtName;
    public Street toStreet(){
        Street street = new Street();
        street.setId(this.id);
        street.setName(this.name);
        street.setStatus(this.status);
        street.setFounding(this.founding);
        street.setDescription(this.description);
        street.setDistrict(new District(this.districtId,this.districtName, Collections.singleton(street)));
        return street;
    }

    public Street toStreetInput(){
        Street street = new Street();
        street.setName(this.name);
        street.setStatus(this.status);
        street.setFounding(this.founding);
        street.setDescription(this.description);
        HashSet<Street> streetHashSet = new HashSet<Street>();
        streetHashSet.add(street);

        street.setDistrict(new District(this.districtId,this.districtName,streetHashSet));
        return street;
    }
}