import java.util.*;
public class BlackjackSolitaire {
    private Deck deck;
    private Card[] grid;
    private ArrayList<Card> discardCard;
    private int filledGrid;
    private int totalScore;

    public BlackjackSolitaire() {
        deck = new Deck();
        grid = new Card[20];
        totalScore = 0;
        filledGrid = 0;
        discardCard = new ArrayList<Card>();
    }

    private int getUserLocation() {
        int place = 0;
        Scanner scanner = new Scanner(System.in);
        while (place < 1 || place > 20 || this.grid[place-1] != null ) {
            System.out.println("Enter the location (1-20) to place the card: ");
            place = scanner.nextInt();
            if (place < 1 || place > 20) {
                System.out.println("Error: Invalid input. Enter a number between 1 and 20.");
            } else if (this.grid[place-1] != null ) {
                System.out.println("Error: a card has already been placed in the location. Enter a different place");
            }
        }
        return place;
    }

    public void play() {
        while (filledGrid < 16) {
            Card card = deck.drawCard();
            this.displayGrid();
            int cardLocation = this.getUserLocation();
            grid[cardLocation-1] = card;
            if (cardLocation <= 16) {
                filledGrid++;
            } else {
                this.discardCard.add(card);
                System.out.println("You place the card to the discard card pool. The remaining spot for the pool is " + (4 - discardCard.size()));
            }
        }
        System.out.println("You final grid looks like below, and I'm scoring the hands... ");
        this.displayGrid();
        System.out.println("You final discard card pool is: ");
        if (!discardCard.isEmpty()) {
            for (Card i : discardCard) {
            System.out.print(i.printCard() + "\t");
        }
        } else {
            System.out.println("You haven't placed any card to the discard card pool.");
        }
        this.totalScore = this.calculateScore();
        System.out.println("\n" + "Game over! You scored " + this.totalScore + " points.");
    }

    public void displayGrid() {
        for (int i = 1; i <= 16; i++) {
            if (i <= 10) {
                if (grid[i-1] == null) {
                    System.out.print(i + "\t");
                } else {
                    System.out.print(grid[i-1].printCard() + "\t");
                }
                if (i == 5 || i == 10) {
                    System.out.println();
                }
            } else if (i == 11 || i == 14) {
                if (grid[i-1] == null) {
                    System.out.print("\t" + i + "\t");
                } else {
                    System.out.print("\t" + grid[i-1].printCard() + "\t");
                }
            } else if (i == 12 || i == 15) {
                if (grid[i-1] == null) {
                    System.out.print(i + "\t");
                } else {
                    System.out.print(grid[i-1].printCard() + "\t");
                }
            } else {
                if (grid[i-1] == null) {
                    System.out.print(i + "\n");
                } else {
                    System.out.print(grid[i-1].printCard() + "\n");
                }
            }
            }
        }
    public int calculateScore() {
        int score = 0;
        int col1 = 0;
        int col2 = 0;
        int col3 = 0;
        int col4 = 0;
        int col5 = 0;
        int row1 = 0;
        int row2 = 0;
        int row3 = 0;
        int row4 = 0;
        int aceCount = 0;
        int[] col1Index = {0, 5};
        for (int i : col1Index) {
            col1 += grid[i].getPoint();
            if (grid[i].getValue().equals("A")) {
                aceCount++;
            }
        }
        while (aceCount > 0 && col1 > 21) {
            col1 -= 10;
            aceCount--;
        }
        if (col1 == 21) {
            score += 10;
        } else if (col1 == 20) {
            score += 5;
        } else if (col1 == 19) {
            score += 4;
        } else if (col1 == 18) {
            score += 3;
        } else if (col1 == 17) {
            score += 2;
        } else if (col1 <= 16) {
            score += 1;
        }

        aceCount = 0;
        int[] col5Index = {4, 9};
        for (int i : col5Index) {
            col5 += grid[i].getPoint();
            if (grid[i].getValue().equals("A")) {
                aceCount++;
            }
        }
        while (aceCount > 0 && col5 > 21) {
            col5 -= 10;
            aceCount--;
        }
        if (col5 == 21) {
            score += 10;
        } else if (col5 == 20) {
            score += 5;
        } else if (col5 == 19) {
            score += 4;
        } else if (col5 == 18) {
            score += 3;
        } else if (col5 == 17) {
            score += 2;
        } else if (col5 <= 16) {
            score += 1;
        }
        aceCount = 0;
        int[] col2Index = {1, 6, 10, 13};
        for (int i : col2Index) {
            col2 += grid[i].getPoint();
            if (grid[i].getValue().equals("A")) {
                aceCount++;
            }
        }
        while (aceCount > 0 && col2 > 21) {
            col2 -= 10;
            aceCount--;
        }
        if (col2 == 21) {
            score += 7;
        } else if (col2 == 20) {
            score += 5;
        } else if (col2 == 19) {
            score += 4;
        } else if (col2 == 18) {
            score += 3;
        } else if (col2 == 17) {
            score += 2;
        } else if (col2 <= 16) {
            score += 1;
        }
        aceCount = 0;
        int[] col3Index = {2, 7, 11, 14};
        for (int i : col3Index) {
            col3 += grid[i].getPoint();
            if (grid[i].getValue().equals("A")) {
                aceCount++;
            }
        }
        while (aceCount > 0 && col3 > 21) {
            col3 -= 10;
            aceCount--;
        }
        if (col3 == 21) {
            score += 7;
        } else if (col3 == 20) {
            score += 5;
        } else if (col3 == 19) {
            score += 4;
        } else if (col3 == 18) {
            score += 3;
        } else if (col3 == 17) {
            score += 2;
        } else if (col3 <= 16) {
            score += 1;
        }
        aceCount = 0;
        int[] col4Index = {3, 8, 12, 15};
        for (int i : col4Index) {
            col4 += grid[i].getPoint();
            if (grid[i].getValue().equals("A")) {
                aceCount++;
            }
        }
        while (aceCount > 0 && col4 > 21) {
            col4 -= 10;
            aceCount--;
        }
        if (col4 == 21) {
            score += 7;
        } else if (col4 == 20) {
            score += 5;
        } else if (col4 == 19) {
            score += 4;
        } else if (col4 == 18) {
            score += 3;
        } else if (col4 == 17) {
            score += 2;
        } else if (col4 <= 16) {
            score += 1;
        }

        aceCount = 0;
        int[] row1Index = {0, 1, 2, 3, 4};
        for (int i : row1Index) {
            row1 += grid[i].getPoint();
            if (grid[i].getValue().equals("A")) {
                aceCount++;
            }
        }
        while (aceCount > 0 && row1 > 21) {
            row1 -= 10;
            aceCount--;
        }
        if (row1 == 21) {
            score += 7;
        } else if (row1 == 20) {
            score += 5;
        } else if (row1 == 19) {
            score += 4;
        } else if (row1 == 18) {
            score += 3;
        } else if (row1 == 17) {
            score += 2;
        } else if (row1 <= 16) {
            score += 1;
        }

        aceCount = 0;
        int[] row2Index = {5, 6, 7, 8, 9};
        for (int i : row2Index) {
            row2 += grid[i].getPoint();
            if (grid[i].getValue().equals("A")) {
                aceCount++;
            }
        }
        while (aceCount > 0 && row2 > 21) {
            row2 -= 10;
            aceCount--;
        }
        if (row2 == 21) {
            score += 7;
        } else if (row2 == 20) {
            score += 5;
        } else if (row2 == 19) {
            score += 4;
        } else if (row2 == 18) {
            score += 3;
        } else if (row2 == 17) {
            score += 2;
        } else if (row2 <= 16) {
            score += 1;
        }

        aceCount = 0;
        int[] row3Index = {10, 11, 12};
        for (int i : row3Index) {
            row3 += grid[i].getPoint();
            if (grid[i].getValue().equals("A")) {
                aceCount++;
            }
        }
        while (aceCount > 0 && row3 > 21) {
            row3 -= 10;
            aceCount--;
        }
        if (row3 == 21) {
            score += 7;
        } else if (row3 == 20) {
            score += 5;
        } else if (row3 == 19) {
            score += 4;
        } else if (row3 == 18) {
            score += 3;
        } else if (row3 == 17) {
            score += 2;
        } else if (row3 <= 16) {
            score += 1;
        }

        aceCount = 0;
        int[] row4Index = {13, 14, 15};
        for (int i : row4Index) {
            row4 += grid[i].getPoint();
            if (grid[i].getValue().equals("A")) {
                aceCount++;
            }
        }
        while (aceCount > 0 && row4 > 21) {
            row4 -= 10;
            aceCount--;
        }
        if (row4 == 21) {
            score += 7;
        } else if (row4 == 20) {
            score += 5;
        } else if (row4 == 19) {
            score += 4;
        } else if (row4 == 18) {
            score += 3;
        } else if (row4 == 17) {
            score += 2;
        } else if (row4 <= 16) {
            score += 1;
        }
        return score;
    }

}