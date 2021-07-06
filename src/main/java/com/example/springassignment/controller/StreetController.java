package com.example.springassignment.controller;

import com.example.springassignment.dto.StreetDTO;
import com.example.springassignment.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/streets")
public class StreetController {

    @Autowired
    private StreetService streetService;

    @RequestMapping(method = RequestMethod.POST)
    public StreetDTO saveStreet (@RequestBody StreetDTO streetDTO){

        return streetService.save(streetDTO);
    }
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<StreetDTO> findAllByDistrictIdAndName(@RequestParam(defaultValue = "") String streetName, @RequestParam(defaultValue = "") String districtName) {

        return streetService.findStreetByNameContainsAndDistrictName(streetName,districtName);
    }
}
