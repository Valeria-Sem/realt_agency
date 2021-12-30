package com.uni.realt.controller.command;

import com.uni.realt.controller.command.impl.create.CreateNewAgent;
import com.uni.realt.controller.command.impl.create.CreateNewClient;
import com.uni.realt.controller.command.impl.create.CreateNewOperation;
import com.uni.realt.controller.command.impl.create.CreateNewOrder;
import com.uni.realt.controller.command.impl.delete.DeleteAgent;
import com.uni.realt.controller.command.impl.delete.DeleteClient;
import com.uni.realt.controller.command.impl.delete.DeleteOperation;
import com.uni.realt.controller.command.impl.delete.DeleteOrder;
import com.uni.realt.controller.command.impl.page.*;
import com.uni.realt.controller.command.impl.sort.SortByAgent;
import com.uni.realt.controller.command.impl.sort.SortByClient;
import com.uni.realt.controller.command.impl.sort.SortByOperation;
import com.uni.realt.controller.command.impl.update.UpdateAgent;
import com.uni.realt.controller.command.impl.update.UpdateClient;
import com.uni.realt.controller.command.impl.update.UpdateOperation;
import com.uni.realt.controller.command.impl.update.UpdateOrder;
import com.uni.realt.controller.command.impl.utils.Clean;
import com.uni.realt.controller.command.impl.utils.Search;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> commands = new HashMap<>();

    public CommandProvider(){
        commands.put(CommandName.GOTOHOMEPAGE, new GoToHomePage());
        commands.put(CommandName.SEARCH, new Search());
        commands.put(CommandName.CLEAN, new Clean());
        commands.put(CommandName.GOTOAGENTPAGE, new GoToAgentPage());
        commands.put(CommandName.GOTOCLIENTPAGE, new GoToClientPage());
        commands.put(CommandName.GOTOOPERATIONPAGE, new GoToOperationPage());
        commands.put(CommandName.SORTBYAGENT, new SortByAgent());
        commands.put(CommandName.SORTBYCLIENT, new SortByClient());
        commands.put(CommandName.SORTBYOPERATION, new SortByOperation());
        commands.put(CommandName.UPDATEAGENT, new UpdateAgent());
        commands.put(CommandName.UPDATECLIENT, new UpdateClient());
        commands.put(CommandName.UPDATEORDER, new UpdateOrder());
        commands.put(CommandName.UPDATEOPERATION, new UpdateOperation());
        commands.put(CommandName.DELETEAGENT, new DeleteAgent());
        commands.put(CommandName.DELETECLIENT, new DeleteClient());
        commands.put(CommandName.DELETEOPERATION, new DeleteOperation());
        commands.put(CommandName.DELETEORDER, new DeleteOrder());
        commands.put(CommandName.CREATENEWAGENT, new CreateNewAgent());
        commands.put(CommandName.CREATENEWCLIENT, new CreateNewClient());
        commands.put(CommandName.CREATENEWOPERATION, new CreateNewOperation());
        commands.put(CommandName.CREATENEWORDER, new CreateNewOrder());
        commands.put(CommandName.GOTOUPDATEAGENTPAGE, new GoToUpdateAgentPage());
        commands.put(CommandName.GOTOUPDATECLIENTPAGE, new GoToUpdateClientPage());
        commands.put(CommandName.GOTOUPDATEOPERATIONPAGE, new GoToUpdateOperationPage());
        commands.put(CommandName.GOTOUPDATEORDERPAGE, new GoToUpdateOrderPage());

    }

    public Command takeCommand(String name){

        CommandName commandName;
        commandName = CommandName.valueOf(name.toUpperCase());

        return commands.get(commandName);
    }
}
