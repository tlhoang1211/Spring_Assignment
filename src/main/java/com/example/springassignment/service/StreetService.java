package com.example.springassignment.service;

import com.example.springassignment.dto.StreetDTO;
import com.example.springassignment.entity.District;
import com.example.springassignment.entity.Street;
import com.example.springassignment.repository.DistrictRepository;
import com.example.springassignment.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Optional;

@Service
public class StreetService {
    @Autowired
    private StreetRepository streetRepository;

    @Autowired
    private DistrictRepository districtRepository;

    public Page<StreetDTO> findAll() {
        Page<Street> streetPage = streetRepository.findAll(PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC, "status")));

        return streetPage.map(this::convertToObjectDto);
    }

    public Page<StreetDTO> findStreetByNameContainsAndDistrictName(String streetName, String districtName) {

        Page<Street> streetPage = streetRepository.findAll(PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC, "status")));

        if (districtName.equals("") && !streetName.equals("")) {
            streetPage = streetRepository.findStreetsByNameContains(streetName,PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC, "status")));
        }

        if (streetName.equals("") && !districtName.equals("")) {
            streetPage = streetRepository.findStreetByDistrictName(districtName,PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC, "status")));
        }

        if (!streetName.equals("") && !districtName.equals("")) {
            streetPage = streetRepository.findStreetByNameContainsAndDistrictName(streetName, districtName,PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC, "status")));
        }


        return streetPage.map(this::convertToObjectDto);
    }

    private StreetDTO convertToObjectDto(Street street) {
        return new StreetDTO(street);
    }

    public StreetDTO save(StreetDTO streetDTO) {
        Street street = new Street();
        street.setStatus(streetDTO.getStatus());
        street.setDescription(streetDTO.getDescription());
        street.setFounding(streetDTO.getFounding());
        street.setName(streetDTO.getName());
        District district = new District();
        district.setId(streetDTO.getDistrictId());
        district.setName(streetDTO.getDistrictName());
        Optional<District> _district = districtRepository.findById(streetDTO.getDistrictId());
        if (_district.isPresent()) {
            district = _district.get();
        }

        HashSet<Street> streetHashSet = new HashSet<>();
        streetHashSet.add(street);
        street.setDistrict(district);
        district.setStreetSet(streetHashSet);

        return new StreetDTO(streetRepository.save(street));
    }

}
