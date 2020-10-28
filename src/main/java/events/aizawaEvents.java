package events;

import ReadWrite.ReadWrite;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

public class aizawaEvents extends ListenerAdapter {





    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {

        Message message = e.getMessage();
        String msg = message.getContentDisplay();
        MessageChannel channel = e.getChannel();
        JDA jda = e.getJDA();
        ReadWrite rw = new ReadWrite();

        Member member = e.getMember();
        Role disgrace = jda.getRoleById("749637328309452860");
        EmbedBuilder em = new EmbedBuilder();
        EmbedBuilder emtaken = new EmbedBuilder();
        EmbedBuilder pingednaruto = new EmbedBuilder();
        String[] quirkremove = msg.split(" ");
        HashMap<Integer, String> quirkmap = new HashMap<>();

        String takenby;


        ArrayList<String> quirklist = rw.ReadFile("QuirkList.txt");
        ArrayList<String> quirklist1 = rw.ReadFile("QuirkTaken.txt");


        int check = 0;

        boolean check1 = false;


        if (msg.contains("@")&&!msg.contains("/")&&channel.getId().equals("463368322306801684")/*message.getMentionedUsers().get(0).getId().equals("182199851524554752")*/) {


            String[] split = msg.split(member.getEffectiveName());

            ArrayList<String> messagelist = new ArrayList<>();

            for (int j = 0; j < split.length; j++) {

                messagelist.add(split[j]);
            }

            for (int j = 0; j < messagelist.size(); j++) {

                if (messagelist.get(j).contains(member.getEffectiveName()))
                    messagelist.remove(j);

                if (messagelist.get(j).contains("@"))
                    messagelist.remove(j);
            }

            em.getDescriptionBuilder().insert(0, "\n" + " " + "\n" + "**Go to message:** " + message.getJumpUrl());

            for (int j = 0; j < messagelist.size(); j++) {

                em.getDescriptionBuilder().insert(j, messagelist.get(j) + " ");
                em.getDescriptionBuilder().insert(0, "**Message Content: **" + "\n");
            }


            for (int i = 0; i < message.getMentionedUsers().size(); i++) {

                em.setTitle("Pinged Message " + "\n" + "by " + member.getEffectiveName());

                em.setColor(Color.BLUE);
                jda.getUserById(message.getMentionedUsers().get(i).getId()).openPrivateChannel().flatMap(channel1 -> channel1.sendMessage(em.build())).queue();
            }




            //Disgrace em


            for (int i = 0; i < message.getMentionedUsers().size(); i++) {

                if (message.getMentionedUsers().get(i).getId().equals("501604011946803241")) {


                    emtaken.setTitle("He is groot");
                    emtaken.setImage(message.getMentionedUsers().get(i).getAvatarUrl());
                    channel.sendMessage(emtaken.build()).queue();


                }




            }



            for (int i = 0; i < message.getMentionedUsers().size(); i++) {

                if (message.getMentionedUsers().get(i).getId().equals("182199851524554752") && !message.getAuthor().getId().equals("277490040232345601")) {


                    member.getPermissions().clear();

                    for (int j = 0; j < member.getRoles().size(); j++) {
                        e.getGuild().removeRoleFromMember(member, member.getRoles().get(j)).queue();
                    }
                    try {
                        e.getGuild().addRoleToMember(member, disgrace).queue();
                    } catch (IllegalArgumentException ev) {

                        System.out.print("Role id does not exist in this dummy discord");
                    }
                    e.getGuild().getMemberById(member.getId()).getPermissions().clear();
                    e.getGuild().addRoleToMember(member, disgrace).queue();


                    //channel.sendMessage("You have been kicked for pinging the Ramen Man" + "\n" + "<@" + e.getMember().getId() + ">" + "\n").queue();


                    String[] imgs = {"https://thumbs.gfycat.com/JointCanineAlbacoretuna-size_restricted.gif",
                            "https://media.tenor.com/images/f5d2094de649174bbcd899fca4a15108/tenor.gif", "https://cdn140.picsart.com/285644775019201.gif",
                            "https://i.pinimg.com/originals/38/30/11/38301174704a911dd5195f74ab2da3a9.gif", "https://media1.tenor.com/images/9c9ce22bbbaa25392592f417db36f866/tenor.gif?itemid=15771477", "https://i2.wp.com/www.spasticbastard.com/wp-content/uploads/2018/10/7-xgRYMFh-1.gif?resize=540%2C304&ssl=1"};


                    int random = (int) (Math.random() * 6) + 0;
                    //em.setColor(0);
                    pingednaruto.setTitle("You dare ping the Ramen Man " + e.getAuthor().getName() + "?");
                    pingednaruto.setImage(imgs[random]);
                    pingednaruto.setFooter("You are not fit to be a hero let alone a villain");
                    channel.sendMessage(pingednaruto.build()).queue();

                    message.delete().complete();

                    jda.getUserById("182199851524554752").openPrivateChannel().flatMap(channel1 -> channel1.sendMessage("<@" + e.getAuthor().getId() + ">" + " Pinged you" + "\n")).queue();


                    em.setTitle("Don't ping the Ramen Man " + e.getAuthor().getName());
                    em.setImage("https://i.pinimg.com/originals/88/c3/0d/88c30d5f0e70f09b5e92588c4d3bd64e.gif");
                    em.setDescription("If you have a question then kindly ask another staff member!");
                    em.setFooter("If it's urgent then dm him!");


                    member.getUser().openPrivateChannel().flatMap(channel1 -> channel1.sendMessage(em.build())).queue();


                    member.modifyNickname("Baka Who Pinged " + "Naruto").queue();
                }

            }

        }


        if(msg.equalsIgnoreCase("/quirklist")) {



            for(int i  = 0; i<rw.ReadFile("QuirkTaken.txt").size();i++) {


                emtaken.setTitle("In progress");
                emtaken.setColor(Color.BLACK);

                emtaken.getDescriptionBuilder().insert(i,rw.ReadFile("QuirkTaken.txt").get(i)+"\n");

            }

            channel.sendMessage(emtaken.build()).queue();


            for (int i = 0; i < rw.ReadFile("QuirkList.txt").size(); i++) {

                if(i==0){


                    for(int o=0; o<quirklist.size();o++) {

                            if (rw.ReadFile("QuirkList.txt").get(o).contains("--")) {

                                System.out.print("Hello");

                            }


                    if(o==quirklist.size()-1)
                        em.getDescriptionBuilder().insert(0," ```" +"\n");

                    }

                }
                else{

                    if(!quirklist.get(i).contains("--"))
                    em.getDescriptionBuilder().insert(i, quirklist.get(i) + "\n");



                }



            }


            em.getDescriptionBuilder().insert(quirklist.size(),"```markdown" + "\n");



         em.setTitle("To be finished");

         //em.setImage("https://media1.tenor.com/images/61ce3985b59e18f2e32d83f4aaac81ce/tenor.gif?itemid=15147099");
         em.setColor(Color.RED);

            channel.sendMessage(em.build()).queue();

            String desc = em.getDescriptionBuilder().toString();

            //System.out.print(desc);



        }

        else if(quirkremove[0].equals("/quirktake")){

      channel.sendMessage("You are now working on the " + quirkremove[1]+ " Quirk").queue();

                            rw.WriteToFile("QuirkTaken.txt", "\n" + "**" + quirkremove[1] + "**" + " Quirk being worked on by " + "<@" + message.getAuthor().getId() + ">!" + "   " + "\n", true);



            for(int i  = 0; i<rw.ReadFile("QuirkList.txt").size();i++) {

                if(quirklist.get(i).contains(quirkremove[1])){
                    quirklist.remove(i);

                }
                rw.WriteToFile("QuirkList.txt","",false);

                for(int j = 0; j<quirklist.size(); j++){
                    rw.WriteToFile("QuirkList.txt",quirklist.get(j)+"\n",true);

                }


            }



                        }












        else if(quirkremove[0].equals("/quirkadd")){



            channel.sendMessage("" + quirkremove[1] + " added!").queue();
            rw.WriteToFile("QuirkList.txt","\n" + "  - " + quirkremove[1],true);

        }


        else if(quirkremove[0].equals("/quirkremove")) {

            channel.sendMessage("Removed " + quirkremove[1]).queue();

            for(int i  = 0; i<rw.ReadFile("QuirkList.txt").size();i++) {

                if(quirklist.get(i).contains(quirkremove[1])){
                    quirklist.remove(i);

                }
                    rw.WriteToFile("QuirkList.txt","",false);

                    for(int j = 0; j<quirklist.size(); j++){
                        rw.WriteToFile("QuirkList.txt",quirklist.get(j)+"\n",true);

                    }


            }




            //Taken stuff


            for(int i  = 0; i<rw.ReadFile("QuirkTaken.txt").size();i++) {

                if(quirklist1.get(i).contains(quirkremove[1])){
                    quirklist1.remove(i);

                }
                rw.WriteToFile("QuirkTaken.txt","",false);

                for(int j = 0; j<quirklist1.size(); j++){
                    rw.WriteToFile("QuirkTaken.txt",quirklist1.get(j)+"\n",true);

                   }


            }






        }


        else if(quirkremove[0].equals("!quirkadd")){

            channel.sendMessage("Prefix changed from **!** to **/**").queue();
        }


        else if(quirkremove[0].equals("!rolecolor")){

            channel.sendMessage("Prefix changed from **!** to **/**").queue();
        }

        else if(quirkremove[0].equals("!donatorcolor")){

            channel.sendMessage("Prefix changed from **!** to **/**").queue();
        }


        else if(quirkremove[0].equals("/help")){


            emtaken.setTitle("Other features");

            String[] quirkcommands = {"More coming soon", "Sending you a message you were pinged in","Removing every role from a person if someone pings Naruto"};



            channel.sendMessage("```diff" +"\n" + "Color Commands: " + " " + "\n" + "- /rolecolor @somerole color" + "\n" + "- /donatorcolor somecolor" + "```").queue();
            channel.sendMessage("```diff" +"\n" + "Quirk Commands: " + " " + "\n" + "- /quirkadd somequirk" + "\n" + "- /quirkremove somequirk"+ "\n" + "- /quirktake somequirk"+ "\n" + "- /quirklist" + "```").queue();

            for(int i = 0; i<quirkcommands.length; i++){

                if(i==0)
                    emtaken.getDescriptionBuilder().insert(0,"```");



            emtaken.getDescriptionBuilder().insert(i," - " + quirkcommands[i] +"\n");

            }

            emtaken.getDescriptionBuilder().insert(quirkcommands.length,"```markdown" + "\n");

            channel.sendMessage(emtaken.build()).queue();




        }


        else if(quirkremove[0].equals("/donatorcolor")){



            Color color;


            if(channel.getId().equals("536985183988219924")) {


                for (int i = 0; i < member.getRoles().size(); i++) {

                    if (member.getRoles().get(i).equals(jda.getRoleById("536981082285801493"))) {

                        check = check + 1;

                    }
                }

                System.out.print(check);

                if (check == 1) {

                    try {
                        jda.getRoleById("536981082285801493").getManager().setColor(Color.decode(quirkremove[1])).queue();
                        channel.sendMessage("Color changed").queue();
                    } catch (NumberFormatException ne) {

                        Field field = null;
                        try {
                            field = Class.forName("java.awt.Color").getField(quirkremove[1].toUpperCase());
                        } catch (NoSuchFieldException ex) {
                            ex.printStackTrace();
                        } catch (ClassNotFoundException ex) {
                            ex.printStackTrace();
                        }
                        try {
                            color = (Color) field.get(null);
                            jda.getRoleById("536981082285801493").getManager().setColor(color).queue();
                            em.setImage("https://i.kym-cdn.com/photos/images/newsfeed/001/254/425/cb9.gif");
                            em.setTitle("Color changed");
                            channel.sendMessage(em.build()).queue();
                        } catch (IllegalAccessException ex) {
                            ex.printStackTrace();
                        }


                    }

                } else {

                    channel.sendMessage("You don't have permission to change this role color").queue();
                }

            }
            else
                channel.sendMessage("You have to be in the donator-chat channel").queue();

        }

        else if(quirkremove[0].equals("/rolecolor")){

            Color color;



            for(int j=0; j<member.getRoles().size();j++){
                if (member.getRoles().get(j).equals(message.getMentionedRoles().get(0))) {

                   check =  check + 1;

                    System.out.print("Yes1");

                }}




            for(int i=0; i<member.getRoles().size();i++){

                if(member.getRoles().get(i).equals(jda.getRoleById("558263660003459072"))) {

                   check =  check +1;

                }
                }

            System.out.print(check);

            if(check == 2){


            try{
            message.getMentionedRoles().get(0).getManager().setColor(Color.decode(quirkremove[2])).queue();
                em.setImage("https://i.kym-cdn.com/photos/images/newsfeed/001/254/425/cb9.gif");
                em.setTitle("Color changed");
                channel.sendMessage(em.build()).queue();}
            catch (NumberFormatException ne){

                Field field = null;
                try {
                    field = Class.forName("java.awt.Color").getField(quirkremove[2].toUpperCase());
                } catch (NoSuchFieldException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                try {
                    color = (Color)field.get(null);
                    message.getMentionedRoles().get(0).getManager().setColor(color).queue();
                    em.setImage("https://i.kym-cdn.com/photos/images/newsfeed/001/254/425/cb9.gif");
                    em.setTitle("Color changed");
                    channel.sendMessage(em.build()).queue();
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                }




            }

            }
            else{

                channel.sendMessage("You don't have permission to change this role color").queue();


            }}

        else if(msg.equalsIgnoreCase("user")){

            e.getAuthor().openPrivateChannel().flatMap(channel1 -> channel1.sendMessage("Why hello there" )).queue();

        }


    }


}
