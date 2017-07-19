package SwordValeDiscord.SVDiscord.Listeners;


import SwordValeDiscord.SVDiscord.SwordValeDiscord;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class discordClientListener extends ListenerAdapter {

	public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
		User u = e.getAuthor();
		Guild g = e.getGuild();
		Message m = e.getMessage();
		
		if(m.getContent().equals("/discord verify")) {
			SwordValeDiscord.getPlugin().sendPrivateMessage(u, "Thanks for joining! Your verification code is: **NULL**");
		}
	}
	
	public void onMessageReceived(MessageReceivedEvent e) {
		MessageChannel objChnl = e.getChannel();
		Message objMsg = e.getMessage();
		User objUser = e.getAuthor();
		
		if(objMsg.getContent().equals("/svbot")) {
			objChnl.sendMessage(objUser.getAsMention() + " Need info on the SwordVale Bot? It has been Direct Messaged to you.").queue();
		}
	}
	
}
