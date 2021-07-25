<!DOCTYPE html>
<html>
	<head>
		<title>Welcome Page</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<style>
        table {
            margin: 50px 130px 130px 130px;
            text-align: center;
        }
        .container { 
            position: relative;
            }

        .center {
            margin: 0;
            position: relative;
            top: 50%;
            left: 50%;
            -ms-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
        }
        #modal {
            position: absolute;
            z-index: 99;
            top: 25%;
            width: 400px;
            height: 300px;
            margin: auto;
            display: none;
        }

        #logout {
            float: right;
        }
    </style>
    </head>
	<body>
        <button id="logout" onclick="location.href = '/ERS2/index.html';" class="btn btn-danger">Logout</button>

		<table id="usertable" class="table table-striped" style="width: 70%;">
            <tr>
                <th>Full Name</th>
            </tr>
            <tr>
                <td id="name"></td>
            </tr>
            <tr>
                <th>Position</th>
            </tr>
            <tr>
                <td id="position"></td>
            </tr>
        </table>
    </br>
    </br>
    <div class="container">
        <div class="center">
            <button id="srr" data-toggle="modal" data-target="#submitRequestModal" class="btn btn-primary mb-3">Submit Reimbursement Request</button>
            <button id="updateInfo" data-toggle="modal" data-target="#updateModal" class="btn btn-primary mb-3">Update Information</button>
            <button id="registerE" data-toggle="modal" data-target="#RegisterModal"  class="rne btn btn-primary mb-3">Register New Employee</button>
        </div>
    </div>
    <table id="requesttable" class="table table-striped" style="width: 70%;">
        <tr id="headerrow">
            <th>Request ID</th>
            <th>Status</th>
        </tr>
    </table>

  <!-- Modal -->
  <div class="modal fade" id="updateModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Update Information</h4>
        </div>
        <div class="modal-body">
            <form action="updateController" method="post">  
                <label class="form-label">Old Username:</label><input class="form-control" type="text" name="oldUsername"/><br/><br/> 
                <label class="form-label">New Username:</label><input class="form-control" type="text" name="username"/><br/><br/>  
                <label class="form-label">New Password:</label><input class="form-control" type="password" name="userpass"/><br/><br/>  
                <input type="submit" value="Submit"/>  
                </form>  
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>

    <!-- Modal -->
    <div class="modal fade" id="RegisterModal" role="dialog">
        <div class="modal-dialog">
        
          <!-- Modal content-->
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal">&times;</button>
              <h4 class="modal-title">Register New Employee</h4>
            </div>
            <div class="modal-body">
                <form action="RegisterEmployeeController" method="post">  
                    <label class="form-label">Full Name:</label><input class="form-control" type="text" name="name"/><br/><br/> 
                    <label class="form-label">Username:</label><input class="form-control" type="text" name="username"/><br/><br/>  
                    <label class="form-label">Password:</label><input class="form-control" type="password" name="userpass"/><br/><br/>
                    <label class="form-label">Position:</label>
                    <select name="position">
                        <option value="mgr">Manger</option>
                        <option value="non-mgr">Non-Manger</option>
                    </select><br/><br/>  
                    <input type="submit" value="Submit"/>  
                    </form>  
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
          </div>
          
        </div>
      </div>

          <!-- Modal -->
    <div class="modal fade" id="submitRequestModal" role="dialog">
        <div class="modal-dialog">
        
          <!-- Modal content-->
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal">&times;</button>
              <h4 class="modal-title">Submit Reimbursement Request</h4>
            </div>
            <div class="modal-body">
                <form action="submitRequest" method="post">  
                    <h2> Please Enter Your Username and Password to Submit a Reimbursement Request</h2>
                    <label class="form-label">Username:</label><input class="form-control" type="text" name="username"/><br/><br/>  
                    <label class="form-label">Password:</label><input class="form-control" type="password" name="userpass"/><br/><br/>

 
                    <input type="submit" value="Submit"/>  
                    </form>  
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
          </div>
          
        </div>
      </div>

	<script>

function requestProcess(e){
  let status = e.getAttribute("status");
  let requestId = e.getAttribute("requestId");

  let url = "http://localhost:9090/ERS2/requestProcess?status=" + status +"&requestId="+requestId;
  
  let headers = {
   "Content-Type": "application/json",                                                                                                
   "Access-Control-Origin": "*"
}

  fetch(url, {
    method: "POST",
    headers: headers,
    body:  JSON.stringify({"status":status, "requestId":requestId})
}).then(function(response){ 
    location.reload(); 
});

}
			let t = "http://localhost:9090/ERS2/test?username=${username}";
            
            fetch(t)
                .then(resp => resp.json())
                .then(json => {
                    
                    json.forEach(e => {
                        document.querySelector("#usertable").setAttribute("position", e.position);
                        document.querySelector("#name").innerText = e.name;
                        if (e.position == "mgr"){
                        document.querySelector("#position").innerText = "Manger";
                        document.querySelector("#srr").setAttribute("hidden", true);
                        
                        }
                        else {
                        document.querySelector("#position").innerText = "Non-Manger";
                        document.querySelector("#registerE").setAttribute("Hidden", true);
                        }
                        // if(e.position !== "mgr")
                        //     document.querySelector("updateInfo").setAttribute("hidden", true);
                        // if(e.position === "mgr") 
                        //     document.querySelector("#srr").setAttribute("hidden", true);
                        

                            let request;
                            if (document.querySelector("#usertable").getAttribute("position") === "mgr") {
                            request = "http://localhost:9090/ERS2/request/";
                            }
                            else {
                            request = "http://localhost:9090/ERS2/request?username=${username}";
                            }

                            fetch(request)
                            .then(resp => resp.json())
                            .then(json => {
                                const j = document.querySelector("#requesttable tbody");
                                if (document.querySelector("#usertable").getAttribute("position") == "mgr"){
                                    const hr = document.querySelector("#headerrow");
                                    const th = document.createElement("th");
                                    hr.appendChild(th);
                                }
                                json.forEach(e => {
                                    if (document.querySelector("#usertable").getAttribute("position") == "mgr"){

                                    const i = document.createElement("tr");
                                    const h = document.createElement("td");
                                    j.appendChild(i);
                                    i.appendChild(h).innerHTML = e.requestId;

                                    const l = document.createElement("td");
                                    i.appendChild(l).innerHTML = e.status;

                                    const m = document.createElement("td");
                                    i.appendChild(m).innerHTML = "<button onclick='requestProcess(this)' requestId='" + e.requestId +"' status='approve' class='btn btn-success'>Approve</button><button onclick='requestProcess(this)' requestId='" + e.requestId +"' status= 'deny' class='btn btn-danger'>Deny</button>";

                                    }    else{

                                    const i = document.createElement("tr");
                                    const h = document.createElement("td");
                                    j.appendChild(i);
                                    i.appendChild(h).innerHTML = e.requestId;

                                    const l = document.createElement("td");
                                    i.appendChild(l).innerHTML = e.status;  
                                    }
                                })
                            });
                    })
                });

    </script>
	</body>
</html>