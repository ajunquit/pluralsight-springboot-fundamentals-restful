package org.pluralsight.service;

import org.pluralsight.entity.Application;
import org.pluralsight.exception.ApplicationNotFoundException;
import org.pluralsight.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;
    @Override
    public List<Application> getAllApplications() {
        return (List<Application>) applicationRepository.findAll();
    }
    @Override
    public Application findApplication(long id) {

        Optional<Application> application = applicationRepository.findById(id);

        if (application.isPresent())
            return application.get();
        else
            throw new ApplicationNotFoundException("Application Not found.");
    }
}
