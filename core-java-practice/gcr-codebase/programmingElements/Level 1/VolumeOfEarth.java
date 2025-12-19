// volume of earth in cubic radius and in cubic miles.
public class VolumeOfEarth {
    public static void main(String[] args) {
        // Radius of the Earth in miles
        double radiusInMiles = 3958.8;

        // Calculate volume using the formula V = (4/3) * π * r^3
        double volumeInCubicMiles = (4.0 / 3.0) * Math.PI * Math.pow(radiusInMiles, 3);

        // Convert cubic miles to cubic kilometers (1 mile = 1.609 km)
        double radiusInKilometers = radiusInMiles * 1.609;
        double volumeInCubicKilometers = (4.0 / 3.0) * Math.PI * Math.pow(radiusInKilometers, 3);

        // Print the results
        System.out.printf("Volume of the Earth in cubic miles:", volumeInCubicMiles);
        System.out.printf("Volume of the Earth in cubic kilometers:", volumeInCubicKilometers);
    }
}
