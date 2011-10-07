			</div>
		</td>
		<td valign="top" width="40%">
			<div class="page">
				<h2 align="center">
					<spring:message code="game.events"/>
				</h2>
				<br>
	<c:forEach items="${info.getEventList()}" var="event">
 		<c:if test="${!event.isEmpty()}">
			<fmt:formatDate	type="both" dateStyle="short" timeStyle="default"value="${event.date}"/>
			<c:if test="${event.isNew()}">
				<text class="new"><spring:message code="game.new.exclamation"/></text>
			</c:if>
			${event.message}
		</c:if><br>
	</c:forEach>
	
	
	Debug<br>
	<c:forEach items="${info.getSkillList()}" var="skill">
			${skill.toString()}<br>
	</c:forEach>
	