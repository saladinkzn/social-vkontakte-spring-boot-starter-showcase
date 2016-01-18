<html>
    <head>

    </head>
    <body>
        <#if profiles?? && profiles?has_content>
            <ul>
            <#list profiles as profile>
                <li>${profile.firstName} ${profile.lastName}</li>
            </#list>
            </ul>
        </#if>
    </body>
</html>