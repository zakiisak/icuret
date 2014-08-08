package icuret.net;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.Sys;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

public class NetClient extends Listener{
	public static final int SILENT = 0;
	public static final int DEBUG = 1;
	
	private Client client;
		@SuppressWarnings("rawtypes")
	private List<Class> classes;
	private int debugMode = SILENT;
	
	@SuppressWarnings("rawtypes")
	public NetClient(Class[] registeredClasses) {
		this.classes = new ArrayList<Class>();
		for(int i = 0; i < registeredClasses.length; i++)
			this.classes.add(registeredClasses[i]);
	}
	
	@SuppressWarnings("rawtypes")
	public NetClient(List<Class> registeredClasses) {
		this.classes = new ArrayList<Class>();
		for(int i = 0; i < registeredClasses.size(); i++)
			this.classes.add(registeredClasses.get(i));
	}
	
	public void connected(Connection c) {}
	public void received(Connection c, Object o) {}
	public void disconnected(Connection c) {}
	
	private void register() {
		for(int i = 0; i < classes.size(); i++) {
			if(debugMode == DEBUG) System.out.println("Registering class index: " + i + ", " + classes.get(i).getName());
			this.client.getKryo().register(classes.get(i));
		}
	}
	
	public void start(String ip, int tcpPort, int udpPort) {
		this.client = new Client();
		register();
		this.client.addListener(this);
		this.client.start();
		
		try {
			this.client.connect(5000, ip, tcpPort, udpPort);
		}
		catch(Exception e) {
			Sys.alert("Error!", "Unable to connect to server: " + ip + " [tcpPort=" + tcpPort + ";udpPort=" + udpPort + "] - \n" + e.getMessage());
			return;
		}
		if(debugMode == DEBUG) System.out.println("Successfully connected to: " + ip + " [tcpPort=" + tcpPort + ";udpPort=" + udpPort + "]");
	}
	
	public Client getCommunication() {
		return client;
	}
	
		@SuppressWarnings("rawtypes")
	public List<Class> getRegisteredClasses() {
		return classes;
	}
	
	public int getDebugMode() {
		return debugMode;
	}
	
	public NetClient setDebugMode(int debugMode) {
		this.debugMode = debugMode;
		return this;
	}
	
}
