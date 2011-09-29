	<h1 align="center">
		<spring:message code="application.name" />
	</h1>

	<table>
		<td valign="top"  width="12%">
			<div class="page">
			<table class="silver">
				<tr>
					<td>
						<spring:message code="game.player.information" /><br>
						Name:   ${info.getStringValue("name")}<br>
						Money:  $${info.getIntValue("user.money")}<br>
						Energy: ${info.getIntValue("current.energy")}/${info.getIntValue("maximum.energy")}
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