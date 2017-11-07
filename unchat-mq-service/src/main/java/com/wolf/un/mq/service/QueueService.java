package com.wolf.un.mq.service;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class QueueService {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	public void send(Queue queue, Object msg) {
		this.jmsMessagingTemplate.convertAndSend(queue, msg);
	}
}
