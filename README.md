# hc07-FishingTextbook

###Dakotah Norman Senior Project Repository
	
- Installation instructions:
    - Clone the repository off GitHub.
	- Download Android Studios.
	- Copy files over to AndroidStudiosProjects folder.
	- Add two application dependencies. (These are for the Google Map)
		- Google Repository
		- Google Play Services
	- After adding the dependencies, build the application.
	- After building the application, run the application on an Android device that is connected to the computer.
	- Congratulations, you now have the application on your Android device.
- Basic User's Guide
	- There are four main buttons for this application
		- Weather
		- Map
		- Fishing Plan
		- Journal (didn't have time to get to this)
	- Each button correlates to an activity which displays its respective name.
	- For the Weather function, it displays a default value of Hanover, US. (which is unfortunately not our Hanover.)
		- To change the city that is displayed, simply type your desired city in the following format: "city, state".
		- If your city is not found by the OpenWeatherMap API, it will display a message telling you "No weather data was found".
	- For the Map function, it displays a Google Maps API where you can scroll around the world.
		- The button in the top right of the Map activity is designed to go to your current location when the button is clicked.
			- Sadly, I ran out of time and was unable to implement this function.
	- For the Fishing Plan function, this is designed to take inputs of the current conditions that you are facing while you are fishing.	
		- For example: If the water temperature is 70 degrees, there are rocks in the lake, there is complete cloud cover, there is wind, and the water clarity is stained: the Fishing Plan would display a bait that matches those inputs from the database.
		- When you click "Find me baits" after you input your current conditions, the Fishing Plan displays baits based on those inputs. The Fishing Plan also displays information about using those baits and pictures of the baits, in case you are unfamiliar with the bait.


