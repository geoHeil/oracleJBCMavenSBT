# oracle jdbc via sbt or maven
How can I configure maven or oracle to correctly download the oracle JDBC driver jar?
http://stackoverflow.com/questions/43950455/sbt-download-artifact-from-password-protected-repository-oracle-jdbc-driver-as

```
mvn -s settings.xml package
```
fails with unauthorized error:

```
Could not resolve dependencies for project attma:ora:jar:1.0-SNAPSHOT: Failed to collect dependencies at com.oracle.jdbc:ojdbc8:jar:12.2.0.1: Failed to read artifact descriptor for com.oracle.jdbc:ojdbc8:jar:12.2.0.1: Could not transfer artifact com.oracle.jdbc:ojdbc8:pom:12.2.0.1 from/to maven.oracle.com (https://maven.oracle.com): Not authorized , ReasonPhrase:Unauthorized.
```

but the same credentials can be used to successfully login at https://login.oracle.com/mysso/signon.jsp


in SBT

```
sbt assembly
```

will error out with

```
[error] Unable to find credentials for [OAM 11g @ login.oracle.com].
[error]   Is one of these realms misspelled for host [login.oracle.com]:
[error]   * WebLogic Server
```
for credentials of `credentials += Credentials("WebLogic Server", "login.oracle.com", "asdf5kklwr@gmail.com", "12345678GroßKlein")`

but when choosing `OAM 11g` as realm like
```
credentials += Credentials("OAM 11g", "login.oracle.com", "asdf5kklwr@gmail.com", "12345678GroßKlein")
```

it fails with the same error.