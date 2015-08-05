package mx.com.yjm.monitoring.client;

import backtype.storm.generated.Nimbus.Client;

import org.apache.thrift7.protocol.TBinaryProtocol;
import org.apache.thrift7.transport.TFramedTransport;
import org.apache.thrift7.transport.TSocket;
import org.apache.thrift7.transport.TTransport;

public class ThriftClient{

		static final String STORM_UI_NODE = "150.250.142.234";
		
		private static final String ERROR_THRIFT_CONN_NIMBUS = "Error ocurred while trying making connection with nimbus thrift server";
		
		public Client  getClient() {
			
			TSocket socket = new TSocket(STORM_UI_NODE, 9909);
			
			TTransport tFramedTransport = new TFramedTransport(socket);
			
			TBinaryProtocol tBinaryProtocol = new TBinaryProtocol(tFramedTransport);
			
			Client client = new Client(tBinaryProtocol);
			
			try{
				tFramedTransport.open();			
				
			}catch(Exception ex)
			{
				throw new RuntimeException( ERROR_THRIFT_CONN_NIMBUS);
			}
			return client;
		}
}
