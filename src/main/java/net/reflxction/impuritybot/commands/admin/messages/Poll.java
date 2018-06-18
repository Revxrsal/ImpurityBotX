package net.reflxction.impuritybot.commands.admin.messages;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.*;
import net.reflxction.impuritybot.core.commands.AbstractCommand;
import net.reflxction.impuritybot.core.commands.CommandCategory;
import net.reflxction.impuritybot.main.ImpurityBot;
import net.reflxction.impuritybot.utils.lang.StringUtils;
import net.reflxction.impuritybot.utils.data.PollsManager;

/**
 * Created by Reflxction, on 02/02/18.
 */
public class Poll extends AbstractCommand {

    private ImpurityBot bot;

    public Poll(ImpurityBot bot) {
        this.bot = bot;
    }

    private PollsManager polls = new PollsManager(bot);

    @Override
    public String getCommand() {
        return "polls";
    }

    @Override
    public void process(JDA j, Guild g, Message m, MessageChannel c, User u, String[] args) {
        final Member mem = g.getMember(u);
        if (mem.hasPermission(Permission.MANAGE_CHANNEL)) {
            if (args.length != 2) {
                c.sendMessage("**Incorrect command usage. Try " + getUsage() + "**").queue();
            } else {
                if (!args[0].equalsIgnoreCase("add") && !args[0].equalsIgnoreCase("remove")) {
                    c.sendMessage("**Invalid arguments. Try " + getUsage() + "**").queue();
                } else if (args[0].equalsIgnoreCase("add")) {
                    String id = StringUtils.channelToId(args[1]);
                    if (g.getTextChannelById(id) == null) {
                        c.sendMessage("**Invalid channel. Make sure to use the #channel format (or id)**").queue();
                    } else {
                        polls.addPoll(id);
                        c.sendMessage("<#" + id + "> has been added to poll channels.").queue();
                    }
                } else if (args[0].equalsIgnoreCase("remove")) {
                    String id = StringUtils.channelToId(args[1]);
                    if (g.getTextChannelById(id) == null) {
                        c.sendMessage("**Invalid channel. Make sure to use the #channel format (or id)**").queue();
                    } else {
                        polls.removePoll(id);
                        c.sendMessage("<#" + id + "> has been removed from poll channels.").queue();
                    }
                }
            }
        } else {
            c.sendMessage("**You don't have permission to manage poll channels!**").queue();
        }
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
        return "Add poll reactions to a specific channel";
    }

    @Override
    public String getUsage() {
        return "-polls <add | remove> <#channel>";
    }

}
