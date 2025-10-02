package com.location.tracker.tracking_websocket_service.Service;

import com.location.tracker.tracking_websocket_service.Config.MyWebSocketHandler;
import org.live.location.tracker.DTO.LocationSnapshot;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketHandler;

@Service
public class LocationConsumer {

    private final MyWebSocketHandler webSocketHandler;

    LocationConsumer(MyWebSocketHandler webSocketHandler) {
        this.webSocketHandler = webSocketHandler;
    }

    @KafkaListener(topics = "location.raw", groupId = "location-group")
    public void consumeLocation(LocationSnapshot locationSnapshot) {
        webSocketHandler.broadcast(locationSnapshot.toString());
    }
}
