package cecs277DemoTermProject;
/**
 * The runner class for entire Term Project.
 * @author Vy Nguyen and Nicki Huynh
 * @date 12/09/2019
 */
import java.io.IOException;
import java.util.Scanner;

public class TermProjectRunner {

	public static void main(String[] args) throws IOException {
		// Create the motel and rooms
		RoachMotel motel = RoachMotel.getRoachMotel();
		motel.buildRoachMotel("Del Luna", 5);
		MotelRoomFactory factory = new MotelRoomFactory();
		motel.addRooms(factory.getMotelRoom(MotelRoomType.SUITE, "101"));
		motel.addRooms(factory.getMotelRoom(MotelRoomType.DELUXE_ROOM, "102"));
		motel.addRooms(factory.getMotelRoom(MotelRoomType.BASIC_ROOM, "103"));
		motel.addRooms(factory.getMotelRoom(MotelRoomType.BASIC_ROOM, "104"));
		motel.addRooms(factory.getMotelRoom(MotelRoomType.DELUXE_ROOM, "105"));

		// Previews available rooms and checks in first colony with amenities
		System.out.println(motel);
		RoachColony first = new RoachColony("first colony", 100, 1.1);
		MotelRoom roomOne = motel.checkIn(first);
		roomOne = new Shower(new RefillBar(new Spa(new FoodBar(roomOne))));
		System.out.println(motel.updateCheckIn(roomOne));
		System.out.println(motel);

		// Gets second colony checked in, set room to "Do Not Disturb" and throws party
		RoachColony second = new RoachColony("second colony", 1000, 1.5);
		MotelRoom roomTwo = motel.checkIn(second);
		roomTwo = new Shower(new RefillBar(roomTwo));
		System.out.println(motel.updateCheckIn(roomTwo));
		roomTwo.setDoNotDisturb();
		System.out.println(motel);
		second.throwParty();
		System.out.println(motel);

		// Create 4 more colonies who tries to check into motel
		RoachColony third = new RoachColony("third colony", 230, 1.03);
		MotelRoom roomThree = motel.checkIn(third);
		System.out.println(motel.updateCheckIn(roomThree));
		RoachColony fourth = new RoachColony("fourth colony", 234, 1.05);
		MotelRoom roomFour = motel.checkIn(fourth);
		System.out.println(motel.updateCheckIn(roomFour));
		RoachColony fifth = new RoachColony("fifth colony", 650, 1.6);
		MotelRoom roomFive = motel.checkIn(fifth);
		System.out.println(motel.updateCheckIn(roomFive));
		System.out.println(motel);
		RoachColony sixth = new RoachColony("sixth colony", 450, 1.5);
		MotelRoom roomSix = motel.checkIn(sixth);
		System.out.println(motel.updateCheckIn(roomSix));

		// Shows cleaning status of rooms
		System.out.println(motel.cleaningStatus());

		// Checks out first and second colonies from motel
		System.out.println(motel.checkOut(first, 2, new RoachPal("ok", "ok@ok.ok")));
		System.out.println(motel.checkOut(second, 3, new MasterRoachCredit("halo", "023456789298", "546", "09/23/2022")));
		System.out.println(motel);
		System.out.println();

		// Shows transaction log from check outs
		System.out.println("Display the contents of the transaction log: ");
		Scanner reader = new Scanner(motel.getTransactionLog());
		while (reader.hasNextLine()) {
			System.out.println(reader.nextLine());
		} //While the text file has a next line, will continue to loop

		System.out.println("\nCompleted Satisfactorily");
	}
}
