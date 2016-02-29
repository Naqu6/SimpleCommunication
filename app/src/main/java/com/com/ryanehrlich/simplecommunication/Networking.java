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

    public Networking (String IP, int  port) throws Exception {
        InetAddress ip = InetAddress.getByAddress(IP.getBytes());
        this.socket = new Socket(ip, port,false);
        this.out = socket.getOutputStream();
    }
    public void send(String data) throws Exception {
        out.write(data.getBytes());
    }
}
