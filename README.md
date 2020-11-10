# November 2020 Minneapolis RHUG

## Description
This respository contains assets used in the demonstration on Event Driven Computing - The Next Frontier held in the Minneapolis
November 17, 2020 Red Hat User Group.  The main assets in the repository are contained in the sub folders and are the following

- **pactproducer**\
This is a service that provides the REST endpoint which is the entry point into collecting intial data about a contact event.  The
service is developed in java SpringBoot and is deployed as a knative service on OpenShift.  The service is exposed via an HTTP POST at /pact/producer and receives a commma delimited payload under the key of message.  The payload format is id1,id2,gpsloc1,gpsloc2 
(ex: 1,2,44.986656,-93.258133).  The payload is placed on a kafka topic.

- **pactquerysvc**\
This is a service that provides a REST endpoint which is used to query the data that has been collected throughout the process in a
series of event streams.  The service is developed in java SpringBoot and is deployed using a kubernetes deployment to OpenShift.
The service is exposed via an HTTP GET and exposes two endpoints /findcontactbystate?state=<state> and /findcontactbycountry?country=<country>

- **pact-contact-log**\
This is a service that provides a Kubernetes service endpoint which is bound to by a knative event source and persists the data
it receives in a Postgresql database

- **pactcamelkrte**\
This is a camelk integration route implemented in java DSL which uses camel kafka connector to consume data from a kafka topic, enriches
the data using a MapQuest API to add address information based on gps coordinate input it receives, and then places enriched data onto a
kafka topic

The following image illustrates the flow between the service components of the demo

<img src=images/demoarchitecture.jpg>

## Demo Pre-requisites
1. An OpenShift 4.5(+) cluster
2. Installation of ko cli for deploying kubernetes CRD's for knative kafka source (<https://github.com/google/ko>)
3. Installation of oc command line interface
4. Installation of Knative kn command line interface
5. Installation of Tekton tkn command line interface
