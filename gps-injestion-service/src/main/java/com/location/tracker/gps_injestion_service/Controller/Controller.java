package com.location.tracker.gps_injestion_service.Controller;

import com.location.tracker.gps_injestion_service.Service.KafkaService;
import com.location.tracker.gps_injestion_service.Util.TestCase;
import org.live.location.tracker.DTO.LocationSnapshot;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class Controller {
    private final KafkaService kafkaService;

    Controller(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @PostMapping("/location/update")
    public ResponseEntity<?> postLocation(@RequestBody LocationSnapshot locationSnapshot) {
        CompletableFuture.runAsync(()-> {
            for (double[] i : TestCase.driverPath) {
                locationSnapshot.setLatitude(i[0]);
                locationSnapshot.setLongitude(i[1]);
                kafkaService.sendMessage("location.raw", locationSnapshot.getDriver_id(), locationSnapshot);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        return ResponseEntity.ok().build();
    }
}
