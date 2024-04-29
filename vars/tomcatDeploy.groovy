def call(ip,user,credId){
   sshagent([credId]) {
     sh "mv target/myweb*.war target/myweb.war"
     sh "scp -o StrictHostKeyChecking=no target/myweb.war ${user}@${ip}:/opt/tomcat9/webapps"
     sh "ssh ${user}@${ip} /opt/tomcat9/bin/shutdown.sh"
     sh "ssh ${user}@${ip} /opt/tomcat9/bin/startup.sh"
   }
}
