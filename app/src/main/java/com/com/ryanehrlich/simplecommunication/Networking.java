package com.com.ryanehrlich.simplecommunication;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by ryansehrlich on 2/29/16.
 * @Author Ryan Ehrlich
 */
public class Networking {
    private Socket socket;
    private OutputStream out;

    public Networking (String IP, int  port)  {
        try {
            InetAddress ip = InetAddress.getByAddress(IP.getBytes());
            this.socket = new Socket(ip, port);
            this.out = socket.getOutputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void send(String data) {
        try {
            out.write(data.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
