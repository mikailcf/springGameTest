<div class="market">
   <h2 align="center">
		<spring:message code="game.market"/>
	</h2>
	<spring:message code="game.your.items"/>
	<table class="silver">
		<tr>
			<th width="200"><spring:message code="game.name"/></th>
			<th width="100"><spring:message code="game.value"/></th>
			<th width="100"><spring:message code="game.quantity"/></th>
		</tr>
		<c:forEach items="${info.getItemList()}" var="inventoryEntry">
			<tr>
			<form action="marketSell.html" method="get">
				<td>${inventoryEntry.name}</td>
				<td>$${info.getSellValue(inventoryEntry)}</td>
				<td>${inventoryEntry.quantity}</td>
				<td>
					<input type="hidden" name="itemId" value=${inventoryEntry.itemId} />
					<input type="submit" value=<spring:message code="game.sell"/> />
				</td>
			</form>
			</tr>
		</c:forEach>
	</table>
	<spring:message code="game.items.in.the.market"/>
	<table class="silver">
		<tr>
			<th width="200"><spring:message code="game.name"/></th>
			<th width="100"><spring:message code="game.value"/></th>
			<th width="100"><spring:message code="game.quantity"/></th>
		</tr>
		<c:forEach items="${info.getMarketItemList()}" var="marketEntry">
			<tr>
			<form action="marketBuy.html" method="get">
				<td>${marketEntry.name}</td>
				<td>$${info.getBuyValue(marketEntry)}</td>
				<td><input type="text" name="buyingQuantity" size="7" maxlength="6"/></td>
				<td>
					<input type="hidden" name="itemId" value=${marketEntry.itemId} />
					<input type="submit" value=<spring:message code="game.buy"/> />
				</td>
			</form>
			</tr>
		</c:forEach>
	</table>
</div>