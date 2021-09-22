/**
 * The purpose of this class is to model a television. Emran Abbamacha
 * 07/29/2021
 */

public class Television {
	private String MANUFACTURER;
	private int SCREEN_SIZE;
	private boolean powerOn;
	private int channel;
	private int volume;

	public Television(String manufacture, int screenSize) {

		// This constructor sets the default values of Television
		MANUFACTURER = manufacture;
		SCREEN_SIZE = screenSize;
		powerOn = false;
		volume = 20;
		channel = 2;
	}

	/* Returns the volume */
	public int getVolume() {
		return volume;
	}

	/* Returns the channel */
	public int getChannel() {
		return channel;
	}

	/* Returns the manufacturer */
	public String getManufacturer() {
		return MANUFACTURER;
	}

	/* Returns the screen size */
	public int getScreenSize() {
		return SCREEN_SIZE;
	}

	/* Set the channel */
	public void setChannel(int station) {
		this.channel = station;
	}

	/* Set power on or off */
	public void power() {
		powerOn = !powerOn;
	}

	/* Increase the volume */
	public void increaseVolume() {
		volume = volume + 1;
	}

	/* Decrease the volume */
	public void decreaseVolume() {
		volume = volume - 1;
	}
}
