<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>
</head>

<body>

<form name="rabbitmqCredentials" action="connect/print">
    <input type="text" name="username"/>
    <label for="username">Username</label>
    <br>
    <input type="password" name="password"/>
    <label for="password">Password</label>
    <br>
    <input type="text" name="host"/>
    <label for="host">Host</label>
    <br>
    <input type="text" name="virtualHost"/>
    <label for="virtualHost">Virtual Host</label>
    <br>
    <input type="text" name="queueName" value="testQueue"/>
    <label for="queueName">Queue Name</label>
    <br>
    <input type="text" name="numberOfMessages"/>
    <label for="numberOfMessages">How Many Message Do you want to received</label>
    <br>
    <input type="submit" value="Receive Messages"/>
</form>

<g:if test="${flash.message}">
    <g:each in="${flash.message.split(" ::")}">
        <p>Got: ${it}</p>
    </g:each>
</g:if>


</div>

</body>
</html>
