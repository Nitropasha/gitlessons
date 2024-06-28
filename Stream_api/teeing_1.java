package Stream_api;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class teeing_1 {
    public static void main(String[] args) {
        var result =
                Stream.of(
                                // Guest(String name, boolean participating, Integer participantsNumber)
                                new Guest("Marco", true, 3),
                                new Guest("David", false, 2),
                                new Guest("Roger",true, 6))
                        .collect(Collectors.teeing(
                                // Первый коллектор, мы выбираем только тех, кто подтвердил участие
                                Collectors.filtering(Guest::isParticipating,
                                        // мы хотим взять только имя в списке
                                        Collectors.mapping(o -> o.getName(), Collectors.toList())),
                                // второй коллектор, мы хотим найти общее количество участников
                                Collectors.summingInt(Guest::getParticipantsNumber),
                                // мы объединяем коллекторы в новый объект,
                                // значения передаются неявно
                                EventParticipation::new
                        ));


        System.out.println(result);
        // Результат
        // EventParticipation { guests = [Marco, Roger],
        // total number of participants = 11 }

        var result2 =
                Stream.of(
                                // Guest(String name, boolean participating, Integer participantsNumber)
                                new Guest("Marco", true, 3),
                                new Guest("David", false, 2),
                                new Guest("Roger", true, 6))
                        .collect(Collectors.teeing(
                                // Первый коллектор, мы выбираем только тех, кто подтвердил участие
                                Collectors.filtering(Guest::isParticipating,
                                        // мы хотим взять только имя в списке
                                        Collectors.mapping(o -> o.getName(), Collectors.toList())),
                                // второй коллектор, мы хотим найти общее количество участников
                                Collectors.summingInt(Guest::getParticipantsNumber),
                                // мы объединяем коллекторы в новый объект, явно передавая параметры
                                (guestNameList, totalNumberOfParticipants) ->
                                        new EventParticipation(guestNameList, totalNumberOfParticipants)
                        ));

        System.out.println(result2);
    }
}
class Guest {
    private String name;
    private boolean participating;
    private Integer participantsNumber;
    public Guest(String name, boolean participating,
                 Integer participantsNumber) {
        this.name = name;
        this.participating = participating;
        this.participantsNumber = participantsNumber;
    }
    public boolean isParticipating() {
        return participating;
    }
    public Integer getParticipantsNumber() {
        return participantsNumber;
    }

    public String getName() {
        return name;
    }
}
class EventParticipation {
    private List<String> guestNameList;
    private Integer totalNumberOfParticipants;
    public EventParticipation(List<String> guestNameList,
                              Integer totalNumberOfParticipants) {
        this.guestNameList = guestNameList;
        this.totalNumberOfParticipants = totalNumberOfParticipants;
    }
    @Override
    public String toString() {
        return "EventParticipation { " +
                "guests = " + guestNameList +
                ", total number of participants = " + totalNumberOfParticipants +
                " }";
    }}