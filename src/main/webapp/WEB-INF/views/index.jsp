<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<jsp:include page="shared/header.jsp" />
<script type="text/javascript">
	jQuery(document).ready( function() {
		$("#menu_item_index").addClass("active");
	});
</script>
<div class="container-fluid">
	<Br/>
	<div class="row well">
		<p>
			<h4>
				В качестве уникального ключа для операций обновления у удаления выбран логин(login)
			</h4>
		</p>
		<p>
			<h4>
				При добавдении происходит автоматическое обновление если запись с таким логином существует
			</h4>
		</p>

	</div>
</div>
<jsp:include page="shared/footer.jsp" />