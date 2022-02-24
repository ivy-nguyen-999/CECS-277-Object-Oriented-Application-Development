package cecs277DemoTermProject;
/**
 * Cleaning Room class for Visitor Pattern, will record what has
 * 		been cleaned depending on type of room.
 * @author Vy Nguyen and Nicki Huynh
 * @date 12/09/2019
 */
public class CleaningRoomsVisitorImpl implements CleaningRoomsVisitor {
	/** What has been cleaned in the room */
	private String result;
	
	@Override
	public String visit(BasicRoom room) {
        result = "Linens changed"
                + "\nFloor towels have been replaced";
        return result;
	}

	@Override
	public String visit(DeluxeRoom room) {
        result = "Linens changed"
                + "\nAll towels have been replaced";
        return result;
	}

	@Override
	public String visit(Suite room) {
        result = "Linens changed"
                + "\nAll towels have been replaced"
                + "\nHamburger on the pillow";
        return result;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
