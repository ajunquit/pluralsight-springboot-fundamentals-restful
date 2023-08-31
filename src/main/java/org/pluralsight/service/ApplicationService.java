package org.pluralsight.service;

import org.pluralsight.entity.Application;

import java.util.List;

public interface ApplicationService {
    List<Application> getAllApplications();
    Application findApplication(long id);
}
