package wh.mq3;

import java.io.EOFException;
import com.ibm.mq.MQC;
import com.ibm.mq.MQEnvironment;
import com.ibm.mq.MQException;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;

public class SendMSG {
	private MQQueueManager qMgr;

	public static void main(String[] args) {
		new SendMSG();
	}

	public SendMSG() {
		MQEnvironment.hostname = "172.20.125.35";
		// 通道类型为服务器连接通道
		MQEnvironment.channel = "tongdao";
		MQEnvironment.CCSID = 1381;
		MQEnvironment.port=10618;
		try {
			// 建立队列管理器 QM_SERVER为队列管理器名称
			qMgr = new MQQueueManager("test");
			int openOptions = MQC.MQOO_INPUT_AS_Q_DEF | MQC.MQOO_OUTPUT
					| MQC.MQOO_INQUIRE;
			//建立队列 INITQ队列名称 INITQ为本地队列
			MQQueue queue = qMgr.accessQueue("wanghui", openOptions,
					null, null, null);
			System.out.println("成功建立通道");
			MQMessage message = new MQMessage();
			message.format = MQC.MQFMT_STRING;
			message.characterSet = 1381;
			message.writeString("王辉");

			message.expiry = -1; // 设置消息用不过期
			queue.put(message);// 将消息放入队列
			
			queue.close();// 关闭队列
			qMgr.disconnect(); // 断开连接
		} catch (EOFException e) {
			e.printStackTrace();
		} catch (MQException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
