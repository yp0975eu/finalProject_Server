package com.branden;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Random;

public class Main {


    public static void main(String[] args) {
        //http://www.brainyquote.com/quotes/authors/b/bruce_lee.html
        String quotes[] = new String[]{"Always be yourself, express yourself, have faith in yourself, do not go out and look for a successful personality and duplicate it.","Love is like a friendship caught on fire. In the beginning a flame, very pretty, often hot and fierce, but still only light and flickering. As love grows older, our hearts mature and our love becomes as coals, deep-burning and unquenchable.","Mistakes are always forgivable, if one has the courage to admit them.","If you always put limit on everything you do, physical or anything else. It will spread into your work and into your life. There are no limits. There are only plateaus, and you must not stay there, you must go beyond them.","If you love life, don't waste time, for time is what life is made up of.","A wise man can learn more from a foolish question than a fool can learn from a wise answer.","Ever since I was a child I have had this instinctive urge for expansion and growth. To me, the function and duty of a quality human being is the sincere and honest development of one's potential.","Notice that the stiffest tree is most easily cracked, while the bamboo or willow survives by bending with the wind.","I fear not the man who has practiced 10,000 kicks once, but I fear the man who has practiced one kick 10,000 times.","If you spend too much time thinking about a thing, you'll never get it done.","It's not the daily increase but daily decrease. Hack away at the unessential.","Knowledge will give you power, but character respect.","Obey the principles without being bound by them.","Showing off is the fool's idea of glory.","You just wait. I'm going to be the biggest Chinese Star in the world.","I'm not in this world to live up to your expectations and you're not in this world to live up to mine.","The key to immortality is first living a life worth remembering.","Real living is living for others.","Man, the living creature, the creating individual, is always more important than any established style or system.","To hell with circumstances; I create opportunities.","As you think, so shall you become.","A quick temper will make a fool of you soon enough.","Take things as they are. Punch when you have to punch. Kick when you have to kick.","To know oneself is to study oneself in action with another person.","Take no thought of who is right or wrong or who is better than. Be not for or against.","The less effort, the faster and more powerful you will be."};
        Random randomQuote = new Random();

        int portNum = 8915;

        /// show network info
        try {
            System.out.println("Localhost    : " +InetAddress.getLocalHost());
            System.out.println("HostAddress  : " +InetAddress.getLocalHost().getHostAddress());
            System.out.println("HostName     : " +InetAddress.getLocalHost().getHostName());
            System.out.println("Canonical    : " +InetAddress.getLocalHost().getCanonicalHostName());
        } catch ( UnknownHostException ex){
            System.out.println(ex);
        }


        try(
                // open socket
                ServerSocket serverSocket = new ServerSocket(portNum);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter( clientSocket.getOutputStream(), true );
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {
            System.out.println("Client connected to port: " + portNum +"\n");
            String inputLine;
            while( (inputLine = in.readLine()) != null && !inputLine.equalsIgnoreCase("exit")){
                System.out.println("Received Message\nMessage : " + inputLine + "\nFrom    : " + clientSocket.toString());
                out.println(quotes[randomQuote.nextInt(quotes.length)]);
            }
        } catch (Exception ex){
            System.out.print("Some exception" + ex);
        }

    }
}
