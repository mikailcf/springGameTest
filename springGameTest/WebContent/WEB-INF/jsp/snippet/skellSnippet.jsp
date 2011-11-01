	<h1 align="center">
		<spring:message code="application.name" />
	</h1>

	<table class="silver">
		<tr>
			<td>
				<spring:message code="game.player.information" /><br>
				Name:   ${info.user.name}<br>
				Money:  $${info.user.money}<br>
				Energy: ${info.user.energy}/${info.user.maxEnergy}
			</td>
		</tr>
		<tr>
			<td><a href="index.html">
				<spring:message code="game.home" /> </a>
			</td>
		</tr>
		<tr>
			<td><a href="workbench.html">
				<spring:message code="game.workbench" /> </a>
			</td>
		</tr>
		<tr>
			<td><a href="market.html">
				<spring:message code="game.market" /> </a>
			</td>
		</tr>
		<tr>
			<td><!--a href="tavern.html"-->
				<spring:message code="game.tavern" /> </a>
			</td>
		</tr>
		<tr>
			<td><!--a href="guild.html"-->
				<spring:message code="game.guild" /> </a>
			</td>
		</tr>
		<tr>
			<td><!--a href="castle.html"-->
				<spring:message code="game.castle" /> </a>
			</td>
		</tr>
	</table>