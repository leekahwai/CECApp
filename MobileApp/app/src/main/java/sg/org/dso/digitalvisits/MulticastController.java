package sg.org.dso.digitalvisits;

import android.util.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class MulticastController {

    private static MulticastController m_instance  = null;
    private InetAddress group;
    private MulticastSocket s;

    public static MulticastController getInstance()
    {
        if (m_instance == null)
        {
            m_instance = new MulticastController() ;
        }
        return m_instance;
    }

    public void joinMulticast()
    {
       try{
            group = InetAddress.getByName("228.5.6.7");
            s = new MulticastSocket(6789);
            s.joinGroup(group);
        } catch(UnknownHostException e)
        {
            Log.e("MulticastController", "Multicast address is invalid") ;
        } catch(IOException e)
        {
            Log.e("MulticastController", "Port cannot enter") ;
        }



    }

    public void sendData(String msg)
    {
        DataSenderThread t = new DataSenderThread(s, group, msg) ;
        t.start();
    }
}
