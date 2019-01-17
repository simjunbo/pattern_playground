package com.sjb.server.socket;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        /**
         * try-with-resource를 사용하려면 내부적으로 AutoCloseable 구현
         */
        try (InputStream input = socket.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(input));
             OutputStream output = socket.getOutputStream();
             PrintWriter writer = new PrintWriter(output, true)) {

            String text;
            do {
                text = reader.readLine();
                // 여기서 내 코드
                String reverseText = new StringBuilder(text).reverse().toString();
                writer.println("Server: " + reverseText);

            } while (!"bye".equals(text));
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
