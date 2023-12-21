
package fooddeliveryservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.MimeTypeUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fooddeliveryservice.config.kafka.KafkaProcessor;
import fooddeliveryservice.domain.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FoodPickedUpPolicyTest {

   private static final Logger LOGGER = LoggerFactory.getLogger(EventTest.class);
   
   @Autowired
   private KafkaProcessor processor;
   @Autowired
   private MessageCollector messageCollector;
   @Autowired
   private ApplicationContext applicationContext;

   @Autowired
   public DeliveryArrangedRepository repository;

   @Test
   @SuppressWarnings("unchecked")
   public void test0() {

      //given:  
      DeliveryArranged entity = new DeliveryArranged();

      entity.setDeliveryId(12345L);
      entity.setOrderId(98765L);
      entity.setDeliveryAddress([object Object]);

      repository.save(entity);

      //when:  
      
      DeliveryArranged event = new DeliveryArranged();

      event.setDeliveryId(12345L);
      
      InventoryApplication.applicationContext = applicationContext;

      ObjectMapper objectMapper = new ObjectMapper();
      try {
         String msg = objectMapper.writeValueAsString(event);

         processor.inboundTopic().send(
            MessageBuilder
            .withPayload(msg)
            .setHeader(
               MessageHeaders.CONTENT_TYPE,
               MimeTypeUtils.APPLICATION_JSON
            )
            .setHeader("type", event.getEventType())
            .build()
         );

         //then:

         Message<String> received = (Message<String>) messageCollector.forChannel(processor.outboundTopic()).poll();

         assertNotNull("Resulted event must be published", received);



         LOGGER.info("Response received: {}", received.getPayload());

         assertEquals(outputEvent.getDeliveryId(), 12345L);


      } catch (JsonProcessingException e) {
         // TODO Auto-generated catch block
         assertTrue("exception", false);
      }

     
   }

}
