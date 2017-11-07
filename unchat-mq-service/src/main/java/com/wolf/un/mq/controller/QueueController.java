package com.wolf.un.mq.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolf.un.mq.service.QueueService;
import com.wolf.un.mq.util.QueueFactory;

@RestController
public class QueueController {

	@Autowired
	private QueueService qservice;

	private static Map<String, ActiveMQQueue> queueList = new HashMap<>();

	@GetMapping("/queuesend")
	public Object send(String queen, String msg) {
		if (!queueList.containsKey(queen)) {
			queueList.put(queen, QueueFactory.create(queen));
		}
		try {
			qservice.send(queueList.get(queen), msg);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

}
