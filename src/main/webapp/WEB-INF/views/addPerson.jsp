<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="shared/header.jsp" />
<script type="text/javascript">
    jQuery(document).ready( function() {
        $("#menu_item_add_person").addClass("active");
    });
</script>
<div class="row">
    <Br/>
    <div class="col-md-2"></div>
    <div class="col-md-4">
        <c:if test="${not empty error}">
            <div class="alert alert-danger" role="alert">
            ${error}
        </div>
        </c:if>
        <c:if test="${not empty message}">
            <div class="alert alert-success" role="alert">
                ${message}
            </div>
        </c:if>
        <form action="<c:url value="/persons/add"/>" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <div class="label">File</div>
                <input type="file" name="file" />
            </div>
            <input type="submit" value="send" />
        </form>
    </div>
</div>
<jsp:include page="shared/footer.jsp" />
