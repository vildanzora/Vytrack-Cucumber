Feature: Users should see Export Grid dropdown, Refresh, Reset, and Grid Settings Buttons


	@B26G18-106
	Scenario Outline: TC001_Vytrack => Fleet => Vehicles

		Given user enter valid "<Username>" and valid "<Password>"
		When User can click Vehicles button under the Fleet Module
		When Export Grid dropdown is on the left of the page
		When User should be able to click refresh button
		When User should be able click reset button
		When User should be able to click Grid Settings button
		Then Refresh button should be on the left side of Reset button
		Then Grid Settings should be on the right side of the Reset button
		Then Grid Setting button is on the right of the page 
		
		Examples:
		|Username|Password|
		|user152|UserUser123|


