
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilteringExpiringMemberships {

    static class GymMember {

        private final String name;
        final private LocalDate membershipExpiryDate;

        public GymMember(String name, LocalDate membershipExpiryDate) {
            this.name = name;
            this.membershipExpiryDate = membershipExpiryDate;
        }

        public String getName() {
            return name;
        }

        public LocalDate getMembershipExpiryDate() {
            return membershipExpiryDate;
        }

        @Override
        public String toString() {
            return "GymMember{"
                    + "name='" + name + '\''
                    + ", membershipExpiryDate=" + membershipExpiryDate
                    + '}';
        }
    }

    public static void main(String[] args) {

        List<GymMember> members = Arrays.asList(
                new GymMember("Alice", LocalDate.now().plusDays(5)),
                new GymMember("Bob", LocalDate.now().plusDays(15)),
                new GymMember("Charlie", LocalDate.now().plusDays(40)),
                new GymMember("David", LocalDate.now().minusDays(2)), // already expired
                new GymMember("Eva", LocalDate.now().plusDays(29))
        );

        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);

        // Filter members whose membership expires within the next 30 days
        List<GymMember> expiringSoon = members.stream()
                .filter(member -> {
                    LocalDate expiry = member.getMembershipExpiryDate();
                    return (!expiry.isBefore(today)) // expiry >= today
                            && (!expiry.isAfter(next30Days)); // expiry <= today + 30
                })
                .collect(Collectors.toList());

        expiringSoon.forEach(System.out::println);
    }
}
