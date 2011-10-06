	<spring:message code="game.you.crafted.one"/>
	${info.craftedItem.name}<br>
	<table class="silver">
		<tr>
			<th width="200"><spring:message code="game.name"/></th>
			<th width="125"><spring:message code="game.rating"/></th>
			<th width="125"><spring:message code="game.result"/></th>
		</tr>
		<tr>
			<td>Damage</td>
			<td>${info.getAbsoluteValue("damage")}</td>
			<td>${info.getPercentageValue("damage")}</td>
		</tr>
		<tr>
			<td>Handling</td>
			<td>${info.getAbsoluteValue("handling")}</td>
			<td>${info.getPercentageValue("handling")}</td>
		</tr>
		<tr>
			<td>Durability</td>
			<td>${info.getAbsoluteValue("durability")}</td>
			<td>${info.getPercentageValue("durability")}</td>
		</tr>
		<tr>
			<td>Style</td>
			<td>${info.getAbsoluteValue("style")}</td>
			<td>${info.getPercentageValue("style")}</td>
		</tr>
		<tr>
			<th>Overall</th>
			<th>${info.getAbsoluteValue("overall.rating")}</th>
			<th>${info.getPercentageValue("overall.rating")}</th>
		</tr>
	</table>