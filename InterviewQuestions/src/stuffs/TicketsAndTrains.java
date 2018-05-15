package stuffs;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Tickets ’n Trains Template
[{src: SEA, dest: POR},{src: POR, dest: SFO},{src: POR, dest: SLC},{src: LAX, dest: SFO},{src: SEA, dest: POR}]
write a function that verifies whether or not you can travel from a given source city to a given destination using EXACTLY k tickets
1) EXACTLY means EXACTLY. If you can do it in fewer or more it doesn't count
2) When you travel a route, you lose that ticket
3) Duplicate tickets are allowed

src: SEA
dst: SFO
k: 2
*/

class Ticket {
    private final String source;
    private final String destination;

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public Ticket(String source, String destination) {
        this.source = source;
        this.destination = destination;
    }
}

public class TicketsAndTrains {


    public static void main(String args[] ) throws Exception {
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket("SEA", "POR"));
        tickets.add(new Ticket("POR", "SFO"));
        tickets.add(new Ticket("POR", "SLC"));
        tickets.add(new Ticket("LAX", "SFO"));
        tickets.add(new Ticket("SEA", "POR"));

        boolean b = pathExists(tickets, "SEA", "LAX", 0, 2);
        System.out.println(b);
    }

    private static boolean pathExists(List<Ticket> tickets, String src, String dest, int currentK, int exactK) {
        // Base case
        if (currentK > exactK) {
            return false;
        }

        if (src.equals(dest) && currentK == exactK) {
            return true;
        }

        // Extract possible paths
        List<Ticket> possiblePaths = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (ticket.getSource().equals(src)) {
                possiblePaths.add(ticket);
            }
        }

        if (possiblePaths.size() < 1) {
            return false;
        }

        boolean pathExists;
        // Recursive steps
        for (Ticket ticket : possiblePaths) {
            tickets.remove(ticket);
            currentK = currentK + 1;
            pathExists = pathExists(tickets, ticket.getDestination(), dest, currentK, exactK);
            if (pathExists) {
                return true;
            } else {
                tickets.add(ticket);
            }
        }

        return false;
    }
}





