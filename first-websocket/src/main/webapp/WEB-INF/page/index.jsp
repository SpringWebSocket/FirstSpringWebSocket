<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Question - WebSocket</title>
</head>
<body>
	<center>
		<form action="/post-question" method="POST">
			<input type="text" name="question" placeholder="Post your question here..." />
			<input type="submit" value="Send" />
		</form>
		<div class="message">
			<table>
				<tr>
					<td>Message</td>
				</tr>
			</table>
		</div>
	</center>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/web-socket-js/1.0.0/web_socket.min.js"></script>
	<script>
		$(document).ready(function(){
			
			var ws = new WebSocket('ws://localhost:5555/question');
			
			ws.onmessage = function(data){
				console.log("return data: ", data);
				console.log(data.data);
				$('table').append("<tr><td>" + data.data + "</td></tr>");
			};
			
			ws.onopen = function() {
			    ws.send("Hello");  // Sends a message.
			};
			
			ws.onclose = function() {
				alert("closed");
			};
			
			$('form').submit(function(event){
				event.preventDefault();				
				ws.send($('input[name=question]').val());
				
				/* $.ajax({
					url: '/post-question',
					method: 'POST',
					data:{
						"question": $('input[name=question]').val()
					},
					success: function(response){
						console.log(response);
					},
					error: function(response){
						console.log(response);
					}
				}); */
				
			});
			
		});
	</script>	

</body>
</html>