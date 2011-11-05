<div class="home"><div class="center">
	<h2 align="center">
		<spring:message code="game.home"/>
	</h2>
	<spring:message code="game.inventory"/>
	<table class="silver">
		<tr>
			<th width="200"><spring:message code="game.name"/></th>
			<th width="125"><spring:message code="game.value"/></th>
			<th width="125"><spring:message code="game.quantity"/></th>
		</tr>
		<c:forEach items="${info.getItemList()}" var="inventoryEntry">
			<tr>
				<td>${inventoryEntry.name}</td>
				<td>$${info.getSellValue(inventoryEntry)}</td>
				<td>${inventoryEntry.quantity}</td>
			</tr>
		</c:forEach>
	</table>
	<spring:message code="game.known.recipes"/>
	<table class="silver">
		<tr>
			<th width="200"><spring:message code="game.name"/></th>
			<th width="250"><spring:message code="game.resources"/></th>
		</tr>
		<c:forEach items="${info.getRecipeList()}" var="inventoryEntry">
			<tr>
				<td>${inventoryEntry.name}</td>
				<td>${inventoryEntry.getIntValue("resources.needed")}</td>
			</tr>
		</c:forEach>
	</table>
</div></div>