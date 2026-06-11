package com.smartCity.config.mqtt;

import com.smartCity.objects.message.AdminMessages;
import com.smartCity.objects.message.UserMessages;
import com.smartCity.objects.users.Admins;
import com.smartCity.objects.users.User;
import com.smartCity.repository.AdminMessageRepository;
import com.smartCity.repository.AdminRepository;
import com.smartCity.repository.UserMessageRepository;
import com.smartCity.repository.UserRepository;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;


@Configuration
public class MqttBeans {

    @Autowired
    UserMessageRepository userMessageRepository;

    @Autowired
    AdminMessageRepository adminMessageRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AdminRepository adminRepository;

    @Bean
    public MqttPahoClientFactory mqttClientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        MqttConnectOptions options = new MqttConnectOptions();

        options.setServerURIs(new String[] { "tcp://localhost:1883" });
        options.setUserName("admin");
        String pass = "12345678";
        options.setPassword(pass.toCharArray());
        options.setCleanSession(true);

        factory.setConnectionOptions(options);

        return factory;
    }
    @Bean
    public MessageChannel mqttInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageProducer inbound() {
        MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter("serverIn",
                mqttClientFactory(), "#");

        adapter.setCompletionTimeout(5000);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(2);
        adapter.setOutputChannel(mqttInputChannel());
        return adapter;
    }


    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MessageHandler handler() {
        return new MessageHandler() {

            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                String topic = message.getHeaders().get(MqttHeaders.RECEIVED_TOPIC).toString();
                if(topic.equalsIgnoreCase("reserve") || topic.equalsIgnoreCase("price")
                || topic.equalsIgnoreCase("status")) {
                    System.out.println("This is the topic: "+topic);
                    UserMessages msg = new UserMessages();
                    msg.setTopic(topic);

                    String[] messages = message.getPayload().toString().split(",");
                    User user = userRepository.findByUsername(messages[1]);
                    msg.setUser(user);
                    msg.setMessage(messages[0]);
                    msg.setProcessed(false);

                    userMessageRepository.save(msg);
                }else{
                    System.out.println("This is the topic: "+topic);
                    AdminMessages msg = new AdminMessages();
                    msg.setTopic(topic);

                    String[] messages = message.getPayload().toString().split(",");
                    Admins admin = adminRepository.findByUsername(messages[1]);
                    User user = userRepository.findByUserID(Integer.valueOf(messages[2]));
                    msg.setAdmin(admin);
                    msg.setMessage(messages[0]);
                    msg.setUser(user
                    );
                    adminMessageRepository.save(msg);
                }
                System.out.println(message.getPayload());
            }

        };
    }


    @Bean
    public MessageChannel mqttOutboundChannel() {
        return new DirectChannel();
    }
    @Bean
    @ServiceActivator(inputChannel = "mqttOutboundChannel")
    public MessageHandler mqttOutbound() {
        //clientId is generated using a random number
        MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler("serverOut", mqttClientFactory());
        messageHandler.setAsync(true);
        messageHandler.setDefaultTopic("#");
        messageHandler.setDefaultRetained(false);
        return messageHandler;
    }

}