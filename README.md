# Alfresco Log Filter

> Simple Logging Filter for avoid logging solr requests

This simple library is used for avoid logging requests between Solr and Alfresco.

It works adding an request attribute if URL contains `/alfresco/service/api/solr`.
The same attribute is used for conditional logging. 

## Building

Build JAR with gradle:

```bash
gradle jar
```

## Installation

Put compiled JAR library into tomcat `lib` folder.

Then define a filter in `conf/web.xml`:

```xml
    <filter>
        <filter-name>AlfrescoLogFilter</filter-name>
        <filter-class>com.flosslab.tools.AlfrescoLogFilter</filter-class>
    </filter>

    <filter-mapping>
        <filter-name>AlfrescoLogFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
```

Add option **conditionUnless** in logging Valve in `conf/server.xml`:

```xml
        <Valve className="org.apache.catalina.valves.AccessLogValve" directory="logs"
               conditionUnless="doNotLog"
               prefix="localhost_access_log." suffix=".txt"
               pattern="%h %l %u %t &quot;%r&quot; %s %b" />
```
