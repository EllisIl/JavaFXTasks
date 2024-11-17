package com.example.javatasks;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TaskManagerApp extends Application {
    private final TaskManager taskManager = new TaskManager();

    @Override
    public void start(Stage primaryStage) {
        // VBox to hold checkboxes
        VBox taskListVBox = new VBox(10);

        for (Task task : taskManager.listTasks()) {
            CheckBox taskCheckBox = new CheckBox(task.toString());
            taskCheckBox.setSelected(task.isComplete());

            // Update task status when checkbox is toggled
            taskCheckBox.setOnAction(_ -> {
                if (taskCheckBox.isSelected()) {
                    task.markAsComplete();
                } else {
                    task.isComplete = false;
                }
                taskCheckBox.setText(task.toString()); // Update displayed text
            });

            taskListVBox.getChildren().add(taskCheckBox);
        }

        // Button for adding a new task
        Button addButton = new Button("Add Task");
        addButton.setOnAction(_ -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Add New Task");
            dialog.setHeaderText("Enter task details");
            dialog.setContentText("Task Title:");
            dialog.showAndWait().ifPresent(title -> {
                Task newTask = new Task(title, "Default description", "General");
                taskManager.addTask(newTask);
                CheckBox newTaskCheckBox = new CheckBox(newTask.toString());
                newTaskCheckBox.setOnAction(_ -> {
                    if (newTaskCheckBox.isSelected()) {
                        newTask.markAsComplete();
                    } else {
                        newTask.isComplete = false;
                    }
                    newTaskCheckBox.setText(newTask.toString());
                });
                taskListVBox.getChildren().add(newTaskCheckBox);
            });
        });

        // Layout container
        VBox layout = new VBox(10);
        layout.getChildren().addAll(taskListVBox, addButton);

        // Create and set the scene
        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Task Manager");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
