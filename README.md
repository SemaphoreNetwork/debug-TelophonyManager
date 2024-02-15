This is a project only for team debugging. 
* keys/testkey can be used to sign apk.
  - key store password: 123456
  - key alias: testkey
  - key passworkd: 123456
 
* binaries/app-debug.apk is an apk signed with testkey.
  - to check an apk's certificate's sha1 string:
    - rename the the .apk to .zip
    - unzip it
    - enter META-INF folder
    - make sure CERT.RSA is there
    - execute: "keytool -printcert -file CERT.RSA"
   
