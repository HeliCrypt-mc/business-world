package fr.pokediamond.businessworld.commands;

public class Mine {
	private boolean MineP;
	private boolean MineR;
	
	public Mine(boolean MineP, boolean MineR) {
		this.MineP = MineP;
		this.MineR = MineR;
	}

	public boolean getMineP() {
		return MineP;
	}

	public void setMineP(boolean mineP) {
		MineP = mineP;
		System.out.println("le setMineP a ete enclenché");
	}

	public boolean getMineR() {
		return MineR;
	}

	public void setMineR(boolean mineR) {
		MineR = mineR;
		System.out.println("le setMineR a ete enclenché");
	}
	
}
