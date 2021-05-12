package pl.piasta.hotel.domain.rooms;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.piasta.hotel.domainmodel.rooms.DateDetails;
import pl.piasta.hotel.domainmodel.rooms.Room;
import pl.piasta.hotel.domainmodel.rooms.RoomCommand;
import pl.piasta.hotel.domainmodel.rooms.SortDetails;
import pl.piasta.hotel.domainmodel.rooms.SortDir;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomsServiceImpl implements RoomsService {

    private final RoomsRepository repository;

    @Override
    public List<Room> getAllAvailableRoomsWithinDateRange(RoomCommand roomCommand) {
        DateDetails dateDetails = roomCommand.getDateDetails();
        SortDetails sortDetails = roomCommand.getSortDetails();
        List<Room> rooms = repository.getAllAvailableRoomsWithinDateRange(dateDetails.getStartDate(), dateDetails.getEndDate());
        sortRooms(rooms, sortDetails);
        return rooms;
    }

    private void sortRooms(List<Room> rooms, SortDetails sortDetails) {
        Comparator<Room> comparator;
        if(sortDetails.getSortBy().equalsIgnoreCase("bedAmount")) {
            comparator = Comparator.comparing(Room::getBedAmount).thenComparing(Room::getStandardPrice);
        } else if(sortDetails.getSortBy().equalsIgnoreCase("standardPrice")) {
            comparator = Comparator.comparing(Room::getStandardPrice).thenComparing(Room::getBedAmount);
        } else {
            comparator = Comparator.comparing(Room::getId);
        }
        if(sortDetails.getSortDir() == SortDir.ASC) {
            rooms.sort(comparator);
        } else {
            rooms.sort(comparator.reversed());
        }
    }

}
