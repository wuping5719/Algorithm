package interview.rmq;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.ShutdownSignalException;

/**
 * @author WuPing
 * @version 2016年11月28日 下午9:18:04
 */

public class Consumer {

    // 队列名称
    private final static String QUEUE_NAME = "Hello";

    public static void main(String[] args) {
	// 打开连接和创建频道，与发送端一样
	ConnectionFactory factory = new ConnectionFactory();
	factory.setHost("localhost");

	try {
	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();
	    // 声明队列，主要为了防止消息接收者先运行此程序，队列还不存在时创建队列。
	    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
	    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

	    // 创建队列消费者
	    QueueingConsumer consumer = new QueueingConsumer(channel);
	    // 指定消费队列
	    channel.basicConsume(QUEUE_NAME, true, consumer);
	    while (true) {
		// nextDelivery是一个阻塞方法（内部实现其实是阻塞队列的take方法）
		try {
		    QueueingConsumer.Delivery delivery = consumer
			    .nextDelivery();
		    String message = new String(delivery.getBody());
		    System.out.println(" [x] Received '" + message + "'");
		} catch (ShutdownSignalException e) {
		    e.printStackTrace();
		} catch (ConsumerCancelledException e) {
		    e.printStackTrace();
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

}
