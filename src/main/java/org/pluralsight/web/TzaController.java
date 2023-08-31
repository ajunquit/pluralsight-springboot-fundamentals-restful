package org.pluralsight.web;

import org.pluralsight.entity.Application;
import org.pluralsight.exception.ApplicationNotFoundException;
import org.pluralsight.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tza")
public class TzaController {
    private ApplicationService applicationService;

    @Autowired
    public void setApplicationService(ApplicationService applicationService){
        this.applicationService = applicationService;
    }
    @GetMapping("/applications")
    public ResponseEntity<List<Application>> retrieveApplications(){
        return new ResponseEntity<List<Application>>(applicationService.getAllApplications(), HttpStatus.OK);
    }

    @GetMapping("/applications/{id}")
    public ResponseEntity<Application> getApplication(@PathVariable("id") long id){
        try {
            return new ResponseEntity<Application>(applicationService.findApplication(id), HttpStatus.OK);
        } catch (ApplicationNotFoundException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Application Not Found");
        }
    }
}
