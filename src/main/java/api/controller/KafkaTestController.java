package api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class KafkaTestController {

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;
    private static final String topic = "Kafka_Example";

    @GetMapping(value = "/public/{message}")
    public String getMessage(@PathVariable("message") final String message) {

        kafkaTemplate.send(topic, message);

        return "published successfully;";
    }

}
