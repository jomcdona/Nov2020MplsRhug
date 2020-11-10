#helper script used to deploy knative eventing kafa source CRD's into 
#OCP cluster, <user> and <server> entries must be updated reflective
#of your environment.  The ko create command requires a docker repository
#and login to the repository prior to running.  Also requires what is outlined
#in pre-requisites step 3 & 4
oc login -u <user> --server=<server>
oc project pact
docker login
ko create -f $HOME/go/src/knative.dev/eventing-contrib/kafka/source/config/
