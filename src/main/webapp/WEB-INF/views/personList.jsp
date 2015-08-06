<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="shared/header.jsp" />
<script type="text/javascript">
    jQuery(document).ready( function() {
        $("#menu_item_persons").addClass("active");
    });
</script>
<div class="row">
    <Br/>
    <table class="table table-hover">
        <caption>Person List</caption>
        <thead>
            <tr>
                <th><a href="<c:url value="/persons?sortby=name"/>">Name</a></th>
                <th><a href="<c:url value="/persons?sortby=surname"/>">Surname</a></th>
                <th><a href="<c:url value="/persons?sortby=login"/>">Login</a></th>
                <th><a href="<c:url value="/persons?sortby=email"/>">Email</a></th>
                <th><a href="<c:url value="/persons?sortby=phone"/>">Phone Number</a></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="person" items="${personList}">
                <tr>
                    <td>${person.name}</td>
                    <td>${person.surname}</td>
                    <td>${person.login}</td>
                    <td>${person.email}</td>
                    <td>${person.phoneNumber}</td>
                    <td>
                        <form action="<c:url value="/persons/delete/${person.login}"/>" method="post">
                            <input type="submit" value="delete" />
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="row">
        <nav>
            <ul class="pager">
                <c:if test="${pageNumber >= 2}">
                    <c:if test="${empty sortBy}">
                        <li class="previous">
                            <a href="<c:url value="/persons/page/${pageNumber - 1}"/>">
                                <span aria-hidden="true">&larr;</span> Previous
                            </a>
                        </li>
                    </c:if>
                    <c:if test="${not empty sortBy}">
                        <li class="previous">
                            <a href="<c:url value="/persons/page/${pageNumber - 1}/?sortby=${sortBy}"/>">
                                <span aria-hidden="true">&larr;</span> Previous
                            </a>
                        </li>
                    </c:if>
                </c:if>
                <c:if test="${isNextPage}">
                    <c:if test="${empty sortBy}">
                        <li class="next">
                            <a href="<c:url value="/persons/page/${pageNumber + 1}"/>">
                                Next <span aria-hidden="true">&rarr;</span>
                            </a>
                        </li>
                    </c:if>
                    <c:if test="${not empty sortBy}">
                        <li class="next">
                            <a href="<c:url value="/persons/page/${pageNumber + 1}/?sortby=${sortBy}"/>">
                                Next <span aria-hidden="true">&rarr;</span>
                            </a>
                        </li>
                    </c:if>
                </c:if>
            </ul>
        </nav>
    </div>
</div>
<jsp:include page="shared/footer.jsp" />

