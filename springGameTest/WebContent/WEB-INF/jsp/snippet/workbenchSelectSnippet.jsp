	<spring:message code="game.you.are.about.to.craft.one"/>
	${info.selectedRecipe.name}<br>
	<spring:message code="game.available.resources"/>
	<table class="silver">
		<tr>
			<th width="200"><spring:message code="game.name"/></th>
			<th width="125"><spring:message code="game.value"/></th>
			<th width="125"><spring:message code="game.quantity"/></th>
		</tr>
		<c:forEach items="${info.getAvailableResourceList()}" var="inventoryEntry">
			<tr>
			<form action="workbenchCraft.html" method="get">
				<td>${inventoryEntry.name}</td>
				<td>$${info.getSellValue(inventoryEntry)}</td>
				<td>${inventoryEntry.quantity}</td>
				<td>
					<input type="hidden" name="recipeId"
						value=${info.selectedRecipe.itemId} />
					<input type="hidden" name="resourceId" value=${inventoryEntry.itemId} />
					<input type="submit" value=<spring:message code="game.craft"/> />
				</td>
			</form>
			</tr>
		</c:forEach>
	</table>