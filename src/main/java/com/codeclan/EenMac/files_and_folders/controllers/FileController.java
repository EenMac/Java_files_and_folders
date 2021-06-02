package com.codeclan.EenMac.files_and_folders.controllers;

import com.codeclan.EenMac.files_and_folders.models.File;
import com.codeclan.EenMac.files_and_folders.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FileController {

    @Autowired
    FileRepository fileRepository;
    //Get route
    @GetMapping(value = "/files")
    public ResponseEntity<List<File>>getAllFiles(){
        return new ResponseEntity<>(fileRepository.findAll(), HttpStatus.OK);
    }
    //Show route
    @GetMapping(value = "/files/{id}")
    public ResponseEntity <Optional<File>> getPirate(@PathVariable Long id){
        return new ResponseEntity<>(fileRepository.findById(id), HttpStatus.OK);
    }
    //post request
    @PostMapping(value = "/pirates")
    public ResponseEntity<File> createPirate(@RequestBody File file){
        fileRepository.save(file);
        return new ResponseEntity<>(file, HttpStatus.CREATED);
    }
}
