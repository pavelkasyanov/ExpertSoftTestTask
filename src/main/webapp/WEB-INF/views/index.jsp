<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<jsp:include page="shared/header.jsp" />
<script type="text/javascript">
	jQuery(document).ready( function() {
		$("#menu_item_index").addClass("active");
	});
</script>
<h1>${message}</h1>
<a href="<c:url value="/persons"/>">Person list</a><Br />
<a href="<c:url value="/persons/add"/>">Add Persons</a>
<jsp:include page="shared/footer.jsp" />