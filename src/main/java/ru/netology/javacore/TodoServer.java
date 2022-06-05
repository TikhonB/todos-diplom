package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {
    private Todos todos;
    private int port;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void Process(Command command) {
        if (command.getType().equalsIgnoreCase("add")) {
            todos.addTask(command.getTask());
        } else if (command.getType().equalsIgnoreCase("remove")) {
            todos.removeTask(command.getTask());
        }
    }

    public Command createCommand(String jsonIn) {
        JsonObject jso = new Gson().fromJson(jsonIn, JsonObject.class);
        String type = jso.get("type").getAsString();
        String task = jso.get("task").getAsString();
        return new Command(type, task);
    }

    public void start() {
        System.out.println("Starting server at " + port + "...");
        try (ServerSocket serverSocket = new ServerSocket(8989);) {
            while (true) {
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream());
                ) {
                    Process(createCommand(in.readLine()));
                    out.println(todos.getAllTasks());
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }

}
