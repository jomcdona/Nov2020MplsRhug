#Helper script for deploying camelk integration route using kamel cli
#The <server> entry in oc login needs to be updated relative to cluster
#api endpoint
oc login -u pactdev --server=<server>
oc whoami
oc project pact
kamel run -d mvn:org.apache.clerezza.ext:org.json.simple:0.4 ../pactcamelkrte/PactTranslationBridge.java
