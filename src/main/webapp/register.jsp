<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>MongoDb Login Servlet</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
    <!-- Pooper & Bootstrap js/css File -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
    <link rel="stylesheet" href="https://bootswatch.com/4/flatly/bootstrap.min.css">
    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
      integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
      integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
      crossorigin="anonymous"
   	></script>
   	 
    <!-- jQuery Files -->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<!--<script type="text/javascript" src="resource/js/form_login.js"></script>-->
</head>
<body>
    <div id="mongoDbServlet" class="container">
          <!--  <form id="user_login_form" name="loginForm" method="post" action="loginServlet">-->
                <!----- REGISTRATION FORM ------>
                <div class="row mt-5">
				    <div class="col-md-6 m-auto">
				      <div class="card card-body">
				        <h1 class="text-center mb-3">
				          <i class="fas fa-user-plus"></i> Register</h1>
				        <form id="user_register_form" name="registerForm" method="POST" action="registerServlet">
				            <div class="form-group">
				                <label for="email">Email</label>
				                <input
				                  type="email"
				                  id="email"
				                  name="email"
				                  class="form-control"
				                  placeholder="Enter Email"
				                />
				              </div>
				              <div class="form-group">
				                <label for="password">Password</label>
				                <input
				                  type="password"
				                  id="password"
				                  name="login_pwd"
				                  class="form-control"
				                  placeholder="Create Password"
				                />
				              </div>
				              <div class="form-group">
				                <label for="password2">Confirm Password</label>
				                <input
				                  type="password"
				                  id="password2"
				                  name="password2"
				                  class="form-control"
				                  placeholder="Confirm Password"
				                />
				              </div>
				
				          </div>
				          <button type="submit" class="btn btn-primary btn-block">
				            Register
				          </button>
				        </form>
				      </div>
				    </div>
				  </div>

              
       </div>
       <br>
       <div>
       <h4 id="back" align="center"><a href="index.jsp">Back to Login</a></h4>
       <h4 id="errMsg" class="text-danger" align="center">${error_message}</h4>
       </div>
</body>
</html>