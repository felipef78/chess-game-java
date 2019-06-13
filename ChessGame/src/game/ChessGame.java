package game;

import enums.ColorType;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author felip
 */
public class ChessGame {
    private Chessboard board;
    private Player player1;
    private Player player2;
    private Map<Player,List> moveHistory;
    private Map<Player,ColorType> selectedPieceColor;
    
    public void startGame(){
        
    }
    
    public Player declareWinner() {
        return null;
    }
    
    
}

/*
Player chooses piece to move.
Piece makes legal move according to its own move rules.
In addition to purely move-based rules, there's also capture logic, so a bishop cannot move from a1-h8 if there's a piece sitting on c3.
If the player was previous under check and the move does not remove the check, it must be undone.
If the move exposes check, it must be undone / disallowed.
If player captures a piece, remove the piece (including en passant!)
If the piece is a pawn reaching the back rank, promote it.
If the move is a castling, set the new position of the rook accordingly. But a king and rook can only castle if they haven't moved, so you need to keep track of that. And if the king moves through a check to castle, that's disallowed, too.
If the move results in a stalemate or checkmate, the game is over.
There may be more even (?). This is a complicated step, more than just counting and subsequently occupying spaces.

So my general intuition would be to just call:

Game.move(currentSpot, NewSpot);
And the move method would contain all the code to validate the steps above:

Check Piece.isValidMove(currentSpot, newSpot); - probably need castling logic here since king moves more than 1 space and rook jumps the king)
Check Player.isChecked() (which is just sugar for Player.Pieces["King"].CanBeCaptured() - more fun logic here!)
Check if newSpot contains a piece and if so, newSpot.Piece.Remove();
Build some logic to call Piece.CheckEnPassant() (Piece is pawn, first move, 2 steps, past an enemy pawn who moved into capturing position on previous move - have fun with that!)
Piece.CheckPromote() (Piece is pawn, move ends on opposing player's back rank)
Check if Game.isOver(), which checks Game.isStaleMate() and Game.isCheckMate().
*/