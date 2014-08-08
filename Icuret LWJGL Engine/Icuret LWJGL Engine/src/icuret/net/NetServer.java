package icuret.net;

import java.util.ArrayList;
import java.util.List;
import org.lwjgl.Sys;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

public class NetServer extends Listener{
	public static final int SILENT = 0;
	public static final int DEBUG = 1;
	
	private Server server;
		@SuppressWarnings("rawtypes")
	private List<Class> classes;
	private int debugMode = SILENT;
	
	@SuppressWarnings("rawtypes")
	public NetServer(Class[] registeredClasses) {
		this.classes = new ArrayList<Class>();
		for(int i = 0; i < registeredClasses.length; i++)
			this.classes.add(registeredClasses[i]);
	}
	
	@SuppressWarnings("rawtypes")
	public NetServer(List<Class> registeredClasses) {
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
			this.server.getKryo().register(classes.get(i));
		}
	}
	
	public void start(int tcpPort, int udpPort) {
		this.server = new Server();
		register();
		try {
			this.server.bind(tcpPort, udpPort);
			if(debugMode == DEBUG) System.out.println("Server bound successfully on ports: [tcpPort=" + tcpPort + ";udpPort=" + udpPort + "]");
		}
		catch(Exception e) {
			Sys.alert("Error!", "Unable to start server on ports: [tcpPort=" + tcpPort + ";udpPort=" + udpPort + "] - \n" + e.getMessage());
			return;
		}
		this.server.start();
		this.server.addListener(this);
		if(this.debugMode == DEBUG) System.out.println("Server started on ports: [tcpPort=" + tcpPort + ";udpPort=" + udpPort + "]");
	}
	
	public Server getCommunication() {
		return server;
	}
	
		@SuppressWarnings("rawtypes")
	public List<Class> getRegisteredClasses() {
		return classes;
	}
	
	public int getDebugMode() {
		return debugMode;
	}
	
	public NetServer setDebugMode(int debugMode) {
		this.debugMode = debugMode;
		return this;
	}
	
}
