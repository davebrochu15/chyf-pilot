package nrcan.cccmeo.chyf.db;

public class Flowpath {
	
	private String type;
	private String rank;
	private String nameId;
	private String name;
	private int certainty;
	private String linestring;
	
	public Flowpath() {
		
	}
	
	public Flowpath(String type, String rank, String name, String nameId, int certainty, String Linestring) {
		this.type = type;
		this.rank = rank;
		this.name = name;
		this.nameId = nameId;
		this.certainty = certainty;
		this.linestring = Linestring;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getNameId() {
		return nameId;
	}

	public void setNameId(String nameId) {
		this.nameId = nameId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCertainty() {
		return certainty;
	}

	public void setCertainty(int certainty) {
		this.certainty = certainty;
	}

	public String getLinestring() {
		return linestring;
	}

	public void setLinestring(String linestring) {
		this.linestring = linestring;
	}

}
