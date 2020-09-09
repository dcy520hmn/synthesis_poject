package wh.mq3;

import java.io.EOFException;
import com.ibm.mq.MQC;
import com.ibm.mq.MQEnvironment;
import com.ibm.mq.MQException;
import com.ibm.mq.MQGetMessageOptions;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;

public class ReceiveMSG {
	private MQQueueManager qMgr;

	public static void main(String[] args) {
		new ReceiveMSG();
	}

	public ReceiveMSG() {
		MQEnvironment.hostname = "192.168.10.201";
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
			// 从队列中获取消息
			MQGetMessageOptions pmo = new MQGetMessageOptions();
			queue.get(message, pmo);
			
			String chars=message.readLine();
			System.out.println(chars);
			
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
