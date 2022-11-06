package comp1721.cwk2;
import comp1721.cwk2.Card.Rank;
import comp1721.cwk2.Card.Suit;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class represents a poker-hand and it's utilities which are applied in a card-game of poker.
 * 
 * @author Htoo Aung
 */


public class PokerHand
{
    //An "ArrayList" called "pokerHand" to be used in class "Card"
    private ArrayList<Card> pokerHand;

    //ArrayList to add all the "ranks" from the "pokerHand"
    ArrayList<Rank> ranks = new ArrayList <Rank>();

    //ArrayList that contains all the suits in "pokerHand"
    ArrayList<Suit> suitsInHand = new ArrayList<Suit>();

    static int FULL_SIZE = 5;

    /** 
     * A contructor called "pokerHand"
     */
    
    public PokerHand()
    {
        pokerHand = new ArrayList<Card>();
    }
    
    /** 
     * The same constructor as above excpet it has a parameter.
     * <p> Splits the input string using " " character as a delimeter and stores each card as an element 
     * of an array. </p>
     * @param A poker-hand in string with spaces
     */

    public PokerHand (String pokerHandInString) 
    {
        pokerHand = new ArrayList<>();

        String[] cards = pokerHandInString.split(" ",0);
        //Gets the length of the list
        int numberOfCards = cards.length;
        if (numberOfCards > FULL_SIZE)
        {
            throw new CardException("Invaid Length");
        }
        for(String str: cards)
        {
            Card card = new Card(str);
            //If "pokerHand" does not exceed 5 cards then each card is added one at a time to "pokerHand"
            if (pokerHand.size() > FULL_SIZE)
            {
                throw new CardException("Invalid Length");
            }
            else
            {
                pokerHand.add(card);
            }
        }
    }

    /**
     * Formating the cards in the "emptyString" through a series of string concatenations
     * <p> It also overrides the "toString()" method the class - "Card"
     * @return the string that is the final result of all the concatenations
     */
    @Override
    public String toString()
    {
        String emptyString = "";
        for (int position = 0; position < pokerHand.size(); position++)
        {
            if (pokerHand.size() == 1)
            {
                emptyString = emptyString + String.format("%s", pokerHand.get(position));
            }
            else if (pokerHand.size() == position + 1)
            {
                emptyString = emptyString + String.format("%s", pokerHand.get(position));
            }
            else
            {
                emptyString = emptyString + String.format("%s ", pokerHand.get(position));
            }
        }
        return emptyString;
    }

    /**
     * @return size of the "ArrayList", "pokerHand"
     */
    public int size()
    {
        return pokerHand.size();
    }

    /**
     * Clearing the set - "pokerHand" using clear() method
     */
    public void discard()
    {
        if (pokerHand.size() == 0)
        {
            throw new CardException("No cards to discard");
        }
        pokerHand.clear();
    }
    
    /**
     * Clearing the set - "deck" using clear() method by adding each individual cards at once.
     * <p> The entire "pokerHand" is also cleared in the end similar to "discard" method. </p>
     * @param aCard
     */
    public void discardTo(Deck aCard)
    {
        //Throw an excetption if there is no card to be discarded!
        if (pokerHand.size() == 0)
        {
            throw new CardException("No cards to discard");
        }
        //Add individual cards to a poker hand.
        for (Card i: pokerHand)
        {
            aCard.add(i);
        }
        pokerHand.clear();
    }

    /**    
     * A pair is a hand that contains two cards of one rank and three cards of three other ranks 
     * 4♥ 4♠ K♠ 10♦ 5♠  
     * @return true if it is a pair
     */

    public boolean isPair()
    {
        //Whenever there are two cards of the same rank this variable is incremented
        int pairCount = 0;

        //If hand size is not 5 return "false"
        if (pokerHand.size() != FULL_SIZE)
        {
            return false;
        }

        for (int i = 0; i < pokerHand.size(); i++)
        {
            ranks.add(pokerHand.get(i).getRank());
        }
        for (int r = 0; r < ranks.size(); r++)
        {
            //Counts "rankDuplicates" from an ArrayList "ranks"
            int rankDuplicates = Collections.frequency(ranks, ranks.get(r));
            if (rankDuplicates == 2)
            {
                pairCount++;       
            }
        }
            //It must precisely be a pair, should neither be "TwoPairs" nor "FullHouse"
            if (pairCount == 2 && isTwoPairs() == false && isFullHouse() == false)
                return true;
            else
                return false;
    }

    /**
     * Two pair is a hand that contains two cards of one rank, two cards of another rank and one card of
     * a third rank. J♥ J♣ 4♣ 4♠ 9♥ 
     * @return true if it is a 2-pair
     */

    public boolean isTwoPairs()
    {
        //Whenever there are two cards of the same rank this variable is incremented
        int pairCount = 0;

        //If hand size is not 5 return "false"
        if (pokerHand.size() != FULL_SIZE)
        {
            return false;
        }
        
        for (int i = 0; i < pokerHand.size(); i++)
        {
            ranks.add(pokerHand.get(i).getRank());
        }

        for (int r = 0; r < ranks.size(); r++)
        {
            //Counts "rankDuplicates" from an ArrayList "ranks"
            int rankDuplicates = Collections.frequency(ranks, ranks.get(r));
            if (rankDuplicates == 2)
            {
                pairCount++;       
            }
        }
        //The condition is to be precisely "TwoPair". It cannot be "ThreeOfAKind"
        if (pairCount == 4 && isThreeOfAKind() == false)
            return true;
        else
            return false;
    }

    /** 
     * Three cards of the same rank, and two unrelated side cards. J♥ J♣ J♥ 4♠ 9♥
     * @return true if it is a 3-of-a-kind
     */
    public boolean isThreeOfAKind()
    {
        //Whenever there are three cards of the same rank this variable is incremented
        int triadCount = 0;

        //If hand size is not 5 return "false"
        if (pokerHand.size() != FULL_SIZE)
        {
            return false;
        }
        
        for (int i = 0; i < pokerHand.size(); i++)
        {
            ranks.add(pokerHand.get(i).getRank());
        }
        for (int r = 0; r < ranks.size(); r++)
        {
            //Counts "rankDuplicates" from an ArrayList "ranks"
            int rankDuplicates = Collections.frequency(ranks, ranks.get(r));
            if (rankDuplicates == 3)
            {
                triadCount++;       
            }
        }

        //Condition is to be precisely "ThreeOfAKind" not "FourOfAKind" nor "FullHouse"
        if (triadCount == 3 && isFourOfAKind() == false && isFullHouse() == false)
            return true;
        else
            return false;
    }

    /** 
     * Four of a kind contains four cards of one rank and one card of another rank.
     * 9♣ 9♠ 9♦ 9♥ J♥
     * @return true if it is a 4-of-a-kind
     */
    public boolean isFourOfAKind()
    {
        //Whenever there are four cards of the same rank this variable is incremented
        int quadrupleCount = 0;

        //If hand size is not 5 return "false"
        if (pokerHand.size() != FULL_SIZE)
        {
            return false;
        }

        for (int i = 0; i < pokerHand.size(); i++)
        {
            ranks.add(pokerHand.get(i).getRank());
        }
        for (int r = 0; r < ranks.size(); r++)
        {
            //Counts "rankDuplicates" from an ArrayList "ranks"
            int rankDuplicates = Collections.frequency(ranks, ranks.get(r));
            if (rankDuplicates == 4)
            {
                quadrupleCount++;       
            }
        }

        //The condition must be precisely "FourOfAKind"
        if (quadrupleCount == 4)
            return true;
        else
            return false;
    }

    /**
     * Any three cards of the same rank together with any two cards of the same rank.
     * 9♣ 9♠ 9♦ J♦ J♥
     * @return true if it is a full-house
    */
    public boolean isFullHouse()
    {
        //Whenever there is a "fullHouseCount" this variable is incremented
        int fullHouseCount = 0;

        //If hand size is not 5 return "false"
        if (pokerHand.size() != FULL_SIZE)
        {
            return false;
        }
        
        for (int i = 0; i < pokerHand.size(); i++)
        {
            ranks.add(pokerHand.get(i).getRank());
        }

        for (int r = 0; r < ranks.size(); r++)
        {
            //Counts "rankDuplicates" from an ArrayList "ranks"
            int rankDuplicates = Collections.frequency(ranks, ranks.get(r));
            if (rankDuplicates == 2 || rankDuplicates == 3)
            {
                fullHouseCount++;       
            }
        }

        if (fullHouseCount == 5)
            return true;
        else
            return false;
    }

    /**
     * A flush is 5 cards of the same suit.
     * @return true if it is a flush
     */
       
    public boolean isFlush()
    {
        
        //If hand size is not 5 return "false"
        if (pokerHand.size() != FULL_SIZE)
        {
            return false;
        }

        for (int i = 0; i < pokerHand.size(); i++)
        {
            suitsInHand.add(pokerHand.get(i).getSuit());
        }
       
        for (int r = 0; r < suitsInHand.size(); r++)
        {
            //Counts "rankDuplicates" from an ArrayList "ranks"
            int rankDuplicates = Collections.frequency(suitsInHand, suitsInHand.get(r));
            if (rankDuplicates == 5)
                return true;
            else
                return false;
        }
        return false;
    }

    /**
     * A straight is a hand that contains five cards of sequential rank, not all of the 
     * same suit, such as 7♣ 6♠ 5♠ 4♥ 3♥ 
     * @return true if it is a straight
     */
    public boolean isStraight()
    {
        //ArrayList containing rank_card pair
        ArrayList<Rank> rank_card = new ArrayList<Rank>();

        //ArrayList for all the ranks equivalent in integer
        ArrayList<Integer> allRanks = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13));
        
        //ArrayList containing rank_hand pair
        ArrayList<Rank> rank_hand = new ArrayList<Rank>();

        //ArrayList to store all the ranks in a hand in integer
        ArrayList<Integer> ranksInteger = new ArrayList<Integer>();
        
        //If hand size is not 5 return "false"
        if (pokerHand.size() != FULL_SIZE)
        {
            return false;
        }
        
        for (Rank rank : Rank.values())
        {
            rank_card.add(rank);
        }

        for (int i = 0; i < pokerHand.size(); i++)
        {
            rank_hand.add(pokerHand.get(i).getRank());
        }

        for (int x = 0; x < rank_card.size(); x++)
        {
            for (int i = 0; i < rank_hand.size(); i++)
            {
                if(rank_hand.get(i) == rank_card.get(x))
                {
                    ranksInteger.add(allRanks.get(x));
                }
            }
        }

        int c = 0;

        Collections.sort(ranksInteger, Collections.reverseOrder());
        for (int k = 0; k < ranksInteger.size() - 1; k++)
        {
            int temp = ranksInteger.get(k) - ranksInteger.get(k + 1);
            if (temp == 1 || temp == 9)
            {
                c++;
            }
        }
        if (c == 4)
            return true;
        else
            return false;
    }

    /**
     * Add a single card at a time to "pokerHand" whilst throwing appropriate exceptions
     * <p> If a "pokerHand" contains more than 5 cards : an exception is thrown! </p>
     * <p> If a "card" is already in the "pokerHand": an exception is thrown! </p>
     * @param card - A single card to be added to a "pokerHand" one at a time
     */
    public void add(Card card) 
    {
        if (pokerHand.size() == FULL_SIZE)
        {
            //If "pokerHand" is full throw an exception!
            throw new CardException("The Hand is Full");
        }
        else if (pokerHand.contains(card))
        {
            //If a "card" is already in the "pokerHand" throw an exception!
            throw new CardException("The Hand Already Contains the Card");
        }
        //Otherwise add a "card" to "pokerHand"
        pokerHand.add(card);
    }
}
