package SwordValeDiscord.SVDiscord.Listeners;

import SwordValeDiscord.SVDiscord.SwordValeDiscord;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class discordJoinListener extends ListenerAdapter {
	

	@Override
	public void onGuildMemberJoin(GuildMemberJoinEvent e) {
		Guild g = e.getGuild();
		User u = e.getMember().getUser();
		
		SwordValeDiscord.getPlugin().sendPrivateMessage(u, "Thanks for joining! Your verification code is: **NULL**");
	}
	
	
}
