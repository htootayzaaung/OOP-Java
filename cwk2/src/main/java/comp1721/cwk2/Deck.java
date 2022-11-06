package comp1721.cwk2;
import comp1721.cwk2.Card.Rank;
import comp1721.cwk2.Card.Suit;
import java.util.Collections;
import java.util.ArrayList;

public class Deck
{
    //An "ArrayList" called "deck" to be used in class "Card"
    private ArrayList <Card> deck;
    
    /**
     * <p> Behaves similar to 2D-array iterates through "Rank" first followed by "Suit" </p>
     * <p> "add" method is used to add "(rank, suit)" order-pair tuple to the ArrayList </p>
     * A contructor called "Deck"
     */
    public Deck()
    {
        //Declaring a "deck" ArrayList
        deck = new ArrayList<Card>();

        for (Suit suit : Suit.values())
        {
            for (Rank rank : Rank.values())
            {
                deck.add(new Card(rank, suit));
            }
        }
    }

    /**
     * Returns size of the "ArrayList", "deck"
     */
    public int size()
    {
        return deck.size();
    }

    /**
     * Checks if "deck" is empty by calling the "size" method
     * @return "true" if empty else "false"
     */
    public boolean isEmpty()
    {
        if (deck.size() == 0)
            return true;
        else 
            return false;
    }

    /**
     * The "contains()" method checks whether a string is equivalent to "target".
     * @param target
     * @return "true" if it contains and returns "false" if it doesn't.
     */
    public boolean contains(Card target)
    {
       return deck.contains(target);
    }


    /**
     * Clearing the set - "deck" using clear() method
     */
    public void discard()
    {
        deck.clear();
    }

    /**
     * Removes the first element in a "deck"
     * @return the first element in an ArrayList "deck"
     */
    public Card deal()
    {
        if (deck.size() == 0)
        {
            throw new CardException("No card to deal");
        }
        return deck.remove(0);
    }

    /**
     * Randomly shuffles the elements in the "deck"
     */
    public void shuffle()
    {
        Collections.shuffle(deck);
    }

    /**
     * Add a single card - "aCard" to "deck"
     */
    public void add(Card aCard)
    {
        deck.add(aCard);
    }
}

