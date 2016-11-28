package interview.rmq;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author WuPing
 * @version 2016年11月28日 下午9:09:24
 */

public class Producer {

    // 队列名称
    private final static String QUEUE_NAME = "Hello";

    public static void main(String[] args) {
	// 创建连接连接到RabbitMQ
	ConnectionFactory factory = new ConnectionFactory();
	// 设置RabbitMQ所在主机ip或者主机名
	factory.setHost("localhost");
	
	try {
	    // 创建一个连接
	    Connection connection = factory.newConnection();
	    // 创建一个频道
	    Channel channel = connection.createChannel();
	    // 指定一个队列
	    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
	    // 发送的消息
	    String message = "Hello World!";
	    // 往队列中发出一条消息
	    channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
	    System.out.println(" [x] Sent '" + message + "'");
	    // 关闭频道和连接
	    channel.close();
	    connection.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

}
