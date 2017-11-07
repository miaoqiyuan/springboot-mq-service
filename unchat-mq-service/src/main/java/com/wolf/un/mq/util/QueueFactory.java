package com.wolf.un.mq.util;

import org.apache.activemq.command.ActiveMQQueue;

public class QueueFactory {

	public static ActiveMQQueue create(String queueName) {
		return new ActiveMQQueue(queueName);
	}

}
