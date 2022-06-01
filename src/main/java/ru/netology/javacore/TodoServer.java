package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TodoServer {
    private Todos todos;
    private int port;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");
        try (ServerSocket serverSocket = new ServerSocket(8989);) {
            while (true) {
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream());
                ) {
                    final String taskJson = in.readLine();
                    GsonBuilder builder = new GsonBuilder();
                    Gson gsonCreate = builder.create();
                    Todos tempTodos = gsonCreate.fromJson(taskJson, Todos.class);
                    if (tempTodos.type.equalsIgnoreCase("add")) {
                        todos.addTask(tempTodos.task);
                    } else if (tempTodos.type.equalsIgnoreCase("remove")) {
                        todos.removeTask(tempTodos.task);
                    }
                    out.println(todos.getAllTasks());
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }
}
