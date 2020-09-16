<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang=uk-in>
<!-- Simple Web Calculator page -->
<head>
<meta charset="ISO-8859-1">
<title>Simple Arithmetic Calculator</title>
</head>
<body>
<h1>Simple Arithmetic Calculator</h1>
    <form id="calcform" method="post">
    	<table role="presentation">
    		<tr>
    			<td>Number 1 :</td>
    			<td>
    				<input type="text" id='inum1' name="num1" style="text-align:right;" maxlength=15 value="${num1}" required />
    			</td>
    		</tr>
    		<tr>
    			<td>Number 2 :</td>
    			<td>
    				<input type="text" id='inum2' name="num2" style="text-align:right;" maxlength=15 value="${num2}" required />
    			</td>
    		</tr>
    		<tr>
    			<td>Operation :</td>
    			<td>
    				<select id="sel" name="operation" required>
        				<option value="+"> + </option>
        				<option value="-"> - </option>
        				<option value="*"> x </option>
        				<option value="/"> / </option>
        			</select>
        			<script type="text/javascript">
                    	document.getElementById('sel').value = "${operation}";
                    	function fnFormReset(){
                        	document.getElementById('inum1').value = "";
                        	document.getElementById('inum2').value = "";
                        	document.getElementById('sel').value = "";
                        	document.getElementById('ires').value = "";
                        	document.getElementById('eMes').innerHTML = "";
                        }
        			</script>
    			</td>
    		</tr>
    		<tr>
    			<td>Result :</td>
    			<td>
    				<input type="text" id="ires" name="result" maxlength=15 style="text-align:right;" value="${rresult}" readonly/>
    			</td>
    		</tr>
      		<tr>
    			<td><input type="submit" value="Submit"/></td>
    			<td>
    				<input type="button" id="irbut" name="reset" value="Reset" onclick="fnFormReset();" />
    			</td>
    		</tr>
    		<tr>
    			<td colspan=5><div id="eMes" style="color: red;">${eMsg}</div></td>
    		</tr>
    	</table>
    </form>
</body>
</html>