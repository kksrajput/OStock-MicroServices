# OStock-MicroServices
An Asset Management product which provides coverage for inventory, licensing, compliance cost and resource managementCancel changes



All the services are in the service folder.
V1 consists of first iteration , services folder is current iteration

# Licensing Service
Just Started with the Licensing Service-
To Do-
Service, apis for crud
Configuration Management Service
api examples
--post
http://localhost:8080/v1/organization/s/license/
--body
{
    "licenseId": "012345678",
    "organizationId":"product1",
    "description":"Software Product",
    "productName":"OStock",
    "licenseType":"full"

}
--get
http://localhost:8080/v1/organization/s/license/012345678


--Due to mac m1 and beyond chips-- fabric8io/docker-maven-plugin is used

# To Run

Open Services--

clean package
package docker:build
docker run --publish 8080:8080 optimagrowth/licensing-service
