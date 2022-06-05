package ru.netology.javacore;

import java.util.*;

public class Todos {

    protected List<String> todosList;

    public Todos() {
        todosList = new ArrayList<>();
    }

    public void addTask(String task) {
        if (todosList.contains(task))
            System.out.println(task +" уже есть в списке дел");
        else {
            todosList.add(task);
            System.out.println("Была добавлена задача " + task);
        }
    }

    public void removeTask(String task) {
        if (todosList.contains(task)) {
            todosList.remove(task);
            System.out.println(task+" задача была удалена");
        } else {
            System.out.println(task+ " задачи не существует");
        }
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
}
