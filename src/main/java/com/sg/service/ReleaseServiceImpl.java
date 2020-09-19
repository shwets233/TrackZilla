package com.sg.service;

import com.sg.entity.Release;
import com.sg.repository.ReleaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReleaseServiceImpl implements ReleaseService {
    @Autowired
    private ReleaseRepository releaseRepository;

    @Override
    public Iterable<Release> listReleases() {
        return releaseRepository.findAll();
    }

    @Override
    public void saveRelease(Release release)
    {
        releaseRepository.save(release);
    }

    @Override
    public Release getRelease(long id){ return releaseRepository.findById(id).get();}

    @Override
    public void deleteRelease(long id){ releaseRepository.deleteById(id);}

}
