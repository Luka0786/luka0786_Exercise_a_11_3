package Kap11Exercise3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Opgave3
{
    /*
    Write a method called removeEvenInRange that accepts three parameters:
    a LinkedList, a starting index, and an ending index.
    The method’s behavior is to remove all occurrences of the even numbers that appear
    in the list between the starting index (inclusive) and the ending index (exclusive).
    Other values and occurrences of the even numbers that appear outside the given index
    range are not affected.
    */

    public static void main(String[] args)
    {
        // laver en LinkedList som består af Integer
        LinkedList<Integer> list = createList(20, 1000);

        // printer den originale liste ud
        System.out.println("OriginalList" + list);

        // printer den ændrede liste ud, alt efter hvilken range som er givet
        System.out.println("Modified list" + removeEvenInRange(list, 2, 19));
    }

    // Random LinkedList generator
    private static LinkedList<Integer> createList(int size, int maxRange) {
        // laver en ny LinkedList
        LinkedList<Integer> list = new LinkedList<>();

        // for loop som tilføjer til LinkedListen og type caster det til typen integer, grundet at Math.random er typen double, og LinkedListen er af type Integer
        for (int i = 0; i < size; i++)
        {
            // metoden som tilføjer tilfælde til multipliceret med parameteren maxRange
            list.add((int)(Math.random() * maxRange));
        }
        // returnere den liste som er blev lavet, og indeholder de tilfældige tal
        return list;
    }

    private static LinkedList<Integer> removeEvenInRange(LinkedList<Integer> list, int startIndex, int endIndex) {
        // laver et for loop som starter fra startIndexet som skal gives i metodekaldet, hvor i skal være mindre end parameteren endIndex som også skal gives i metodekaldet
        for (int i = startIndex; i < endIndex; i++)
        {
            // et if statement som tager i værdien og hvis den værdien er et lige tal bliver den fjernet fra listen
            // denne metode køre igennem alle tallene fra de givede værdier startIndex og endIndex, og fjernet dem hvis det er lige tal
            if (list.get(i) % 2 == 0) {

                // fjerner i fra listen
                // ændre list size med -1
                // rykker alle elementer en til venstre
                list.remove(i);

                // remove(i), fjerner et element og size - 1. For ikke at få indexoutofbounds kan du bruge i-- og endIndex-- til at rykke dit statement til næste omgang i dit loop
                // Change to statement values
                endIndex--; // endIndex -1 to keep inside the original size in the new list
                i--; // i - 1 sætter i en tilbage for ikke at hoppe det næste element over.
            }

            // i bliver plusset med 1 som det ses i selve loop syntaxen "(..; i++)"
            // Hvis i ikke bliver minusset med 1 ved remove af element så vil loopet hopper over det element du allerede peger på
        }
        // returnere listen
        return list;
    }
}

/*
    public static void main(String[] args) {
        List<Integer> listOfNumbers = new LinkedList<Integer>();

        for (int i = 0; i < 20; i++) {
            listOfNumbers.add(i + 1);
        }
        System.out.println(removeEvenInRange(listOfNumbers, 8, 10));
    }


    public static List<Integer> removeEvenInRange(List<Integer> list, int startIndex, int endIndex) {
        List<Integer> newListOfNumbers = new LinkedList<Integer>();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            if (it.hasNext())
            {
                list.add(it.next());
            }
            System.out.println(list.subList(startIndex, endIndex));


        List<Integer> newListOfNumbers = new LinkedList<Integer>();

        for (int i = 2; i <= list.size(); i++)
        {
            if (i % 2 != 0)
            {
                newListOfNumbers.add(i);
            }
        List sublist = newListOfNumbers.subList(startIndex, endIndex);
        }
        return newListOfNumbers;


        }
        return list;
    }
}
*/