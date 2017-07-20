package SwordValeDiscord.SVDiscord.util;

import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;

public class discordUtil {


	private static void sendAndLog(MessageChannel channel, String message)
	{
	    channel.sendMessage(message).queue();
	}
	
	public static void sendPrivateMessage(User user, String content)
	{
	    user.openPrivateChannel().queue((channel) -> sendAndLog(channel, content));
	}
	
}
