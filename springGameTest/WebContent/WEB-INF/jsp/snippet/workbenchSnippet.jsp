	<h2 align="center">
		<spring:message code="game.workbench"/>
	</h2>

	<c:choose>	
	<c:when test="${info.viewPage == 'select'}">
<%@ include file="workbenchSelectSnippet.jsp"%>
    </c:when>
    <c:otherwise>
    	<c:if test="${info.viewPage == 'craft'}">
<%@ include file="workbenchCraftSnippet.jsp"%>
		</c:if>
    </c:otherwise>
    </c:choose>
	
	<spring:message code="game.known.recipes"/>
	<table class="silver">
		<tr>
			<th width="200"><spring:message code="game.name"/></th>
			<th width="280"><spring:message code="game.resources"/></th>
		</tr>
		<c:forEach items="${info.getRecipeList()}" var="inventoryEntry">
			<tr>
			<form action="workbenchSelect.html" method="get">
				<td>${inventoryEntry.name}</td>
				<td>${inventoryEntry.getIntValue("resources.needed")}</td>
				<td>
					<input type="hidden" name="recipeId" value=${inventoryEntry.itemId} />
					<input type="submit" value=<spring:message code="game.select"/> />
				</td>
			</form>
			</tr>
		</c:forEach>
	</table>