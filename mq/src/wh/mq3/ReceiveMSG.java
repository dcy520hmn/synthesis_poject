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
		// ͨ������Ϊ����������ͨ��
		MQEnvironment.channel = "tongdao";
		MQEnvironment.CCSID = 1381;
		MQEnvironment.port=10618;
		try {
			// �������й����� QM_SERVERΪ���й���������
			qMgr = new MQQueueManager("test");
			int openOptions = MQC.MQOO_INPUT_AS_Q_DEF | MQC.MQOO_OUTPUT
					| MQC.MQOO_INQUIRE;
			//�������� INITQ�������� INITQΪ���ض���
			MQQueue queue = qMgr.accessQueue("wanghui", openOptions,
					null, null, null);
			System.out.println("�ɹ�����ͨ��");
			MQMessage message = new MQMessage();
			message.format = MQC.MQFMT_STRING;
			message.characterSet = 1381;
			// �Ӷ����л�ȡ��Ϣ
			MQGetMessageOptions pmo = new MQGetMessageOptions();
			queue.get(message, pmo);
			
			String chars=message.readLine();
			System.out.println(chars);
			
			queue.close();// �رն���
			qMgr.disconnect(); // �Ͽ�����
		} catch (EOFException e) {
			e.printStackTrace();
		} catch (MQException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
