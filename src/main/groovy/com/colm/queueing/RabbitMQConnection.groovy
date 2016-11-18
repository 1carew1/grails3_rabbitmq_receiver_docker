package com.colm.queueing

import com.rabbitmq.client.Channel
import com.rabbitmq.client.Connection
import com.rabbitmq.client.ConnectionFactory

/***************************************************************
 * Copyright (c) 2016 Errigal Inc.
 *
 * This software is the confidential and proprietary information
 * of Errigal, Inc.  You shall not disclose such confidential
 * information and shall use it only in accordance with the
 * license agreement you entered into with Errigal.
 *
 *************************************************************** */

/**
 * Created by Colm Carew on 17/11/2016.
 */

@Singleton
class RabbitMQConnection {

  ConnectionFactory connectionFactory
  Connection connection

  RabbitMQConnection setUpConnection(String u, String p, String h, String vh) {
    connectionFactory = new ConnectionFactory()
    connectionFactory.setHost(h)
    connectionFactory.setVirtualHost(vh)
    connectionFactory.setUsername(u)
    connectionFactory.setPassword(p)
    connection = connectionFactory.newConnection()
    return this
  }

  Channel createChannel() {
    return connection.createChannel()
  }
}
