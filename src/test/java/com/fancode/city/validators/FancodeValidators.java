package com.fancode.city.validators;

import com.fancode.city.facade.FacadeProvider;
import com.fancode.city.models.response.Todo;
import com.fancode.city.models.response.User;
import org.testng.Assert;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FancodeValidators {
    private final FacadeProvider facadeProvider;

    public FancodeValidators(FacadeProvider facadeProvider) {
        this.facadeProvider = facadeProvider;
    }

    public void validateUsersTaskCompletion() {
        var fancodeCityUserList = facadeProvider.getFancodeFacade().getUserList();
        var toDoTaskList = facadeProvider.getFancodeFacade().getToDoTasks();

        Map<Integer, List<Todo>> todosByUserId = toDoTaskList.stream()
                .collect(Collectors.groupingBy(todo -> todo.userId));

        for (User user : fancodeCityUserList) {
            List<Todo> userTodos = todosByUserId.get(user.id);
            if (userTodos == null || userTodos.isEmpty()) {
                continue;
            }

            long completedTasks = userTodos.stream().filter(todo -> todo.completed).count();
            long totalTasks = userTodos.size();
            double completionPercentage = (double) completedTasks / totalTasks * 100;

            Assert.assertTrue(completionPercentage > 50,
                    "User " + user.id + " has completed " + completionPercentage + "% of tasks, which is not greater than 50%");
        }
    }
}
