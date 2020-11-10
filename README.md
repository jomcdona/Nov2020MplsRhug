# November 2020 Minneapolis RHUG

## Description
This respository contains assets used in the demonstration on Event Driven Computing - The Next Frontier held in the Minneapolis
November 17, 2020 Red Hat User Group.  The main assets in the repository are contained in the sub folders and are the following

- pactproducer
This is a service that provides the REST endpoint which is the entry point into collecting intial data about a contact event.  The
service is developed in java spring boot and is deployed as a knative service.  The service is contact via an HTTP POST verb and receives
a commma delimited payload under the key of message.  The payload format is id1,id2,gpsloc1,gpsloc2 (ex: 1,2,44.986656,-93.258133).
The payload is placed on a kafka topic.

- pactquerysvc
This is a service that provides a REST endpoint which   

<img src=images/demoarchitecture.jpg>
