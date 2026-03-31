
import java.util.HashMap;
import java.util.Map;

enum TriggerType {
    Motion, Morning, Night
}

@FunctionalInterface
interface LightBehavior {

    void execute(String room);
}

class SmartRoom {

    private Map<TriggerType, LightBehavior> map = new HashMap<>();

    public void registerBehavior(TriggerType trigger, LightBehavior behavior) {
        map.put(trigger, behavior);
    }

    public void handleTrigger(TriggerType trigger, String room) {
        LightBehavior behavior = map.get(trigger);
        if (behavior != null) {
            behavior.execute(room);
        } else {
            System.out.println("No behavior registered for trigger: " + trigger);
        }
    }
}

public class SmartHomeAutomation {

    public static void main(String[] args) {
        SmartRoom smartRoom = new SmartRoom();
        smartRoom.registerBehavior(TriggerType.Motion,
                room -> System.out.println("Motion detected in " + room + ": turning lights ON at 60% brightness."));

        smartRoom.registerBehavior(TriggerType.Morning,
                room -> System.out.println("Good Morning, turning on the warm Lights on brightness 80% "));

        smartRoom.registerBehavior(TriggerType.Night,
                room -> System.out.println("Good Night! , turning off the lights and playing soothing music "));

        smartRoom.handleTrigger(TriggerType.Motion, "Hallway");
        smartRoom.handleTrigger(TriggerType.Morning, "Bedroom");
        smartRoom.handleTrigger(TriggerType.Night, "Livingroom");

    }
}
