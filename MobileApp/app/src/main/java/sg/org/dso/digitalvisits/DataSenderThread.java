package sg.org.dso.digitalvisits;

import android.util.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class DataSenderThread extends Thread {

    MulticastSocket s;
    String msg;
    private InetAddress group;

    DataSenderThread(MulticastSocket s, InetAddress group, String data) {
        this.s = s;
        this.group = group ;
        this.msg = data;
    }

    public void run()
    {
        byte[] bytes = msg.getBytes(StandardCharsets.UTF_8);
        DatagramPacket pkt = new DatagramPacket(bytes, bytes.length,
                group, 6789);
        try {
            s.send(pkt);
            Log.e("MulticastController", "Message Sent :"+ msg) ;
        } catch (IOException e) {
            Log.e("MulticastController", "IOError") ;
        }
    }
}
