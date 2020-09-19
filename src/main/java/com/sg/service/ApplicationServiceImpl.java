package com.sg.service;

import com.sg.entity.Application;
import com.sg.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public Iterable<Application> listApplications() {
        return applicationRepository.findAll();
    }

    @Override
    public void saveApplication(Application application)
    {
        applicationRepository.save(application);
    }

    @Override
    public Application getApplication(long id){ return applicationRepository.findById(id).get();}

    @Override
    public void deleteApplication(long id){ applicationRepository.deleteById(id);}

}
