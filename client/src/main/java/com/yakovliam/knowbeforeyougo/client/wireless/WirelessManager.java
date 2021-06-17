package com.yakovliam.knowbeforeyougo.client.wireless;

import com.yakovliam.knowbeforeyougo.client.service.ClientService;
import org.springframework.stereotype.Component;

@Component
public class WirelessManager implements ClientService {

    /**
     * Interface mode service
     */
    private InterfaceModeService interfaceModeService;

}
