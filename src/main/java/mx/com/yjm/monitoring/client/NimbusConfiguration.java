package mx.com.yjm.monitoring.client;

import backtype.storm.generated.Nimbus.Client;

public class NimbusConfiguration {

	public void printNimbusStats(){
		try{
			
			ThriftClient thriftClient = new ThriftClient();
			
			Client client = thriftClient.getClient();
			
			String nimbusCfg = client.getNimbusConf();
			
			System.out.println("**************************************************");
			System.out.println("** 	Nimbus Configuration: "+nimbusCfg+" **");
			System.out.println("**************************************************");
			
		}catch(Exception ex)
		{
			throw new RuntimeException("Error occurred while fetching the Nimbus statics");
		}
		
	}
		
		public static void main(String [] args)
		{
			new NimbusConfiguration().printNimbusStats();
		}
}
