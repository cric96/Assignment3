package part1.simtrafficbase;

/**
 * Class modeling the structure and behaviour of a traffic light
 *  
 */
public class TrafficLight {

	public enum TrafficLightState {GREEN, YELLOW, RED}
	private final String id;
	private TrafficLightState state, initialState;
	private int currentTimeInState;
	private int redDuration, greenDuration, yellowDuration;
	private P2d pos;
	
	public TrafficLight(String id, P2d pos, TrafficLightState initialState, int greenDuration, int yellowDuration, int redDuration) {
		this.id = id;
		this.redDuration = redDuration;
		this.greenDuration = greenDuration;
		this.yellowDuration = yellowDuration;
		this.pos = pos;
		this.initialState = initialState;
	}
	
	public void init() {
		state = initialState;
		currentTimeInState = 0;
	}

	public void step(int dt) {
		switch (state) {
		case TrafficLightState.GREEN: 
			currentTimeInState += dt;
			if (currentTimeInState >= greenDuration) {
				state = TrafficLightState.YELLOW; 
				currentTimeInState = 0;
			}
			break;
		case TrafficLightState.RED: 
			currentTimeInState += dt;
			if (currentTimeInState >= redDuration) {
				state = TrafficLightState.GREEN; 
				currentTimeInState = 0;
			}
			break;
		case TrafficLightState.YELLOW: 
			currentTimeInState += dt;
			if (currentTimeInState >= yellowDuration) {
				state = TrafficLightState.RED; 
				currentTimeInState = 0;
			}
			break;
		default:
			break;
		}
	}

	public String getId() {
		return id;
	}

	public TrafficLightState getState() {
		return state;
	}

	public boolean isGreen() {
		return state.equals(TrafficLightState.GREEN);
	}
	
	public boolean isRed() {
		return state.equals(TrafficLightState.RED);
	}

	public boolean isYellow() {
		return state.equals(TrafficLightState.YELLOW);
	}
	
	public P2d getPos() {
		return pos;
	}
}
