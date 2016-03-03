package com.com.ryanehrlich.simplecommunication;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by ryansehrlich on 2/29/16.
 * @Author Ryan Ehrlich
 */
public class Networking {
    final int BUFFER_SIZE = 1024;

    private Socket socket;

    private OutputStream out;
    private BufferedReader in;

    public Networking (String IP, int  port) throws Exception {
        this.socket = new Socket(IP, port);
        this.out = socket.getOutputStream();
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()), 8 * 1024);

    }
    public void send(String data) {
        try {
            out.write(data.getBytes());
            System.out.println("Sent Data");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String recive() throws Exception{
            return in.readLine();
    }
}
