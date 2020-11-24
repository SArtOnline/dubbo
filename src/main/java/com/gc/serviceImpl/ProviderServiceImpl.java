package com.gc.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gc.service.ProviderService;

@Service
public class ProviderServiceImpl implements ProviderService {
    public void print(String str) {
        System.out.println("Implement1 " + str);
    }
}
