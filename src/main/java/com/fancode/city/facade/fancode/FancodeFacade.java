package com.fancode.city.facade.fancode;

import com.fancode.city.builder.RequestBuilderProvider;
import com.fancode.city.facade.Facade;
import com.fancode.city.facade.FacadeProvider;
import com.fancode.city.models.response.Todo;
import com.fancode.city.models.response.User;
import com.fancode.city.services.fancode.FancodeService;
import com.fancode.city.utils.SerialisationUtil;
import lombok.Getter;

import java.util.List;

public class FancodeFacade extends Facade {
    private FancodeService fancodeService;
    private RequestBuilderProvider requestBuilderProvider;

    @Getter private List<User> userList;

    @Getter private List<Todo> todoList;

    public FancodeFacade(FacadeProvider facadeProvider, RequestBuilderProvider requestBuilderProvider) {
        super(facadeProvider, requestBuilderProvider);
        this.fancodeService = new FancodeService();
        this.requestBuilderProvider = requestBuilderProvider;
    }

    public List<User> getUsers() {
        userList = SerialisationUtil.deserializeListObject(
                fancodeService.getUsers(),
                User.class
        );

        return userList;
    }

    public List<User> getFancodeUsers() {
        getUsers();

        userList = userList.stream().filter(
                user -> {
                    double lat = Double.parseDouble(user.address.geo.lat);
                    double lng = Double.parseDouble(user.address.geo.lng);
                    return lat > -40 && lat < 5 && lng > 5 && lng < 100;
                }
        ).toList();

        return userList;
    }

    public List<Todo> getToDoTasks() {
        todoList = SerialisationUtil.deserializeListObject(
                fancodeService.getToDos(),
                Todo.class
        );

        return todoList;
    }
}
