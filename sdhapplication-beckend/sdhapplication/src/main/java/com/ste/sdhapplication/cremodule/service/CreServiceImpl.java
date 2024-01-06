package com.ste.sdhapplication.cremodule.service;

import com.ste.sdhapplication.cremodule.repository.CreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreServiceImpl implements CreService {
    @Autowired
    private CreRepository creRepository;
}
