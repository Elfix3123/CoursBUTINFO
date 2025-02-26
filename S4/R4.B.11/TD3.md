```java
import java.net.∗;
import java.io.∗;
import java.util.Date;

public classHorloge {
	public static void main(String[]args) {
		while (True) {
			try {
				int port=0000;
				int len=1024;
				DatagramSocket serveurSocket = new DatagramSocket(port);
				byte[] data = new byte[len];
				DatagramPacket incomingPacket = new DatagramPacket(data, data.length);
				serveurSocket.receive(incomingPacket);
				String s = new String(incomingPacket.getData(), 0, 0, incomingPacket.getLength());
				if (s.compareTo("HEURE.")) {
					byte[] data = new Date().toString().getBytes();
					DatagramPacket outgoingPacket = new DatagramPacket(data, data.length, incomingPacket.getAddress(), incomingPacket.getPort()) ;
					serveurSocket.send(outgoingPacket);
				}
			} catch (Exception e) {
				System.err.println(e);
			}
		}
	}
}
```