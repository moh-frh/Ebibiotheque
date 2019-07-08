<!DOCTYPE html>
<html lang="en">
<head>
<title> BookInim </title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="OneTech shop project">
<meta name="viewport" content="width=device-width, initial-scale=1">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

</head>

<body >


<%@page import="com.servlets.Login.Connect" %>
<%@page import="com.mysql.jdbc.Connection" %>




<%@ include file="inclusions/links.jsp" %>

<div class="super_container">

<%@ include file="inclusions/header.jsp" %>
	
			
	

		

	

	<!-- Best Sellers -->

	<div class="best_sellers">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="tabbed_container">
    

						<div class="bestsellers_panel panel active">

							<div class="bestsellers_slider slider">
							
							
							<% int i=0; %>
							
								<c:forEach items="${livres}" var="livre" >
								<!-- Best Sellers Item -->
								<% i++; %>
								<div class="bestsellers_item discount">
									<div class="bestsellers_item_container d-flex flex-row align-items-center justify-content-start">
										<div class="bestsellers_image"><img src="images/bb.jpg" alt=""></div>
										<div class="bestsellers_content">
											<div class="bestsellers_category"><a href="#"><p><c:out value="${ livre.titre }" /> </p></a></div>
											<div class="bestsellers_name"><a href="product.html"> <p>domaine : <c:out value="${ livre.domaine }" /> </p> </a></div>
											<div class="rating_r rating_r_4 bestsellers_rating"><i></i><i></i><i></i><i></i><i></i></div>
											<div class="bestsellers_price discount"><p><c:out value="${ livre.resume }" /> </p></div>
										</div>
									</div>
									<div class="bestsellers_fav active"><i class="fas fa-heart"></i></div>
									<ul class="bestsellers_marks">
										<li class="bestsellers_mark bestsellers_discount"><p class="btn btn-secondary"><c:out value="${ livre.nbpage }" /> </p></li>
										
									</ul>
								</div>

							</c:forEach>
							
							<% System.out.print(i); %>

						
							</div>
						</div>

					
					</div>
						
				</div>
			</div>
		</div>
	</div>



	<%@ include file="inclusions/footer.jsp" %>
</div>


<script src="js/jquery-3.3.1.min.js"></script>
<script src="styles/bootstrap4/popper.js"></script>
<script src="styles/bootstrap4/bootstrap.min.js"></script>
<script src="plugins/greensock/TweenMax.min.js"></script>
<script src="plugins/greensock/TimelineMax.min.js"></script>
<script src="plugins/scrollmagic/ScrollMagic.min.js"></script>


<script src="plugins/greensock/animation.gsap.min.js"></script>
<script src="plugins/greensock/ScrollToPlugin.min.js"></script>
<script src="plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="plugins/slick-1.8.0/slick.js"></script>
<script src="plugins/easing/easing.js"></script>
<script src="js/custom.js"></script>

<script src="js/clock.js"></script>


</body>

</html>