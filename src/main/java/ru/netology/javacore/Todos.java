package ru.netology.javacore;

import java.util.*;

public class Todos {
    public String type;
    public String task;
    public List<String> todosList = new ArrayList<>();

    public void addTask(String task) {
        todosList.add(task);
    }

    public void removeTask(String task) {
        todosList.remove(task);
    }

    public String getAllTasks() {
        Collections.sort(this.todosList);
        StringBuilder builder = new StringBuilder();
        for (String allTodos : todosList) {
            builder.append(allTodos);
            builder.append(" ");

        }
        return builder.toString();
    }

//    @Override
//    public String toString(){
//        return "TODOs: [ " + todosList + " ]";
//    }
}
