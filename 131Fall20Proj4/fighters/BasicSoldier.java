/*@Chikezie Okoli
 * @*/
package fighters;

import framework.BattleField;
import framework.Random131;

/*Basic soldier describes the characteristics and behaviors of a soldier*/
public class BasicSoldier {
	// final static constants, which make reference to fighting attributes of
	// all soldiers in the class
	public final static int INITIAL_HEALTH = 10;
	public final static int ARMOR = 20;
	public final static int STRENGTH = 30;
	public final static int SKILL = 40;
	// Other static constants that are used to specify directions
	public final static int UP = 0;
	public final static int RIGHT = 1;
	public final static int DOWN = 2;
	public final static int LEFT = 3;
	public final static int UP_AND_RIGHT = 4;
	public final static int DOWN_AND_RIGHT = 5;
	public final static int DOWN_AND_LEFT = 6;
	public final static int UP_AND_LEFT = 7;
	public final static int NEUTRAL = -1;
	// Instance variables that define the state
	public final BattleField grid;
	public int row, col;
	public int health;
	public final int team;

	/*
	 * Constructors
	 *
	 * @gridIn the first parameter representing the Battlefield
	 * 
	 * @teamIn represents the team the current soldier is on, whether blue or
	 * red
	 * 
	 * @rowIn determines the row the soldier is on the BattleField
	 * 
	 * @ColIn determines the col the soldier is on the battlefield
	 * 
	 * @health which is an attribute of a soldier
	 */
	public BasicSoldier(BattleField gridIn, int teamIn, int rowIn, int colIn) {
		this.grid = gridIn;
		this.row = rowIn;
		this.col = colIn;
		this.team = teamIn;
		this.health = INITIAL_HEALTH;
	}

	/*
	 * instance methods that define behaviors Instance method can move, which
	 * determines whether the soldier can move depending on the soldiers
	 * surroundings If the positions above or left or below or right of the
	 * soldier are empty the code returns true else the code returns false
	 */

	public boolean canMove() {
		int enemyTeam;
		int team = 0;
		if (team == BattleField.RED_TEAM) {
			enemyTeam = BattleField.BLUE_TEAM;
		} else {
			enemyTeam = BattleField.RED_TEAM;
			team = BattleField.BLUE_TEAM;
		}
		// This instance method returns true if the soldiers surroundings is
		// empty and false otherwise
		if (grid.get(row - 1, col) == BattleField.EMPTY) {
			return true;
		} else if (grid.get(row + 1, col) == BattleField.EMPTY) {
			return true;
		} else if (grid.get(row, col - 1) == BattleField.EMPTY) {
			return true;
		} else if (grid.get(row, col + 1) == BattleField.EMPTY) {
			return true;
		} else {
			return false;
		}

	}

	/*
	 * Instance method numberofenemies remaining counts the number of soldiers
	 * not on current soldiers team
	 */
	public int numberOfEnemiesRemaining() {
		int enemyTeam = 0;
		for (int row = 0; row < grid.getRows(); row++) {
			for (int col = 0; col < grid.getCols(); col++) {

				if (team == BattleField.RED_TEAM
						&& grid.get(row, col) == BattleField.BLUE_TEAM) {
					enemyTeam++;
				}
				if (this.team == BattleField.BLUE_TEAM
						&& grid.get(row, col) == BattleField.RED_TEAM) {
					enemyTeam++;
				}
			}
		}
		// returns the number of soldiers on the opposite team to the current
		// soldier
		return enemyTeam;
	}

	/*
	 * Instance method getDistance determines the number of moves away from the
	 * parameters the current soldier is
	 * 
	 * @destinationRow, the destination the user is to get to on the rows
	 * 
	 * @destinationCol, the destination on the col This code returns the number
	 * of moves it took the current soldier to get to the specified locations
	 */
	public int getDistance(int destinationRow, int destinationCol) {
		int horizontalDistance = Math.abs(col - destinationCol);
		int verticalDistance = Math.abs(row - destinationRow);
		int moves = verticalDistance + horizontalDistance;
		return moves;
	}

	/*
	 * This method determines which way the current soldier would go in order to
	 * arrive at the specified parameters
	 * 
	 * @destnationRow, the distance from the soldier in rows
	 * 
	 * @destinationCol, the distance from the soldier on the col
	 */
	public int getDirection(int destinationRow, int destinationCol) {
		if (row > destinationRow && col == destinationCol) {
			return UP;
			// returns up if the row is below the destination row
		} else if (row < destinationRow && col < destinationCol) {
			return DOWN_AND_RIGHT;
			// returns down right if the current row is less than destinationRow
			// and col is less than destinationCol
		} else if (row > destinationRow && col > destinationCol) {
			return UP_AND_LEFT;
			/*
			 * returns up and left if the row is greater than destinationRow and
			 * col greater than destinationCol
			 */
		} else if (row == destinationRow && col > destinationCol) {
			return LEFT;
			/*
			 * returns left if row equals to destinationRow and col greater than
			 * destinationCol
			 */
		} else if (row < destinationRow && col == destinationCol) {
			return DOWN;
			// Returns down if row is less than destinartionCol and col equals
			// destinationCol
		} else if (row == destinationRow && col < destinationCol) {
			return RIGHT;
			// returns right if row equals destinationRow and col less than
			// destinationCol
		} else if (row > destinationRow && col < destinationCol) {
			return UP_AND_RIGHT;
			// returns up and right if row is greater than destinationRow and
			// col less than destinationCol
		} else if (row < destinationRow && col > destinationCol) {
			return DOWN_AND_LEFT;
			// returns down and left if row is less than destinationRow and col
			// greater than destinationCOl
		} else {
			// Else the code returns NEUTRAL which is -1
			return NEUTRAL;
		}

	}

	/*
	 * This method is to get the direction of the nearest teamate
	 */
	public int getDirectionOfNearestFriend() {

		int nearestFriendRow = 0;
		int nearestFriendCol = 0;
		int closestFriend = Integer.MAX_VALUE;
		boolean statement = false;

		for (int row = 0; row < grid.getRows(); row++) {
			for (int col = 0; col < grid.getCols(); col++) {
				if (grid.get(row, col) == this.team
						&& getDistance(row, col) != 0) {
					if (getDistance(row, col) < closestFriend) {
						closestFriend = getDistance(row, col);
						nearestFriendRow = row;
						nearestFriendCol = col;
						statement = true;

					}
				}
			}
		}
		// returns the direction of the nearest teammate if there are any
		// teammates around
		if (statement == true) {
			return getDirection(nearestFriendRow, nearestFriendCol);
			// else it will return NEUTRAL which means there are no teammates
			// nearby
		} else {
			return NEUTRAL;
		}

	}

	/*
	 * Count nearby friends returns the number of friends that can be reached
	 * with less or equal moves than the radius specified in the parameter
	 * 
	 * @radius determines the number of moves away a nearby friend is from a
	 * current soldier
	 */
	public int countNearbyFriends(int radius) {
		int NearbyFriends = 0;
		int distance;
		int teamSoldier;
		for (int row = 0; row < grid.getRows(); row++) {
			for (int col = 0; col < grid.getCols(); col++) {
				teamSoldier = grid.get(row, col);
				if (teamSoldier == this.team && getDistance(row, col) != 0) {
					distance = getDistance(row, col);
					if (distance <= radius) {
						NearbyFriends++;
					}
				}
			}
		}
		// returns the number of nearby friends that can be reached in <= radius
		// moves from current soldier
		return NearbyFriends;
	}

	/*
	 * getDirection of nearest enemy determines the closest enemies to a current
	 * soldier that can be reache with less or equal moves o the radius
	 * 
	 * @radius determines the number of moves away an enemy is from the current
	 * soldier
	 */
	public int getDirectionOfNearestEnemy(int radius) {
		// variables for the row,col the enemy is on and the closest enemy away
		// from the current soldier
		int nearestEnemyRow = 0;
		int nearestEnemyCol = 0;
		int closestEnemy = Integer.MAX_VALUE;
		boolean statement = false;

		for (int row = 0; row < grid.getRows(); row++) {
			for (int col = 0; col < grid.getCols(); col++) {
				if (grid.get(row, col) != this.team
						&& getDistance(row, col) != 0
						&& grid.get(row, col) != BattleField.EMPTY
						&& grid.get(row, col) != BattleField.OBSTACLE
						&& grid.get(row, col) != BattleField.OUT_OF_BOUNDS) {
					if (getDistance(row, col) < closestEnemy
							&& getDistance(row, col) <= radius) {
						closestEnemy = getDistance(row, col);
						nearestEnemyRow = row;
						nearestEnemyCol = col;
						statement = true;
					}
				}
			}
		}
		/*
		 * returns get direction of the enemy if there is an enemy radius moves
		 * away from the current soldier
		 */
		if (statement == true) {
			return getDirection(nearestEnemyRow, nearestEnemyCol);
		} else {
			/*
			 * returns neutral if there are no enemies reachable in less than
			 * radius moves away
			 */
			return NEUTRAL;
		}
	}

	// This method is the heart of the soldier, gives the soldier three options
	// whether to attack, move or do nothing
	public void performMyTurn() {
		// Means there are still enemies remaining
		if (team == BattleField.RED_TEAM) {// If my soldier is in the red team
			/*
			 * These are the attacks on the enemy soldier if there is an enemy
			 * soldier above, below, left and right of the current soldier the
			 * current soldier will carry out the attck command
			 */
			if (grid.get(row - 1, col) == BattleField.BLUE_TEAM) {
				grid.attack(row - 1, col);
			} else if (grid.get(row + 1, col) == BattleField.BLUE_TEAM) {
				grid.attack(row + 1, col);
			} else if (grid.get(row, col - 1) == BattleField.BLUE_TEAM) {
				grid.attack(row, col - 1);
			} else if (grid.get(row, col + 1) == BattleField.BLUE_TEAM) {
				grid.attack(row, col + 1);
				/*
				 * Otherwise if there are no enemies around the current soldier
				 * the current soldier will just move to the next position
				 * either up,down left or right
				 */
			} else if (grid.get(row - 1, col) == BattleField.EMPTY) {
				row = row - 1;
			} else if (grid.get(row + 1, col) == BattleField.EMPTY) {
				row = row + 1;
			} else if (grid.get(row, col - 1) == BattleField.EMPTY) {
				col = col - 1;
			} else if (grid.get(row, col + 1) == BattleField.EMPTY) {
				col = col + 1;
				// If there is no way to attack or move the current soldier will
				// just stay in the same position and wait till its next turn
			} else {

			}
		} else if (team == BattleField.BLUE_TEAM) {
			/*
			 * These are attack commands if theere are soldier up down left or
			 * right of the current soldier
			 */
			if (grid.get(row - 1, col) == BattleField.RED_TEAM) {
				// attack if there is a soldier on the left
				grid.attack(row - 1, col);
			} else if (grid.get(row + 1, col) == BattleField.RED_TEAM) {
				// attack if there is a soldier on the right
				grid.attack(row + 1, col);
			} else if (grid.get(row, col - 1) == BattleField.RED_TEAM) {
				// attack if there is a soldier above
				grid.attack(row, col - 1);
			} else if (grid.get(row, col + 1) == BattleField.RED_TEAM) {
				// attack if there is a soldier below
				grid.attack(row, col + 1);
			} else if (grid.get(row - 1, col) == BattleField.EMPTY) {
				// if the left side is open without obstacles you move to the
				// left side
				row = row - 1;
			} else if (grid.get(row + 1, col) == BattleField.EMPTY) {
				// if there is no obstacle or enemy soldier beside you move to
				// the right side
				row = row + 1;
			} else if (grid.get(row, col - 1) == BattleField.EMPTY) {
				// moves to the space above if there is no enemy above and
				// obstacle
				col = col - 1;
			} else if (grid.get(row, col + 1) == BattleField.EMPTY) {
				// moves to the space below if there is no enemy or obstacle
				// below
				col = col + 1;
				// Else the soldier stays in the same position
			} else {

			}
		}
	}

}
