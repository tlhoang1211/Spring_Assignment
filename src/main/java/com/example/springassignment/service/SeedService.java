package com.example.springassignment.service;


import com.example.springassignment.entity.District;
import com.example.springassignment.entity.Street;
import com.example.springassignment.repository.DistrictRepository;
import com.example.springassignment.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SeedService {
    @Autowired
    private StreetRepository streetRepository;
    @Autowired
    private DistrictRepository districtRepository;

    public boolean seed() {
        this.saveDistrict();

        return true;
    }

    private void saveDistrict() {
        List<District> districtList = new ArrayList<District>();

        District district = new District();
        district.setName("Thanh Xuan");
        HashSet<Street> streetList = new HashSet<Street>();
        streetList.add(new Street("Le Trong Tan", System.currentTimeMillis(), district, "aaaaa", 1));
        streetList.add(new Street("Nguyen Huy Tuong", System.currentTimeMillis(), district, "bbbbb", 2));
        district.setStreetSet(streetList);
        districtList.add(district);

        District district2 = new District();
        district2.setName("Dong Da");
        HashSet<Street> streetList2 = new HashSet<Street>();
        streetList.add(new Street( "Ton That Tung", System.currentTimeMillis(), district2, "ccccc", 2));
        streetList.add(new Street("Chua Boc", System.currentTimeMillis(), district2, "ddddd", 3));
        district2.setStreetSet(streetList2);
        districtList.add(district2);

        District district3 = new District();
        district3.setName("Hoan Kiem");
        HashSet<Street> streetList3 = new HashSet<Street>();
        streetList.add(new Street("Ba Trieu", System.currentTimeMillis(), district3, "eeeee", 1));
        streetList.add(new Street( "Pho Hue", System.currentTimeMillis(), district3, "fffff", 3));
        district3.setStreetSet(streetList3);
        districtList.add(district3);

        District district4 = new District();
        district4.setName("Ba Dinh");
        HashSet<Street> streetList4 = new HashSet<Street>();
        streetList.add(new Street("Lieu Giai", System.currentTimeMillis(), district4, "ggggg", 1));
        streetList.add(new Street("Doi Can", System.currentTimeMillis(), district4, "hhhhh", 1));
        district4.setStreetSet(streetList4);
        districtList.add(district4);

        District district5 = new District();
        district5.setName("Tay Ho");
        HashSet<Street> streetList5 = new HashSet<Street>();
        streetList.add(new Street("Phan Dinh Phung", System.currentTimeMillis(), district5, "iiiii", 1));
        streetList.add(new Street("Hoang Hoa Tham", System.currentTimeMillis(), district5, "kkkkk", 1));
        district5.setStreetSet(streetList5);
        districtList.add(district5);

        districtRepository.saveAll(districtList);
    }
}
