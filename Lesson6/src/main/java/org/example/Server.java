package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server
{
    private Socket socket;
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;
    public static void main( String[] args )
    {
        new Server();
    }

    public Server(){
        start();

        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                dataOutputStream.writeUTF(scanner.nextLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void start() {
        //try with resources
        try(ServerSocket serverSocket = new ServerSocket(8189)){
            System.out.println("Сервер запущен, ожидаем подлкючения...");
            socket =  serverSocket.accept();
            System.out.println("Клиент подлкючился...");
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> {
                try {
                    while (true){
                        String message = dataInputStream.readUTF();
                        System.out.println("Получено сообщение от клиента: " + message);
                        if ("/end".equals(message)){
                            dataOutputStream.writeUTF("/end");
                            break;
                        }
                        //dataOutputStream.writeUTF(message);
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
