package com.uni.realt.controller.command;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> commands = new HashMap<>();

    public CommandProvider(){

    }

    public Command takeCommand(String name){

        CommandName commandName;
        commandName = CommandName.valueOf(name.toUpperCase());

        return commands.get(commandName);
    }
}
