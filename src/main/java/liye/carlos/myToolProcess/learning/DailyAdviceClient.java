package liye.carlos.myToolProcess.learning;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by liye3 on 2017/6/19.
 */
public class DailyAdviceClient {

    public void go() {
        try {
            Socket socket = new Socket("127.0.0.1", 9527);
            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);
            String result = reader.readLine();
            System.out.println(result);
            ServerSocket serverSocket = new ServerSocket(9527);
            Socket socket1 = serverSocket.accept();

            reader.close();

        } catch (Exception e) {

        }
    }
}
