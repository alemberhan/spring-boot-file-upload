<html>
<head>
<title>Spring Boot File Upload</title>
</head>

<body>
	<h3>File Upload:</h3>
	<h3 style="color: red;">${message}</h3>
	Select a file to upload:
	<br />
	<form action="/upload" method="post" enctype="multipart/form-data">
		<input type="file" name="file" /> <br /> <br /> <input
			type="submit" value="Upload File" />
	</form>
</body>

</html>