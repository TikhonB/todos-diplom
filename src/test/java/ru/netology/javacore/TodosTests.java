package ru.netology.javacore;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertTrue;

public class TodosTests {
    Todos todos = new Todos();

    @Test
    public void addTaskTest() {
        String testTask = "Чтение";
        ArrayList<String> allTestTask = new ArrayList<>();
        allTestTask.add(testTask);
        todos.addTask(testTask);
        assertTrue(allTestTask.equals(todos.todosList));

    }

    @Test
    public void removeTaskTest() {
        String testTask = "Кодить";
        ArrayList<String> allTestTask = new ArrayList<>();
        allTestTask.remove(testTask);
        todos.removeTask(testTask);
        assertTrue(allTestTask.equals(todos.todosList));
        //assertTrue(allTestTask.equals("Спать"));

    }

    @Test
    public void getAllTasksTest() {
        ArrayList<String> listTestTasks = new ArrayList<>();
        String testTask1 = "Отдыхать";
        String testTask2 = "Работать";
        listTestTasks.add(testTask1);
        listTestTasks.add(testTask2);

        Collections.sort(listTestTasks);
        StringBuilder builder = new StringBuilder();
        for (String tempTask : listTestTasks) {
            builder.append(tempTask);
            builder.append(" ");
        }
        String result = builder.toString();
        todos.addTask("Отдыхать");
        todos.addTask("Работать");
        //todos.addTask("Кодить");
        todos.getAllTasks();
        assertTrue(result.equals(todos.getAllTasks()));
    }
}
