package application;

public class Case {
	// attributes
	private boolean hasPigeon;
	private boolean hasNourriture;

	// Constructor
	public Case() {
		hasPigeon = false;
		hasNourriture = false;
	}

	// Methods
	public void lessPigeon() {
		hasPigeon = false;
		return;
	}

	public void lessNourriture() {
		hasNourriture = false;
		return;
	}

	public void morePigeon() {
		hasPigeon = true;
		return;
	}

	public void moreNourriture() {
		hasNourriture = true;
		return;
	}

	public boolean getHasPigeon() {
		return hasPigeon;
	}

	public boolean getHasNourriture() {
		return hasNourriture;
	}

}
