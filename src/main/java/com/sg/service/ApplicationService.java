package com.sg.service;

import com.sg.entity.Application;

public interface ApplicationService {
    Iterable<Application> listApplications();
    void saveApplication(Application application);
    Application getApplication(long id);
    void deleteApplication(long id);
}


