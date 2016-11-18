package com.colm.app

import com.colm.queueing.RabbitMQConnection
import com.rabbitmq.client.AMQP
import com.rabbitmq.client.Consumer
import com.rabbitmq.client.DefaultConsumer
import com.rabbitmq.client.Envelope
import com.rabbitmq.client.QueueingConsumer

class ConnectController {

  def index() {
  }

  def print() {

    Long numberOfMessages
    if (((String) params.numberOfMessages).isNumber()) {
      numberOfMessages = Long.parseLong(params.numberOfMessages)
    }
    if (!numberOfMessages || numberOfMessages < 0) {
      numberOfMessages = 1
    }
    String queueName = params.queueName?.toLowerCase()?.replaceAll(/\s+/, "_")

    RabbitMQConnection rabbitMQConnection = RabbitMQConnection.instance.setUpConnection(params.username, params.password, params.host, params.virtualHost)
    if (rabbitMQConnection.connection) {
      def channel = rabbitMQConnection.createChannel()
      def queue = channel.queueDeclare(queueName, false, false, false, null)

      if(numberOfMessages > queue.getMessageCount()) {
        numberOfMessages = queue.getMessageCount()
      }

      flash.message = ''

      def consumer = new QueueingConsumer(channel)
      channel.basicConsume(queueName, false, consumer)
      Long interations = 0
      QueueingConsumer.Delivery delivery
      while (numberOfMessages > interations) {
        interations++
        delivery = consumer.nextDelivery()
        flash.message += new String(delivery.getBody(), "UTF-8") + " ::"
        channel.basicAck(delivery.envelope.getDeliveryTag(), false);
      }
      channel.close()
    }


    def targetUri = params.targetUri ?: "/"
    redirect(uri: targetUri)
  }


}
