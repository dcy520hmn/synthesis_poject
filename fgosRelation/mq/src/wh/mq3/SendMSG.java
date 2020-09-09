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
			message.writeString("����");

			message.expiry = -1; // ������Ϣ�ò�����
			queue.put(message);// ����Ϣ�������
			
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
