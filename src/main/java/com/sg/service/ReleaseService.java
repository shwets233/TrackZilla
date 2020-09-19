package com.sg.service;

import com.sg.entity.Release;

public interface ReleaseService {
    Iterable<Release> listReleases();
    void saveRelease(Release release);
    Release getRelease(long id);
    void deleteRelease(long id);
}


