
import java.util.Arrays;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HospitalDoctorAvailability {

    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    static class Doctor {

        final private String name;
        final private String specialty;
        final private Set<Day> availableDays;

        public Doctor(String name, String specialty, Set<Day> availableDays) {
            this.name = name;
            this.specialty = specialty;
            this.availableDays = availableDays;
        }

        public String getName() {
            return name;
        }

        public String getSpecialty() {
            return specialty;
        }

        public Set<Day> getAvailableDays() {
            return availableDays;
        }

        @Override
        public String toString() {
            return "Doctor{name='" + name + '\''
                    + ", specialty='" + specialty + '\''
                    + ", availableDays=" + availableDays + '}';
        }
    }

    public static void main(String[] args) {

        List<Doctor> doctors = Arrays.asList(
                new Doctor("Dr. A", "Cardiologist",
                        EnumSet.of(Day.MONDAY, Day.WEDNESDAY, Day.SATURDAY)),
                new Doctor("Dr. B", "Dermatologist",
                        EnumSet.of(Day.TUESDAY, Day.THURSDAY)),
                new Doctor("Dr. C", "Neurologist",
                        EnumSet.of(Day.SATURDAY, Day.SUNDAY)),
                new Doctor("Dr. D", "Cardiologist",
                        EnumSet.of(Day.SUNDAY)),
                new Doctor("Dr. E", "Pediatrician",
                        EnumSet.of(Day.FRIDAY))
        );

        List<Doctor> weekendDoctors = doctors.stream()
                .filter(d -> d.getAvailableDays().contains(Day.SATURDAY)
                || d.getAvailableDays().contains(Day.SUNDAY))
                .sorted(Comparator.comparing(Doctor::getSpecialty)
                        .thenComparing(Doctor::getName))
                .collect(Collectors.toList());

        weekendDoctors.forEach(System.out::println);
    }
}
