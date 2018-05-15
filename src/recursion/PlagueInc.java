//package recursion;
//
///*
//Quick note:
//Even though this is a shortest solutions challenge, I would also appreciate seeing some fast algorithms here!
//
//As an evil mastermind and a casual Plague Inc player, your goal is to destroy all form of life on Earth. There are many ways to do this, but currently the "cheapest" method is to release a contagious virus to the population.
//
//The downside? Nobody is giving you money for this (Why would they lend you money for destroying the world?) and making the virus is expensive, each day of the outbreak adds up the cost. Not only that, the virus isn't effective, and can only spread to an infected person's family and friends every day.
//
//Thankfully, you have been given a matrix of relationships, where people[i] represents the relationship between person[i][0] and everyone in the list (ex: [0,1,3,4] for person[0] means 0 is friends with 1,3, and 4) (NOTE: Friendship is both ways, no need to think about pretending to be their friend). Now all you have to do is to find who you should infect first to infect everyone!
//
//You must return the number of he person that will take the least amount of days to infect the world. If there are ties, return the smaller value.
//
//Note: If not everyone can be infected (ex: Someone with no friends or family :c ), return -1
//
//Example
//
//For people = [[0,1], [1,0,3], [2,3], [3,1,2]], the output should be plagueInc(people) = 1.
//https://i.imgur.com/sGZbRi7.png
//In this example person[0] means 0 is friends to 1, person[1] is friends to 0 and 3, person[2] is friends to 3, and person[3] is friends to 1 and 2.
//
//-> Day 1:
//Person 1 gets infected, that person is friends to 0 and 3.
//-> Day 2:
//0 and 3 get infected, and one of their friends happens to be person 2.
//-> Day 3:
//2 is now infected, making everyone dead. Global domination is complete!
//Of course getting the person 3 takes 3 days as well, but index 1 is less than 3, making 1 a better option.
//
//Input/Output
//
//[execution time limit] 3 seconds (java)
//
//[input] array.array.integer people
//
//A list of everyone's relationships from 0 to n. Keep in mind that the array is messy and unsorted.
//ex: [2,8,5,15,12] means 2 is friends with 8,5,15 and 12
//
//Guaranteed constraints:
//2 ≤ people.length ≤ 2 · 103
//1 ≤ people[i].length
//0 ≤ people[i][j] < people.length.
//
//[output] integer
//
//Index of the person you should infect for maximum evil-ness
//
//[Java] Syntax Tips
//
//// Prints help message to the console
//// Returns a string
////
//// Globals declared here will cause a compilation error,
//// declare variables inside the function instead!
//String helloWorld(String name) {
//    System.out.println("This prints to the console when you Run Tests");
//    return "Hello, " + name;
//}
//
// */
//
//import java.util.Arrays;
//
//public class PlagueInc {
//    public static void main(String[] args) {
//        int[][] people = {{0,1}, {1,0,3}, {2,3}, {3,1,2}};
//        int[][] people2 = {{0,1,2}, {1,0,2}, {2,1,0}, {3,5,4}, {4,3,5}, {5,4,3}};
//        System.out.print(plagueInc(people2));
//    }
//
//    private static int plagueInc(int[][] people) {
//        int[] days = new int[people.length];
//        Arrays.fill(days, -1);
//        for (int i = 0; i < people.length; i++) {
//            Boolean[] infected = new Boolean[people.length];
//            Arrays.fill(infected, false);
//            infected[i] = true;
//            Integer currentDays = infect(people, i, infected, 1);
//            if (Arrays.stream(infected).allMatch(aBoolean -> aBoolean)) {
//                days[i] = currentDays;
//            }
//        }
//        int minIndex = -1;
//        int minDays = days[0];
//        for (int i = 1; i < days.length; i++) {
//            if (days[i] < minDays) {
//                minDays = days[i];
//                minIndex = i;
//            }
//        }
//        return minIndex;
//    }
//
//    private static void infect(int[][] people, int infectingIndex, Boolean[] infected, int days) {
//
//    }
//}
