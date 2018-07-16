package net.reflxction.impuritybot.commands.admin.messages;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.reflxction.impuritybot.core.commands.AbstractCommand;
import net.reflxction.impuritybot.core.commands.CommandCategory;
import net.reflxction.impuritybot.core.listeners.Filter;

public class FilterCommand extends AbstractCommand {


    @Override
    public String getCommand() {
        return "filter";
    }

    @Override
    public void process(JDA jda, Guild guild, Message message, MessageChannel channel, User user, String[] args) {
        if (args.length == 0) {
            String msg;
            if (new Filter().filterOn()) msg = "on";
            else msg = "off";
            channel.sendMessage("The filter is currently **" + msg + "**").queue();
        } else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("off") || args[0].equalsIgnoreCase("false")) {
                if (new Filter().filterOn())
                new Filter().setFilterStatus(false);
                else {
                    channel.sendMessage("The filter is already **off**").queue();
                    return;
                }
            } else if (args[0].equalsIgnoreCase("on") || args[0].equalsIgnoreCase("true")) {
                if (!new Filter().filterOn())
                new Filter().setFilterStatus(true);
                else {
                    channel.sendMessage("The filter is already **on**").queue();
                    return;
                }
            } else {
                channel.sendMessage("Use **on** to filter messages or **off** not filter messages").queue();
                return;
            }
        } else channel.sendMessage("**Invalid usage!** Use " + getUsage()).queue();
    }

    @Override
    public String[] getAliases() {
        return new String[0];
    }

    @Override
    public CommandCategory getCategory() {
        return CommandCategory.ADMIN;
    }

    @Override
    public long getDelay() {
        return 0;
    }

    @Override
    public String getDescription() {
        return "Filters any inappropriate / NFSW / offensive messages";
    }

    @Override
    public String getUsage() {
        return "-filter <optional:on/off>";
    }
}
