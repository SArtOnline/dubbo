package com.gc;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.gc.service.ProviderService;
import com.gc.serviceImpl.ProviderServiceImpl;

import java.io.IOException;

public class APIProvider {
    public static void main(String[] args) throws IOException {
        // 获取接口实现
        ProviderService providerService = new ProviderServiceImpl();

        // 配置应用
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("provider");
        applicationConfig.setOwner("zgc");

        // 配置注册中心
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://localhost:2181");

        // 配置服务通信协议
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);

        // 服务注册配置
        ServiceConfig<ProviderService> serviceConfig = new ServiceConfig<ProviderService>();
        serviceConfig.setApplication(applicationConfig);
        serviceConfig.setRegistry(registryConfig);
        serviceConfig.setProtocol(protocolConfig);
        serviceConfig.setInterface(ProviderService.class);
        serviceConfig.setRef(providerService);
        // 服务端暴露版本号时，消费者端需要指明版本
//        serviceConfig.setVersion("1.0.0");

        // 暴露服务
        serviceConfig.export();
        System.out.print(serviceConfig.isExported());

        System.in.read();
    }
}
