package sudoku;

import java.util.*;

public class Grid {
	private int[][] values;

	//
	// DON'T CHANGE THIS.
	//
	// Constructs a Grid instance from a string[] as provided by
	// TestGridSupplier.
	// See TestGridSupplier for examples of input.
	// Dots in input strings represent 0s in values[][].
	//
	public Grid(String[] rows) {
		values = new int[9][9];
		for (int j = 0; j < 9; j++) {
			String row = rows[j];
			char[] charray = row.toCharArray();
			for (int i = 0; i < 9; i++) {
				char ch = charray[i];
				if (ch != '.')
					values[j][i] = ch - '0';
			}
		}
	}

	public Grid(int[][] values) {
		this.values = values;
	}

	public Grid copy() {
		int[][] valuesCopy = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				valuesCopy[i][j] = this.values[i][j];
			}
		}
		return new Grid(valuesCopy);
	}

	public int[][] getValues() {
		return this.values;
	}
	
	//
	// DON'T CHANGE THIS.
	//
	public String toString() {
		String s = "";
		for (int j = 0; j < 9; j++) {
			for (int i = 0; i < 9; i++) {
				int n = values[j][i];
				if (n == 0)
					s += '.';
				else
					s += (char) ('0' + n);
			}
			s += "\n";
		}
		return s;
	}

	//
	// DON'T CHANGE THIS.
	// Copy ctor. Duplicates its source. You’ll call this 9 times in
	// next9Grids.
	//
	Grid(Grid src) {
		values = new int[9][9];
		for (int j = 0; j < 9; j++)
			for (int i = 0; i < 9; i++)
				values[j][i] = src.values[j][i];
	}

	//
	// COMPLETE THIS
	//
	//
	// Finds an empty member of values[][]. Returns an array list of 9 grids
	// that look like the current grid,
	// except the empty member contains 1, 2, 3 .... 9. Returns null if the
	// current grid is full. Don’t change
	// “this�? grid. Build 9 new grids.
	//
	//
	// Example: if this grid = 1........
	// .........
	// .........
	// .........
	// .........
	// .........
	// .........
	// .........
	// .........
	//
	// Then the returned array list would contain:
	//
	// 11....... 12....... 13....... 14....... and so on 19.......
	// ......... ......... ......... ......... .........
	// ......... ......... ......... ......... .........
	// ......... ......... ......... ......... .........
	// ......... ......... ......... ......... .........
	// ......... ......... ......... ......... .........
	// ......... ......... ......... ......... .........
	// ......... ......... ......... ......... .........
	// ......... ......... ......... ......... .........
	//
	public ArrayList<Grid> next9Grids() {
		int xOfNextEmptyCell;
		int yOfNextEmptyCell;

		// Find x,y of an empty cell.
		if (!this.isFull()) {
			ArrayList<Grid> grid = new ArrayList<>();
			for (int row = 0; row < 9; row++) {
				for (int col = 0; col < 9; col++) {
					if (values[row][col] == 0) {
						for (int i = 1; i <= 9; i++) {
							Grid copy = this.copy();
							copy.getValues()[row][col] = i;
							grid.add(copy);
						}
						return grid;
					}
				}
			}
		}
		return null;
	}

	//
	// COMPLETE THIS
	//
	// Returns true if this grid is legal. A grid is legal if no row, column, or
	// 3x3 block contains a repeated 1, 2, 3, 4, 5, 6, 7, 8, or 9.
	//
	public boolean isLegal() {
		// Check every row. If you find an illegal row, return false.
		boolean result = true;
		for (int i = 0; i < values.length; i++) {
			Set<Integer> set = new HashSet<Integer>();
			for (int j = 0; j < values[0].length; j++) {
				if (values[i][j] != 0) {
					if (set.contains(values[i][j])) {
						result = false;
					}
					set.add(values[i][j]);
				}
			}
		}
		// Check every column. If you find an illegal column, return false.
		for (int j = 0; j < values[0].length; j++) {
			Set<Integer> set = new HashSet<Integer>();
			for (int i = 0; i < values.length; i++) {
				if (values[i][j] != 0) {
					if (set.contains(values[i][j])) {
						result = false;
					}
					set.add(values[i][j]);
				}
			}
		}
		// Check every block. If you find an illegal block, return false.
		for (int i = 0; i < 3; i += 3) {
			for (int j = 0; j < 3; j += 3) {
				Set<Integer> set = new HashSet<Integer>();
				for (int k = 0; k < 3; k++) {
					for (int l = 0; l < 3; l++) {
						int value = values[i + k][j + l];
						if (value != 0) {
							if (set.contains(value)) {
								result = false;
							}
							set.add(value);
						}
					}
				}
			}
		}
		
		// All rows/cols/blocks are legal.
		return result;
	}

	public boolean containsNonZeroRepeat(int[] nonZeroInts) {
		nonZeroInts = new int[9];
		Arrays.sort(nonZeroInts);
		for (int i = 1; i <= nonZeroInts.length; i++) {
			if (nonZeroInts[i] == nonZeroInts[i - 1]) {
				return true;
			}
		}
		return false;
	}

	//
	// COMPLETE THIS
	//
	// Returns true if every cell member of values[][] is a digit from 1-9.
	//
	public boolean isFull() {
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values[0].length; j++) {
				if (values[i][j] < 1 || values[i][j] > 9) {
					return false;
				}
			}
		}
		return true;
	}

	//
	// COMPLETE THIS
	//
	// Returns true if x is a Grid and, for every (i,j),
	// x.values[i][j] == this.values[i][j].
	//
	public boolean equals(Object x) {
		Grid that = (Grid) x;
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values[0].length; j++) {
				if (this.values[i][j] != that.values[i][j])
					return false;
			}
		}
		return true;
	}
}
