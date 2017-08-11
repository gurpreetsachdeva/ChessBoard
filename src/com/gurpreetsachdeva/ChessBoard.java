package com.gurpreetsachdeva;

public class ChessBoard {

	// Used Symmetery to calculate and replicate.

	double[][] prob = new double[][] {    { 0.25, 0.375, 0.375, 0.25 },
									{ 0.375, 0.5, 0.5, 0.375 },
									{ 0.375, 0.5, 0.5, 0.375 },
									{ 0.25, 0.375, 0.375, 0.25 } };

	// Imagine a board with row indexes as 0 to 7 , column indexes 0 to 7;

	public double calculate(int startRow,int startCol,int moves) {
		
		//Due to symmetery
		//(0,0)>{(2,1),(2,1)}
		//Generalize add/subtract 2 to one dimension and 1 to other dimension.Eight possiblities for every move
		//After any move the new position seems identical
		if (startRow<0 || startRow>3) return 0;
		if (startCol<0 || startCol>3) return 0;
		System.out.println("Test"+prob[0][0]);
		if (moves<=1)
		{
			return prob[startRow][startCol];
		}
		else 
		{
			return prob[startRow][startCol]*(calculate(startRow+2,startCol+1,moves-1)+
			                                 calculate(startRow+2,startCol-1,moves-1)+
			                                 calculate(startRow-2,startCol+1,moves-1)+
			                                 calculate(startRow-2,startCol-1,moves-1)+
			                                 calculate(startRow+1,startCol+2,moves-1)+
			                                 calculate(startRow+1,startCol-2,moves-1)+
			                                 calculate(startRow-1,startCol+2,moves-1)+
			                                 calculate(startRow-1,startCol-2,moves-1));
		}
		
		
		
	}

	public static void main(String[] args) {

		ChessBoard cb = new ChessBoard();

		int startRow = 0;
		int startCol = 0;
		System.out.println(cb.calculate(startRow, startCol, 1));
	}
}