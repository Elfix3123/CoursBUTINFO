package tp05.tabledoperation;

public enum OperationEnum {
	ADDITION("Addition"),
	SOUSTRACTION("Soustraction"),
	MULTIPLICATION("Multiplication");

	private String libelle;

	private OperationEnum(String libelle) {
		this.libelle = libelle;
	}

	public static OperationEnum getOperationEnum(int numeroOperation) {
		if (numeroOperation == 1) {
			return ADDITION;
		}
		else if (numeroOperation == 2) {
			return SOUSTRACTION;
		}
		else {
			return MULTIPLICATION;
		}
	}
}